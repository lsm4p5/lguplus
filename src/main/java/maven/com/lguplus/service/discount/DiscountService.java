package maven.com.lguplus.service.discount;

import maven.com.lguplus.domain.primary.Entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DiscountService {

    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;

    public DiscountService(Map<String, DiscountPolicy> policyMap,
                           List<DiscountPolicy> policies) {
        this.policyMap = policyMap;
        this.policies = policies;
        System.out.println("===policyMap = " + policyMap);
        System.out.println("===policies = " + policies);
    }
    public int discount(Member member, int price, String discountCode) {
        DiscountPolicy discountPolicy = policyMap.get(discountCode);
        System.out.println("discountCode = " + discountCode);
        System.out.println("discountPolicy = " + discountPolicy);
        return discountPolicy.discount(member, price);
    }
}

