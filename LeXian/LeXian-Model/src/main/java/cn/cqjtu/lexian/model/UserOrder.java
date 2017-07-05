package cn.cqjtu.lexian.model;

import java.util.Date;

public class UserOrder extends UserOrderKey {
    private Integer orderstatusId;

    private Date orderdatetime;

    private Date ordercancledatetime;

    private Date orderdeliverdatetime;

    private Date orderfinishdatetime;

    private Float ordertotalprice;

    public Integer getOrderstatusId() {
        return orderstatusId;
    }

    public void setOrderstatusId(Integer orderstatusId) {
        this.orderstatusId = orderstatusId;
    }

    public Date getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(Date orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public Date getOrdercancledatetime() {
        return ordercancledatetime;
    }

    public void setOrdercancledatetime(Date ordercancledatetime) {
        this.ordercancledatetime = ordercancledatetime;
    }

    public Date getOrderdeliverdatetime() {
        return orderdeliverdatetime;
    }

    public void setOrderdeliverdatetime(Date orderdeliverdatetime) {
        this.orderdeliverdatetime = orderdeliverdatetime;
    }

    public Date getOrderfinishdatetime() {
        return orderfinishdatetime;
    }

    public void setOrderfinishdatetime(Date orderfinishdatetime) {
        this.orderfinishdatetime = orderfinishdatetime;
    }

    public Float getOrdertotalprice() {
        return ordertotalprice;
    }

    public void setOrdertotalprice(Float ordertotalprice) {
        this.ordertotalprice = ordertotalprice;
    }
}