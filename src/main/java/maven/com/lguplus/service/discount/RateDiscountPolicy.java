package maven.com.lguplus.service.discount;

import maven.com.lguplus.domain.primary.Entity.Grade;
import maven.com.lguplus.domain.primary.Entity.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price*discountPercent/100;
        }
        else{
            return 0;
        }

    }

}
