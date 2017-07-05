package cn.cqjtu.lexian.common.util;

/**
 * Created by zjhfyq on 2017/7/3.
 */
public class CheckRegex {

    /**
     * 验证手机号码
     *
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189
     *
     * @param cellphone
     * @return
     */
    public static boolean checkCellphone(String cellphone) {
        String regex = "^1[3|4|5|7|8][0-9]{9}$";
        return cellphone.matches(regex);
    }

    //只允许英文字母、数字、下划线、英文句号、以及中划线组成
    public  static  boolean checkMail(String mail){
        String regex="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return mail.matches(regex);
    }



}
