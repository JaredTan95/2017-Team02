package cn.cqjtu.lexian.model;

public class ProductionStatus {
    private Integer productionStatusId;

    private String productionStatusDesc;

    public Integer getProductionStatusId() {
        return productionStatusId;
    }

    public void setProductionStatusId(Integer productionStatusId) {
        this.productionStatusId = productionStatusId;
    }

    public String getProductionStatusDesc() {
        return productionStatusDesc;
    }

    public void setProductionStatusDesc(String productionStatusDesc) {
        this.productionStatusDesc = productionStatusDesc == null ? null : productionStatusDesc.trim();
    }
}