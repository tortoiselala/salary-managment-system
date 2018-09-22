/**
 * 
 */
package salary.managment.system;

import java.sql.*;

import salary.managment.system.DatabaseFiled;
import salary.managment.system.Exception.LenException;

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
			String adminPass) {
		setAdminName(adminName);
		setAdminPass(adminPass);

	}

	public void getConnection() throws ClassNotFoundException, SQLException {
		// 注册JDBC驱动
		Class.forName(DatabaseFiled.JDBC_DRIVER);
		// 打开数据库
		connection = DriverManager.getConnection(DatabaseFiled.getDatabaseUserInfoURL(),
				DatabaseFiled.DB_DATABASE_ROOT_NAME, DatabaseFiled.DB_DATABASE_ROOT_PASS);
		statement = connection.createStatement();
	}

	public boolean tryCreateAdminUser(String userName, String userPass)
			throws SQLException, LenException, ClassNotFoundException {
		if (isAdminUser(false)) {
			return false;
		}
		if (userName.length() > 12 || userName.length() > 18) {
			throw new LenException("to long length of name or password!");
		}
		// COMMAND:
		// INSERT INTO user_admin
		// (user_admin_name, user_admin_pass, user_admin_create_time)
		// VALUES
		// ();
		String sql = "INSERT INTO " + DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN + " ("
				+ DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_NAME + ","
				+ DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_PASS + ","
				+ DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_CREATE_TIME + ") VALUES (" + userName
				+ "," + userPass + "," + "NOW())";
		getConnection();
		statement.executeUpdate(sql);
		connection.close();
		return true;
	}

	public boolean isAdminUser(boolean checkPassFlag) throws SQLException, ClassNotFoundException {
		getConnection();
		String sql = "SELECT * FROM " + DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN;
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			if (!adminName.equals(
					resultSet.getString(DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_NAME))) {
				connection.close();
				return false;
			}
			if (checkPassFlag && !adminPass.equals(
					resultSet.getString(DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_PASS))) {
				connection.close();
				return false;
			}
		}
		connection.close();
		return true;
	}

	public boolean isGenerUser(boolean checkPassFlag) throws SQLException {
		String sqlCheckString = "SELECT * FROM " + DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_GENER;
		ResultSet resultSet = statement.executeQuery(sqlCheckString);
		while (resultSet.next()) {
			if (!adminName.equals(
					resultSet.getString(DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_GENER_USER_GENER_NAME))) {
				return false;
			}
			if (checkPassFlag && !adminPass.equals(
					resultSet.getString(DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_GENER_USER_GENER_PASS))) {
				return false;
			}
		}
		return true;
	}

	public boolean isUser(boolean checkPassFlag) throws SQLException, ClassNotFoundException {
		if (!isAdminUser(checkPassFlag) && !isGenerUser(checkPassFlag)) {
			return false;
		}
		return true;
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
