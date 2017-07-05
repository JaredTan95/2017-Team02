package cn.cqjtu.lexian.model;

import java.util.Date;

/**
 * 订单展示包装类
 * Created by zjhfyq on 2017/7/1.
 */
public class OrderShow {


    private  String orderId;
    private  String userAccount;
    private  float orderTotalPrice;
    private Date orderDatetime;
    private Date orderCancleDatetime;
    private Date finishDatetime;
    private String orderStatusDesc;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public Date getOrderCancleDatetime() {
        return orderCancleDatetime;
    }

    public void setOrderCancleDatetime(Date orderCancleDatetime) {
        this.orderCancleDatetime = orderCancleDatetime;
    }

    public Date getFinishDatetime() {
        return finishDatetime;
    }

    public void setFinishDatetime(Date finishDatetime) {
        this.finishDatetime = finishDatetime;
    }

    public String getOrderStatusDesc() {
        return orderStatusDesc;
    }

    public void setOrderStatusDesc(String orderStatusDesc) {
        this.orderStatusDesc = orderStatusDesc;
    }
}
