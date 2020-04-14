package simplest.state.states;

import lombok.extern.slf4j.Slf4j;
import simplest.state.Order;
import simplest.state.OrderStatus;

@Slf4j
public class NewOrderState implements IOrderState {

    @Override
    public Boolean canShip(Order order) {
        return true;
    }

    @Override
    public Boolean ship(Order order) {

        log.debug("{}","order is shipping");
        return true;
    }

    @Override
    public Boolean canCancel(Order order) {
        return true;
    }

    @Override
    public Boolean cancel(Order order) {
        order.changeState(new CancelledOrderState());
        log.debug("{}","order is cancelling");
        return true;
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.NEW;
    }
}
