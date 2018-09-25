/**
 * 
 */
package salary.managment.system.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.*;

/**
 * @author Tortoise
 *
 */
public class InitDatabase {
	public static void main(String[] args) {
		Init();
	}

	/**
	 * 不允许初始化该类，使用静态方式init()来初始化数据库
	 */
	private InitDatabase() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 查看数据库是否存在，不存在则创建
	 * <ul>
	 * <li>管理员数据库</li>
	 * <li>员工基本信息以及工资数据库</li>
	 * </ul>
	 * <p>
	 * 1.管理员数据库名称:DatabaseFiled.DB_DATABASE_USER_INFO = "user_info";
	 * <li>a.管理员数据库 表1 高级管理员信息表名称:
	 * DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN = "user_admin";
	 * <p>
	 * 高级管理员信息表创建方式：
	 * <ul>
	 * <li>USE user_info;</li>
	 * <li>CREATE TABLE user_admin( `user_admin_name` char(12) NOT NULL,
	 * `user_admin_pass` char(18) DEFAULT NULL, `user_admin_create_time` timestamp
	 * NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, PRIMARY KEY
	 * (`user_admin_name`) );</li>
	 * </ul>
	 * </p>
	 * </li>
	 * 
	 * </p>
	 * <li>a.管理员数据库 表2 普通管理员信息表名称:
	 * DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_GENER = "user_gener";
	 * <p>
	 * 普通管理员信息表创建方式
	 * <ul>
	 * <li>USER user_info;</li>
	 * <li>CREATE TABLE user_gener( `user_gener_name` char(12) NOT NULL,
	 * `user_gener_pass` char(18) DEFAULT NULL, `user_gener_create_time` timestamp
	 * NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, PRIMARY KEY
	 * (`user_gener_name`) );</li>
	 * </ul>
	 * </p>
	 * </li>
	 * <p>
	 * 2.员工基本信息以及工资数据库名称:DatabaseFiled.DB_DATABASE_BASE_INFORMATION =
	 * "base_information";
	 * <ul>
	 * <p>
	 * 员工基本信息表创建方式：
	 * <li>USE base_information;</li>
	 * <li>create table employee_basic_information_form( `id` varchar(18) NOT NULL,
	 * `name` varchar(4) NOT NULL, `sex` smallint(1) DEFAULT '1', `age` tinyint(3)
	 * unsigned DEFAULT '0', `baseSalary` double(11,2) unsigned DEFAULT '0.00',
	 * `category` varchar(22) DEFAULT 'general_staff', PRIMARY KEY (`id`) );</li>
	 * </p>
	 * </ul>
	 * </p>
	 * </ui>
	 */
	private static Connection connection;
	private static Statement statement;

	public static void Init() {

		try {

			getConnection(DatabaseFiled.getDatabaseURL());
			statement.executeUpdate("create database if not exists " + DatabaseFiled.DB_DATABASE_USER_INFO);
			statement.executeUpdate("create database if not exists " + DatabaseFiled.DB_DATABASE_BASE_INFORMATION);
			connection.close();

			getConnection(DatabaseFiled.getDatabaseUserInfoURL());
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			ResultSet resultSet = databaseMetaData.getTables(null, null,
					DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_ADMIN, null);
			if (!resultSet.next()) {
				statement.executeUpdate(
						"CREATE TABLE user_admin( user_admin_name char(12) NOT NULL,  user_admin_pass char(18) DEFAULT NULL, user_admin_create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, PRIMARY KEY (user_admin_name))");
			}
			resultSet = databaseMetaData.getTables(null, null, DatabaseFiled.DB_DATABASE_USER_INFO_TABLE_USER_GENER,
					null);
			if (!resultSet.next()) {
				statement.executeUpdate("CREATE TABLE user_gener( " + "`user_gener_name` char(12) NOT NULL, "
						+ "`user_gener_pass` char(18) DEFAULT NULL, "
						+ "`user_gener_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, "
						+ "PRIMARY KEY (`user_gener_name`) )");
			}
			connection.close();

			getConnection(DatabaseFiled.getDatabaseBaseInformationURL());
			databaseMetaData = connection.getMetaData();
			resultSet = databaseMetaData.getTables(null, null,
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM, null);
			if (!resultSet.next()) {
				statement.executeUpdate("create table employee_basic_information_form( " + "`id` varchar(18) NOT NULL,"
						+ "`name` varchar(4) NOT NULL, " + "`sex` smallint(1) DEFAULT '1', "
						+ "`age` tinyint(3) unsigned DEFAULT '0', "
						+ "`baseSalary` double(11,2) unsigned DEFAULT '0.00', "
						+ "`category` varchar(22) DEFAULT 'general_staff', " + "PRIMARY KEY (`id`) )");
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void getConnection(String url)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// 注册JDBC驱动
		Class.forName(DatabaseFiled.JDBC_DRIVER);
		// 打开数据库
		connection = DriverManager.getConnection(url, DatabaseFiled.DB_DATABASE_ROOT_NAME,
				DatabaseFiled.DB_DATABASE_ROOT_PASS);
		statement = connection.createStatement();
	}
}
