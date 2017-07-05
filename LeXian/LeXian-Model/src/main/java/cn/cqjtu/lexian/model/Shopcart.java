package cn.cqjtu.lexian.model;

public class Shopcart {
    private String shopcartid;

    private String userid;

    private Integer productionKindAmount;

    public String getShopcartid() {
        return shopcartid;
    }

    public void setShopcartid(String shopcartid) {
        this.shopcartid = shopcartid == null ? null : shopcartid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getProductionKindAmount() {
        return productionKindAmount;
    }

    public void setProductionKindAmount(Integer productionKindAmount) {
        this.productionKindAmount = productionKindAmount;
    }
}