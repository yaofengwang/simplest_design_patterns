package simplest.state;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import simplest.state.states.CancelledOrderState;
import simplest.state.states.NewOrderState;
import simplest.state.states.ShippedOrderState;

@Slf4j
class OrderTest {

    @Test
    void changeState() {
        Order order = new Order(new NewOrderState());
        log.debug("current order state: {}", order.getOrderStatus());
        order.ship();
        order.cancel();
        order.changeState(new ShippedOrderState());
        log.debug("current order state: {}", order.getOrderStatus());
        order.ship();
        order.cancel();

        order.changeState(new CancelledOrderState());
        log.debug("current order state: {}", order.getOrderStatus());
        order.ship();
        order.cancel();

    }
}