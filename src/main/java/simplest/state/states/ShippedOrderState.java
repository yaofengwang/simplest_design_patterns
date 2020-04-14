package simplest.state.states;

import lombok.extern.slf4j.Slf4j;
import simplest.state.Order;
import simplest.state.OrderStatus;

@Slf4j
public class ShippedOrderState implements IOrderState {

    @Override
    public Boolean canShip(Order order) {
        log.debug("{}","Shipped order can NOT ship again!");
        return false;
    }

    @Override
    public Boolean ship(Order order) {
        log.debug("{}","Shipped order can NOT ship again!");
        return false;
    }

    @Override
    public Boolean canCancel(Order order) {
        log.debug("{}","Shipped order can NOT be cancelled!");
        return false;
    }

    @Override
    public Boolean cancel(Order order)  {
        log.debug("{}","Shipped order can NOT be cancelled!");
        return false;
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.SHIPPED;
    }
}
