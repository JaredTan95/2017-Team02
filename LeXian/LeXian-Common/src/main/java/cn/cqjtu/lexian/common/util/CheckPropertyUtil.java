package cn.cqjtu.lexian.common.util;

import cn.cqjtu.lexian.model.message.ErrorMessage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 属性检查，查看属性是否为空
 * Created by zjhfyq on 2017/6/30.
 */
public class CheckPropertyUtil {



    public static List<ErrorMessage> checkProperty(Class clazz, Object obj){
        List<ErrorMessage> list=new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            try {
                if(fields[i].get(obj)==null||fields[i].get(obj).toString().length()<=0){
                    ErrorMessage errorMessage = ErrorMessageUtil.getErrorMessageByKey(fields[i].getName());
                    System.out.println(fields[i].getName()+"属性为空");
                    list.add(errorMessage);
                }else{
                    System.out.println(fields[i].getName()+"属性不为空");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  list;
    }


//   public static void main(String [] args){
//       User user=new User();
//       user.setUserName("ZZZJJJHHH");
//       checkProperty(User.class,user);
//   }



}
