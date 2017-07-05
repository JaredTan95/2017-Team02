package cn.cqjtu.lexian.model;

/**
 * Created by zjhfyq on 2017/7/3.
 */
public class ShopcartProductionShow extends  ShopcartProduction {
    private  String proName;
    private  String proPrice;
    private  String proDscp;
    private  String proBar;
    private String proMainPic;





    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public String getProMainPic() {
        return proMainPic;
    }

    public void setProMainPic(String proMainPic) {
        this.proMainPic = proMainPic;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProDscp() {
        return proDscp;
    }

    public void setProDscp(String proDscp) {
        this.proDscp = proDscp;
    }

    public String getProBar() {
        return proBar;
    }

    public void setProBar(String proBar) {
        this.proBar = proBar;
    }
}
