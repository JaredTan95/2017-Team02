package cn.cqjtu.lexian.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by tanjian on 2017/2/28.
 * 生成订单编号工具类
 */
public class OutOrderNum{
    private static String PREFIX="LeXian";

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public static String OrderNum(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateNowStr = sdf.format(new Date(System.currentTimeMillis()));
        return PREFIX+dateNowStr+new Random().nextInt(1000);
    }
}