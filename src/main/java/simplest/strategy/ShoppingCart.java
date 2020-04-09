package simplest.strategy;

import simplest.strategy.discountpolicy.DiscountPolicy;
import simplest.strategy.discountpolicy.NoDiscountPolicy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> cartItemList = new ArrayList<CartItem>();
    private DiscountPolicy discountPolicy = new NoDiscountPolicy();

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void addToCart(CartItem item){
        cartItemList.add(item);
    }

    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }

    public Double calcuateDiscount(){
        return  this.discountPolicy.calcuateDiscount(this.cartItemList);
    }



}
