package cn.cqjtu.lexian.model;

public class OrderDetail {
    private String orderdetailId;

    private String userid;

    private String orderid;

    private String orderdetailProductionId;

    private Float orderdetailProductionPrice;

    private Integer orderdetailProductionAmount;

    public String getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(String orderdetailId) {
        this.orderdetailId = orderdetailId == null ? null : orderdetailId.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getOrderdetailProductionId() {
        return orderdetailProductionId;
    }

    public void setOrderdetailProductionId(String orderdetailProductionId) {
        this.orderdetailProductionId = orderdetailProductionId == null ? null : orderdetailProductionId.trim();
    }

    public Float getOrderdetailProductionPrice() {
        return orderdetailProductionPrice;
    }

    public void setOrderdetailProductionPrice(Float orderdetailProductionPrice) {
        this.orderdetailProductionPrice = orderdetailProductionPrice;
    }

    public Integer getOrderdetailProductionAmount() {
        return orderdetailProductionAmount;
    }

    public void setOrderdetailProductionAmount(Integer orderdetailProductionAmount) {
        this.orderdetailProductionAmount = orderdetailProductionAmount;
    }
}