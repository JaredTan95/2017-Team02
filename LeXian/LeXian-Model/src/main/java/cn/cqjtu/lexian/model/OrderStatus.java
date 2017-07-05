package cn.cqjtu.lexian.model;

public class OrderStatus {
    private Integer orderstatusId;

    private String orderstatusDesc;

    public Integer getOrderstatusId() {
        return orderstatusId;
    }

    public void setOrderstatusId(Integer orderstatusId) {
        this.orderstatusId = orderstatusId;
    }

    public String getOrderstatusDesc() {
        return orderstatusDesc;
    }

    public void setOrderstatusDesc(String orderstatusDesc) {
        this.orderstatusDesc = orderstatusDesc == null ? null : orderstatusDesc.trim();
    }
}