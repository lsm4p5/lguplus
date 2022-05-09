package maven.com.lguplus.domain.primary.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString( of = {"id","loginname","username","age","homeAddress"})
@Table(uniqueConstraints={@UniqueConstraint(name="LOGIN_NAME_AGE_UNIQUE",columnNames = {"LOGINNAME","USERNAME","AGE"})})
@NamedQuery(
        name="Member.findByUsername",
        query = "select m from Member m where m.username =:username")
public class Member extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @NotEmpty
    private String loginname;

    private String email;
    private String username;
    private String password;
    private Integer age;

    //주소
    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column = @Column(name="WORK_CITY")),
            @AttributeOverride(name="street",column = @Column(name="WORK_STREET")),
            @AttributeOverride(name="zipcode",column = @Column(name="WORK_ZIPCODE"))
    })
    private Address workAddress;

    //Period
    @Embedded
    private Period workPeriod;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Enumerated(EnumType.STRING)
    private RolType roleType;

   @Lob
   private String description;

  //특정 필드를 컬럼에 매핑하지 않음(매핑 무시) - 테이블에 생성되지 않음.
   @Transient
   int tempVariable;

   @ElementCollection
   @CollectionTable(name ="FAVORITE_FODD",joinColumns = @JoinColumn(name="MEMBER_ID"))
   @Column(name="FOOD_NAME")
   private Set<String> favoriteFoods = new HashSet<>();

   // 컬렉션 값 Type은 사용하지 말고, 값 Type을 Entity로 만들어서 OneToMany, ManyToOne으로 사용해야 한다.
    // 추적할 필요없고 값이 바뀌어도 문제가 없을때에 대해서는 사용할수도 있을듯.
//   @ElementCollection
//   @CollectionTable(name ="ADDRESS",joinColumns = @JoinColumn(name="MEMBER_ID"))
//   private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

   // BasicEntity에 포함했고, Date를 Colum으로 사용하는 예시임. 과거의 Date때문...ㅎㅎ
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime createdDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    private Team team;

    /**
     * 연관관계 편의 메서드는 연관관계 주인이든, 주인이 아이어든 양쪽으로 변경을 해주어야 하고,
     * 연관관계 메서드는 한쪽에만 두어야 한다, 양쪽에 있으면 무한루프를 돌수 있다.
     * 또한 toString을 객체에 줄 경우 무한 루프에 빠지는 겅을 조심해야 한다. (양쪽에 toString이 되는 경우)
     * JSON 생성라이브러리를 만들때도 동일하게 무한루프가 될수 있다.
     * Controller에는 Entity를 절대 반환하지 않아야 한다.
     */
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public void changeLocker(Locker locker) {
        this.locker = locker;
        locker.setMember(this);
    }


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        this.team = team;
        if (team != null) {
            changeTeam(team);
        }
    }


    public Member(Long id, String username, Grade grade) {
        this.id = id;
        this.username = username;
        this.grade = grade;
    }

    public Member(String loginname, String username, String password, int age, Team team) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }

    /**
     *
     * @param loginname lotinId 임. Login시 session에 추가하고, interceptor에 의해서 Login을 핸들링함.
     * @param username 사용자 이름임.
     * @param password 사용자 비밀번호, 향후 암호화하여 저장해야 함
     * @param age      사용자 나이
     * @param homeAddress 사용자 주소, Address 객체를 사용하여 생성
     * @param workAddress 사용자 직장 주소, Address 객체를 사용하여 생성
     * @param workPeriod  사용자 직장 근무 기간
     * @param grade       사용자 등급
     * @param roleType    사용자 권한
     * @param description 사용자 설명
     * @param tempVariable  임시 variable
     * @param favoriteFoods 좋아하는 음식
     * @param addressHistory 사용자 직장 history
     * @param testLocalDate 임시 localdate
     * @param testLocalDateTime 임시 localdate
     * @param team          사용자 소속 Team
     * @param locker        사용자 locker
     * @param orders        사용자 주문리스트
     * @param memberProducts 사용자 물품리스트
     */

    /**
     * 객체 생성 순서
     *  1. loginname, username,password, age, homeAdress, workAddress, workPeriod, grade, roleType , description
     *  2. favoriteFodds 생성시에 Member에 추가
     *  3. addressHistory 생성시 Member에 추가
     *  4. team 생성시 Member -> Member.changeTeam(team)
     *  5. Locker 생성시 Member에 추가 -> Member.changeLocker(Locker locker) 호출
     *  6. Order 생성시 Member에 추가  -> 연관관계 Method는 Order에 생성
     *  7. Products 생성시 Member에 추가
     */
    public Member(String loginname, String email, String username, String password,
                  Integer age, Address homeAddress, Address workAddress,
                  Period workPeriod, Grade grade, RolType roleType,
                  String description, int tempVariable, Set<String> favoriteFoods,
                  List<AddressEntity> addressHistory, LocalDate testLocalDate, LocalDateTime testLocalDateTime,
                  Team team, Locker locker, List<Order> orders, List<MemberProduct> memberProducts) {
        this.loginname = loginname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.workPeriod = workPeriod;
        this.grade = grade;
        this.roleType = roleType;
        this.description = description;
        this.tempVariable = tempVariable;
        if (favoriteFoods != null) {
            this.favoriteFoods = favoriteFoods; // 연관관계 Method로 변경되어야함
        }
        if (addressHistory != null) {
            this.addressHistory = addressHistory; // 연관관계 Method로 변경되어야함
        }
        this.testLocalDate = testLocalDate;
        this.testLocalDateTime = testLocalDateTime;
        if(team != null){
            changeTeam(team); //Member의 연관관계 Method
        }
        if(locker != null){
            changeLocker(locker);//Member의 연관관계 Method
        }

        if(orders != null){
            this.orders = orders; // Order의 연관관계 Method로 변경되어야함.
        }
        if (memberProducts != null) {
            this.memberProducts = memberProducts;  // memberProducts의 연관관계 Method로 변경되어야함.
        }

    }
}
