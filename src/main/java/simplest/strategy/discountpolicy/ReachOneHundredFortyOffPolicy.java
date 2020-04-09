package simplest.strategy.discountpolicy;

import simplest.strategy.CartItem;

import java.util.List;

public class ReachOneHundredFortyOffPolicy implements DiscountPolicy {

    @Override
    public Double calcuateDiscount(List<CartItem> cartItems) {
        Integer sum = cartItems.stream().mapToInt((item) -> item.getNum() * item.getUnitPrice()).sum();
        return sum > 100 ? 40.0 : 0.0;
    }
}
