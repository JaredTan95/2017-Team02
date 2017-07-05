package cn.cqjtu.lexian.model;

import java.util.Date;

public class Favorite extends FavoriteKey {
    private Date favoritedate;

    public Date getFavoritedate() {
        return favoritedate;
    }

    public void setFavoritedate(Date favoritedate) {
        this.favoritedate = favoritedate;
    }
}