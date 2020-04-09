package simplest.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import simplest.strategy.discountpolicy.ReachOneHundredFortyOffPolicy;
import simplest.strategy.discountpolicy.TwentyPercentOffPolicy;

@Slf4j
class ShoppingCartTest {

    @Test
    void calcuateDiscount() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(new CartItem(1234001,"book1",30,1));
        shoppingCart.addToCart(new CartItem(1234002,"hard disk",600,1));

        log.debug("default no discout {}", shoppingCart.calcuateDiscount());

        shoppingCart.setDiscountPolicy(new ReachOneHundredFortyOffPolicy());
        log.debug("满100减40 discout {}", shoppingCart.calcuateDiscount());

        shoppingCart.setDiscountPolicy(new TwentyPercentOffPolicy());
        log.debug("8折 discout {}", shoppingCart.calcuateDiscount());

    }
}