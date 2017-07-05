package cn.cqjtu.lexian.model;

import java.math.BigDecimal;

/**
 * Created by tanjian on 2017/7/2.
 */
public class ShopCartExpand {
    private String userid;

    private String shopcartid;

    private String productionId;

    private Integer productionAmount;

    private String probar;

    private BigDecimal proprice;

    private String proname;

    private String prodscp;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getShopcartid() {
        return shopcartid;
    }

    public void setShopcartid(String shopcartid) {
        this.shopcartid = shopcartid;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public Integer getProductionAmount() {
        return productionAmount;
    }

    public void setProductionAmount(Integer productionAmount) {
        this.productionAmount = productionAmount;
    }

    public String getProbar() {
        return probar;
    }

    public void setProbar(String probar) {
        this.probar = probar;
    }

    public BigDecimal getProprice() {
        return proprice;
    }

    public void setProprice(BigDecimal proprice) {
        this.proprice = proprice;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProdscp() {
        return prodscp;
    }

    public void setProdscp(String prodscp) {
        this.prodscp = prodscp;
    }

    @Override
    public String toString() {
        return "ShopCartExpand{" +
                "userid='" + userid + '\'' +
                ", shopcartid='" + shopcartid + '\'' +
                ", productionId='" + productionId + '\'' +
                ", productionAmount=" + productionAmount +
                ", probar='" + probar + '\'' +
                ", proprice=" + proprice +
                ", proname='" + proname + '\'' +
                ", prodscp='" + prodscp + '\'' +
                '}';
    }
}
