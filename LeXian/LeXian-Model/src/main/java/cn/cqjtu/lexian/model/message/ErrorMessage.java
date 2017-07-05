package cn.cqjtu.lexian.model.message;

/**
 * 错误信息包装类
 * 
 * @author zjhfyq
 *
 */
public class ErrorMessage {
	private String key;
	private String value;

	public ErrorMessage(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
