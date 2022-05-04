package maven.com.lguplus.domain.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * 값 type은 불변으로 만들어야 한다. setter를 만들지 않고, 생성자로 초기화한다.
 */
@Embeddable
@Getter
@NoArgsConstructor
public class Address {

    @Column(length = 20)
    private String city;
    @Column(length = 40)
    private String street;
    @Column(length = 10)
    private String zipcode;

    public Address(String city, String street, String zipcode) {

        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String fullAdderess(){
        return getCity() + "|" +getStreet() +"|" + getZipcode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
