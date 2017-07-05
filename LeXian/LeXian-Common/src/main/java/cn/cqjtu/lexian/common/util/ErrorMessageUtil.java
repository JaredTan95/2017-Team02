package cn.cqjtu.lexian.common.util;

import cn.cqjtu.lexian.model.message.ErrorMessage;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * 全局的错误信息类
 * 
 * @author zjhfyq
 *
 */

public class ErrorMessageUtil {
	private static Map<String, ErrorMessage> errorMap;

	static {
		errorMap = new HashMap();
		Properties pro = new Properties();
		try {
			ClassLoader classLoader = ErrorMessageUtil.class.getClassLoader();
			URL resource = classLoader.getResource("errorMessage.properties");
			String path = resource.getPath();
			// System.out.println(path);
			InputStream is = classLoader.getResourceAsStream("errorMessage.properties");
			pro.load(is);
			Set<Object> keySet = pro.keySet();
			for (Object key : keySet) {
				errorMap.put((String) key, new ErrorMessage((String) key, (String) pro.get(key)));
			}
			is.close();
			System.out.println("错误信息配置文件加载完成");
		} catch (Exception e) {
			System.out.println("错误信息配置文件未找到.......");
			e.printStackTrace();
		}
	}



	public static ErrorMessage getErrorMessageByKey(String key){
		return errorMap.get(key);
	}



	// public static void main(String[] args) {
	// for (Entry<String, ErrorMessage> e : errorMap.entrySet()) {
	// System.out.println(e.getKey() + "=====" + e.getValue().getValue());
	//
	// }
	// }

}
