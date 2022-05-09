package maven.com.lguplus.service.discount;

import maven.com.lguplus.domain.primary.Entity.Grade;
import maven.com.lguplus.domain.primary.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscountServiceTest {

    @Autowired
    DiscountService discountService;

    @Test
    public void findAllBean() {

        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 5500,
                "fixDiscountPolicy");

        System.out.println("discountPrice = " + discountPrice);

        int discountPrice2 = discountService.discount(member, 5500,
                "rateDiscountPolicy");

        System.out.println("discountPrice2 = " + discountPrice2);



    }



}