package cn.cqjtu.lexian.common.util;

import java.util.Random;

import org.apache.ibatis.javassist.expr.NewArray;

/**
 * 验证码工具类
 * @author zjhfyq
 *
 */
public class VerificationCodeUtil {
	private static Random random;
	
	static{
		random=new Random();
	}
	
	/**
	 * 获取四位数字验证码
	 * @return
	 */
	public static String getCode4(){
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<4;i++){
			builder.append(random.nextInt(10));
		}
		return builder.toString();
	}
	

	/**
	 * 获取六位数字验证码
	 * @return
	 */
	public static String getCode6(){
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<6;i++){
			builder.append(random.nextInt(10));
		}
		return builder.toString();
	}
	
	

	/**
	 * 获取n位数字验证码
	 * @return
	 */
	public static String getCodeN(int n){
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<n;i++){
			builder.append(random.nextInt(10));
		}
		return builder.toString();
	}
	
	
	

}
