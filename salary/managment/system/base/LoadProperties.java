/**
 * 
 */
package salary.managment.system.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * @author Tortoise 读取配置文件
 */
public class LoadProperties {
	public static void main(String[] args) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {

		// 初始化properties对象
		Properties properties = new Properties();

		properties.setProperty("ip", "localhost");
		properties.setProperty("port", "3306");
		properties.setProperty("root_pass", "1546191727");

		properties.store(new FileOutputStream("salary/managment/system/config/.properties"), "comment");

		System.out.println(LoadProperties.getIP());
		System.out.println(LoadProperties.getPort());
		System.out.println(LoadProperties.getRootPass());
	}

	private static String IP;
	private static String port;
	private static String rootPass;

	/**
	 * @return the iP
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String getIP() throws FileNotFoundException, IOException {
		LoadProperties.setIP();
		return IP;
	}

	/**
	 * @param iP the iP to set
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void setIP() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("salary/managment/system/config/.properties"));
		LoadProperties.IP = properties.getProperty("ip", "localhost");
	}

	/**
	 * @return the port
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String getPort() throws FileNotFoundException, IOException {
		LoadProperties.setPort();
		return port;
	}

	/**
	 * @param port the port to set
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void setPort() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("salary/managment/system/config/.properties"));
		LoadProperties.port = properties.getProperty("port", "3306");
	}

	/**
	 * @return the rootPass
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static String getRootPass() throws FileNotFoundException, IOException {
		LoadProperties.setRootPass();
		return rootPass;
	}

	/**
	 * @param rootPass the rootPass to set
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void setRootPass() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("salary/managment/system/config/.properties"));
		LoadProperties.rootPass = properties.getProperty("root_pass");
	}

}
