package cn.cqjtu.lexian.common.util;

/**
 * URL的工具类
 * 
 * @author johnniang
 *
 */
public class URLUtil {

	private URLUtil() {
	}

	/**
	 * 根据url获取文件名
	 * 
	 * @param url
	 *            url路径
	 * @return 返回文件名
	 */
	public static String getFileName(String url) {
		if (url == null || url.length() == 0) {
			// 判断url是否为空
			return null;
		}
		int idx = url.lastIndexOf("/");
		if (idx < 0 || idx == url.length() - 1) {
			// 如果该url不包含或者无文件名，则返回null
			return null;
		}
		return url.substring(idx + 1);
	}

	/**
	 * 根据url获取文件路径
	 * 
	 * @param url
	 *            url路径
	 * @return 返回文件路径
	 */
	public static String getFilePath(String url) {
		if (url == null || url.length() == 0) {
			// 判断url是否为空
			return null;
		}
		int idx = url.lastIndexOf("/");
		if (idx < 0) {
			// 如果该url不包含或者无文件名，则返回null
			return null;
		}
		return url.substring(0, idx + 1);
	}
}
