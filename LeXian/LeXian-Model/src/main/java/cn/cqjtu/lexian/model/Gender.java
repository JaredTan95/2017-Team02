package cn.cqjtu.lexian.model;

public class Gender {
    private Integer genderid;

    private String userid;

    private String genderdesc;

    public Integer getGenderid() {
        return genderid;
    }

    public void setGenderid(Integer genderid) {
        this.genderid = genderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getGenderdesc() {
        return genderdesc;
    }

    public void setGenderdesc(String genderdesc) {

        this.genderdesc = genderdesc == null ? null : genderdesc.trim();
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderid=" + genderid +
                ", userid='" + userid + '\'' +
                ", genderdesc='" + genderdesc + '\'' +
                '}';
    }
}