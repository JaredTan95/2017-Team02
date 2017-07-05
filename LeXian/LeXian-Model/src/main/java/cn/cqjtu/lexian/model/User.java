package cn.cqjtu.lexian.model;

public class User {
    private String userid;

    private String shopcartid;

    private String useraccount;

    private String username;

    private String userpassword;

    private String usermail;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getShopcartid() {
        return shopcartid;
    }

    public void setShopcartid(String shopcartid) {
        this.shopcartid = shopcartid == null ? null : shopcartid.trim();
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }
}