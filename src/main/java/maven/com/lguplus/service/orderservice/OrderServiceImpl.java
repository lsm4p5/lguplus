package maven.com.lguplus.service.orderservice;

import lombok.RequiredArgsConstructor;
import maven.com.lguplus.domain.primary.Entity.Member;
import maven.com.lguplus.domain.primary.Entity.Order;
import maven.com.lguplus.repository.primary.MemberRepository;
import maven.com.lguplus.service.discount.DiscountPolicy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Optional<Member> memberOptional = memberRepository.findById(memberId);

        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            int discountPrice = discountPolicy.discount(member, itemPrice);
            return new Order(member, itemName, itemPrice, discountPrice);
        }

        return null ;
    }
}
