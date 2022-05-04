package maven.com.lguplus.service.discount;

import maven.com.lguplus.domain.Entity.Grade;
import maven.com.lguplus.domain.Entity.Member;
import org.springframework.stereotype.Component;

public class FixedDiscountPolicy implements DiscountPolicy{

    private int discountFixedAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return discountFixedAmount;
        }

        return 0;
    }
}
