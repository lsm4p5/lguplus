package maven.com.lguplus.service.discount;

import maven.com.lguplus.domain.Entity.Member;

public interface DiscountPolicy {

    /**
       @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
