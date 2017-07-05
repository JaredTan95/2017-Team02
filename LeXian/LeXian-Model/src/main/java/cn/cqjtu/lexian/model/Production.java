package cn.cqjtu.lexian.model;

import java.math.BigDecimal;

public class Production {
    private String proid;

    private Integer productionStatusId;

    private String probar;

    private String proname;

    private BigDecimal proprice;

    private String prodscp;

    private String prodetaildscp;

    private String promainpic;

    private Integer prostorage;

    private Integer prosalevolume;

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    public Integer getProductionStatusId() {
        return productionStatusId;
    }

    public void setProductionStatusId(Integer productionStatusId) {
        this.productionStatusId = productionStatusId;
    }

    public String getProbar() {
        return probar;
    }

    public void setProbar(String probar) {
        this.probar = probar == null ? null : probar.trim();
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public BigDecimal getProprice() {
        return proprice;
    }

    public void setProprice(BigDecimal proprice) {
        this.proprice = proprice;
    }

    public String getProdscp() {
        return prodscp;
    }

    public void setProdscp(String prodscp) {
        this.prodscp = prodscp == null ? null : prodscp.trim();
    }

    public String getProdetaildscp() {
        return prodetaildscp;
    }

    public void setProdetaildscp(String prodetaildscp) {
        this.prodetaildscp = prodetaildscp == null ? null : prodetaildscp.trim();
    }

    public String getPromainpic() {
        return promainpic;
    }

    public void setPromainpic(String promainpic) {
        this.promainpic = promainpic == null ? null : promainpic.trim();
    }

    public Integer getProstorage() {
        return prostorage;
    }

    public void setProstorage(Integer prostorage) {
        this.prostorage = prostorage;
    }

    public Integer getProsalevolume() {
        return prosalevolume;
    }

    public void setProsalevolume(Integer prosalevolume) {
        this.prosalevolume = prosalevolume;
    }
}