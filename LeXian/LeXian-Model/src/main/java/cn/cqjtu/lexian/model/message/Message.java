package cn.cqjtu.lexian.model.message;

import java.util.HashMap;
import java.util.Map;

/**
 * 同一的数据返回对象
 * @author zjhfyq
 *
 */
public class Message {
	/**
	 * 状态码
	 */
	private int code;
	
	/**
	 * 提示消息
	 */
	private String info;
	
	/**
	 * 数据
	 */
	private Map<String ,Object> map=new HashMap<String, Object>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	/**
	 * 添加数据
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public Message put(String key,Object value){
		map.put(key, value);
		return this;
	}
	
	/**
	 * 获取处理成功的消息对象
	 * @return
	 */
	public static Message getSuccessMessage(){
		Message message=new Message();
		message.code=200;
		message.info="处理成功";
		return message;
	}
	
	/**
	 * 获取处理失败的消息对象
	 * @return
	 */
	public static Message getFailedMessage(){
		Message message=new Message();
		message.code=500;
		message.info="处理失败";
		return message;
	}
}
