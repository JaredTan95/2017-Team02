package cn.cqjtu.lexian.model;

/**
 * 商品的查询条件的封装
 * Created by zjhfyq on 2017/7/2.
 */
public class ProductionQuery {
    private  String productionId;
    private  String categoryId;
    private  String proName;//模糊字段
    private  String productionStatusId;
    private  String maxPrice;
    private  String minPrice="0";
    private  String orderByVolume;//是否根据销量排序

    private  String pn="1";//页数

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProductionStatusId() {
        return productionStatusId;
    }

    public void setProductionStatusId(String productionStatusId) {
        this.productionStatusId = productionStatusId;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getOrderByVolume() {
        return orderByVolume;
    }

    public void setOrderByVolume(String orderByVolume) {
        this.orderByVolume = orderByVolume;
    }







}
