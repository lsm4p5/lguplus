package maven.com.lguplus.service.discount;

import maven.com.lguplus.domain.primary.Entity.Grade;
import maven.com.lguplus.domain.primary.Entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
