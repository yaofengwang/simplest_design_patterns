package simplest.strategy.discountpolicy;

import simplest.strategy.CartItem;

import java.util.List;

public interface DiscountPolicy {
    Double calcuateDiscount(List<CartItem> cartItems);

}
