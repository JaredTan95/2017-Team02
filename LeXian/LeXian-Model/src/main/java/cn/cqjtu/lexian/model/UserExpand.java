package cn.cqjtu.lexian.model;

/**
 * 用户扩展类
 * Created by zjhfyq on 2017/7/2.
 */
public class UserExpand extends  User{
    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    private String rePassword;
    private String verificationCode;
}
