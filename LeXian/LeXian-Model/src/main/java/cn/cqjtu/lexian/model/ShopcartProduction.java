package cn.cqjtu.lexian.model;

public class ShopcartProduction {
    private String spId;

    private String shopcartid;

    private Integer productionAmount;

    private String productionId;

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId == null ? null : spId.trim();
    }

    public String getShopcartid() {
        return shopcartid;
    }

    public void setShopcartid(String shopcartid) {
        this.shopcartid = shopcartid == null ? null : shopcartid.trim();
    }

    public Integer getProductionAmount() {
        return productionAmount;
    }

    public void setProductionAmount(Integer productionAmount) {
        this.productionAmount = productionAmount;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId == null ? null : productionId.trim();
    }
}