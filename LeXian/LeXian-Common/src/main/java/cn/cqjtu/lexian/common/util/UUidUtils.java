package cn.cqjtu.lexian.common.util;

import java.util.UUID;

/**
 * Created by allen on 2017/6/30.
 */
public class UUidUtils {
    public static String uuid(){
        return UUID.randomUUID().toString();
    }


    /**
     * 生成TOKEN
     * @return
     */
    public  static  String  getToken(){
        return UUID.randomUUID().toString().replaceAll("-","")+
                UUID.randomUUID().toString().replaceAll("-","");
    }
}
