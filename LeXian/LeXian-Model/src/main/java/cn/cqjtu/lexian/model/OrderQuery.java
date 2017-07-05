package cn.cqjtu.lexian.model;

/**
 * 订单查询条件类
 * Created by zjhfyq on 2017/7/1.
 */
public class OrderQuery {

    private  Integer orderstatus; //订单状态
    private  String account; //用户账号
    private  Integer pn=1; //页数

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getPn() {
        return pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }
}
