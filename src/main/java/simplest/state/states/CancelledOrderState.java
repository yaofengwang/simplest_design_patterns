package simplest.state.states;

import lombok.extern.slf4j.Slf4j;
import simplest.state.Order;
import simplest.state.OrderStatus;

@Slf4j
public class CancelledOrderState implements IOrderState {

    @Override
    public Boolean canShip(Order order) {
        log.debug("{}","Cancelled order NOT can ship again!");
        return false;
    }

    @Override
    public Boolean ship(Order order) {
        log.debug("{}","Cancelled order NOT can ship again!");
        return  false;
    }

    @Override
    public Boolean canCancel(Order order) {
        log.debug("{}","Cancelled order can NOT be cancelled again!");
        return false;
    }

    @Override
    public Boolean cancel(Order order) {
        log.debug("{}","Cancelled order can NOT be cancelled again!");
        return false;
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.CANCELED;
    }
}
