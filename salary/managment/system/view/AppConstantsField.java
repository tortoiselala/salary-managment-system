/**
 * 
 */
package salary.managment.system.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * @author Tortoise
 *
 */
public class AppConstantsField {

	public static void main(String[] args) {
		AppConstantsField appConstantsField = new AppConstantsField();
		try {
			appConstantsField.loginInterfaceFiled();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * 该类用于独立运行创建中英文字段界面配置文件
	 * </p>
	 * <p>
	 * 配置文件所属包salary.managment.system.properties;
	 * </p>
	 * <ul>
	 * <li>中文配置文件名称：en_US.properties</li>
	 * <li>英文配置文件名称：zh_CN.properties</li>
	 * </ul>
	 */

	public static String FILE_NAME_EN_US = "en_US.properties";
	public static String FILE_NAME_ZH_CN = "zh_CN.properties";

	/**
	 * 用来读取配置文件的关键字
	 */
	public static String KEY_EN_US = "en_US";
	public static String KEY_ZH_CN = "zh_CN";
	public static String KEY_LANGUAGE = "language";
	public static String KEY_SYSTEM_NAME = "system_name";
	public static String KEY_USER_NAME = "user_name";
	public static String KEY_USER_PASS = "user_pass";
	public static String KEY_SIGN_IN = "sign_in";

	public AppConstantsField() {

	}

	// login interface filed
	public void loginInterfaceFiled() throws FileNotFoundException, IOException {
		Properties properties_EN_US = new Properties();
		
		properties_EN_US.setProperty(KEY_LANGUAGE, "en_US");
		properties_EN_US.setProperty(KEY_SYSTEM_NAME, "Salary Managment System");
		properties_EN_US.setProperty(KEY_USER_NAME, "Username");
		properties_EN_US.setProperty(KEY_USER_PASS, "Password");
		properties_EN_US.setProperty(KEY_SIGN_IN, "Sign in");

		properties_EN_US.store(new FileOutputStream("salary/managment/system/config/" + FILE_NAME_EN_US),
				"interface language properties:en_US");

		Properties properties_ZH_CN = new Properties();

		properties_ZH_CN.setProperty(KEY_LANGUAGE, "zh_CN");
		properties_ZH_CN.setProperty(KEY_SYSTEM_NAME, "工资管理系统");
		properties_ZH_CN.setProperty(KEY_USER_NAME, "用户名");
		properties_ZH_CN.setProperty(KEY_USER_PASS, "密码");
		properties_ZH_CN.setProperty(KEY_SIGN_IN, "登录");

		properties_ZH_CN.store(new FileOutputStream("salary/managment/system/config/" + FILE_NAME_ZH_CN),
				"interface language properties:en_US");

	}
}
