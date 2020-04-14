package simplest.state;

import simplest.state.states.IOrderState;

public class Order {
    private IOrderState orderState;

    public Order(IOrderState orderState){
        this.orderState = orderState;
    }

    public OrderStatus getOrderStatus(){
        return orderState.getStatus();
    }

    public Boolean canShip(){
        return  orderState.canShip(this);
    }

    public Boolean canCancel(){
        return  orderState.canCancel(this);
    }

    public void ship(){
        if (canShip()){
            orderState.ship(this);
        }
    }

    public void cancel(){
        if (canCancel()){
            orderState.cancel(this);
        }
    }

    public void changeState(IOrderState orderState){
        this.orderState = orderState;
    }
}
