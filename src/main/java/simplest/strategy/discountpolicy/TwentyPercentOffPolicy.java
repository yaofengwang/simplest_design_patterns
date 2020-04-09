package simplest.strategy.discountpolicy;

import simplest.strategy.CartItem;

import java.util.List;

public class TwentyPercentOffPolicy implements DiscountPolicy {

    @Override
    public Double calcuateDiscount(List<CartItem> cartItems) {
        return cartItems.stream().mapToInt((item) -> item.getNum() * item.getUnitPrice()).sum() * 0.2;
    }
}
