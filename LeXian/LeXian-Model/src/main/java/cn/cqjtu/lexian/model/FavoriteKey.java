package cn.cqjtu.lexian.model;

public class FavoriteKey {
    private String proid;

    private String userid;

    private String favoriteid;

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getFavoriteid() {
        return favoriteid;
    }

    public void setFavoriteid(String favoriteid) {
        this.favoriteid = favoriteid == null ? null : favoriteid.trim();
    }
}