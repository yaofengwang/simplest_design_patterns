package simplest.state.states;

import simplest.state.Order;
import simplest.state.OrderStatus;

public interface IOrderState
{
    Boolean canShip(Order order);
    Boolean ship(Order order);
    Boolean canCancel(Order order);
    Boolean cancel(Order order);
    OrderStatus getStatus();
}