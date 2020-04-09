package simplest.strategy.discountpolicy;

import simplest.strategy.CartItem;

import java.util.List;

public class NoDiscountPolicy implements DiscountPolicy {

    @Override
    public Double calcuateDiscount(List<CartItem> cartItems) {
        return 0.0;
    }
}
