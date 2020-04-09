package simplest.strategy;

import lombok.Data;

@Data
public class CartItem {
    Integer productId; // 产品id
    String name; // 购车车商品名称， 产品名称的镜像
    Integer unitPrice; // 单价，产品单价的镜像
    Integer num; // 购买数量

    public CartItem(Integer productId, String name, Integer unitPrice, Integer num) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.num = num;
    }
}
