package cn.cqjtu.lexian.model;

public class Category {
    private String categoryid;

    private String categorytitle;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    public String getCategorytitle() {
        return categorytitle;
    }

    public void setCategorytitle(String categorytitle) {
        this.categorytitle = categorytitle == null ? null : categorytitle.trim();
    }
}