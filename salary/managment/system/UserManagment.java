/**
 * 
 */
package salary.managment.system;

import java.sql.*;

import salary.managment.system.DatabaseFiled;

/**
 * @author Tortoise
 * 
 *         <h1>该类用于操作系统管理员</h1>
 *         <p>
 *         高级管理员仅一个，普通管理员有多个
 *         </p>
 *         <p>
 *         高级管理员具有数据处理以及修改管理员的功能
 *         </p>
 *         普通管理员仅仅具有数据处理的功能 每次登录，管理员的登录信息将被记录
 *         <p>
 *         1.查看 允许登录的高级管理员查看其他普通管理员账号
 *         </p>
 *         <p>
 *         2.添加 允许登录的高级管理员添加其他普通管理员账号
 *         </p>
 *         <p>
 *         3.删除 允许登录的高级管理员删除其他普通管理员账号
 *         </p>
 *         <p>
 *         4.修改 允许修改当前账号的密码
 *         </p>
 */
public class UserManagment {

	private String adminName;
	private String adminPass;
	Connection connection;
	Statement statement;

	/**
	 * 
	 */

	public UserManagment(String databaseURL, String databasePort, String databaseName, String adminName,
			String adminPass) throws ClassNotFoundException, SQLException {
		setAdminName(adminName);
		setAdminPass(adminPass);
		// 注册JDBC驱动
		Class.forName(DatabaseFiled.JDBC_DRIVER);
		// 打开数据库
		connection = DriverManager.getConnection(DatabaseFiled.getDatabaseUserInfoURL(),
				DatabaseFiled.DB_DATABASE_ROOT_NAME, DatabaseFiled.DB_DATABASE_ROOT_PASS);
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return the adminPass
	 */
	public String getAdminPass() {
		return adminPass;
	}

	/**
	 * @param adminPass the adminPass to set
	 */
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

}
