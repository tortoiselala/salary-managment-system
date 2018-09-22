/**
 * 
 */
package salary.managment.system;


/**
 * @author Tortoise
 *
 */
public final class DatabaseFiled {

	private DatabaseFiled() {
	};

	/**
	 * {@code JDBC_DRIVER} 注冊驱动
	 */
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL_HEAD = "jdbc:mysql";
	public static final String DB_URL_URL = "localhost";
	/**
	 * {@code DB_URL_PORT}数据库连接端口
	 */
	public static final String DB_URL_PORT = "3306";

	/**
	 * {@code DB_DATABASE_USER_INFO}存储高级管理员和普通管理员信息的数据库名
	 */
	public static final String DB_DATABASE_USER_INFO = "user_info";

	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_ADMIN}存储高级管理员信息的表名
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_ADMIN = "user_admin";
	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_NAME}存储高级管理员信息表的第一列名称，用户名称
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_NAME = "user_admin_name";
	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_PASS}存储高级管理员信息表的第二列名称，用户密码
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_PASS = "user_admin_pass";
	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_CREATE_TIME}存储高级管理员信息表的第三列，用户创建时间
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_ADMIN_USER_ADDMIN_CREATE_TIME = "user_admin_create_time";

	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_GENER}存储普通管理员信息的表名
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_GENER = "user_gener";
	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_GENER_NAME}存储普通管理员信息表的第一列名称，用户名称
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_GENER_USER_GENER_NAME = "user_gener_name";
	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_GENER_PASS}存储普通管理员信息表的第二列名称，用户密码
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_GENER_USER_GENER_PASS = "user_gener_pass";
	/**
	 * {@code DB_DATABASE_USER_INFO_TABLE_USER_GENER_CREATE_TIME}存储普通管理员信息表的第三列名称，用户创建时间
	 */
	public static final String DB_DATABASE_USER_INFO_TABLE_USER_GENER_USER_GENER_CREATE_TIME = "user_gener_create_time";

	/**
	 * {@code DB_DATABASE_BASE_INFORMATION}存储员工基本信息的数据库名
	 */
	public static final String DB_DATABASE_BASE_INFORMATION = "base_information";
	/**
	 * {@code DB_DATABASE_BASE_INFORMATION_TABLE_USER_COLLECTION_NAME} 存储员工基本信息
	 * 
	 * @see
	 */
	public static final String DB_DATABASE_BASE_INFORMATION_TABLE_USER_COLLECTION_NAME = "user_collection";
	/**
	 * <ul>
	 * <li>{@code DB_DATABASE_ROOT_NAME}数据库登录账号</li>
	 * <li>{@code DB_DATABASE_ROOT_PASS}数据库登录密码</li>
	 * </ul>
	 */
	public static final String DB_DATABASE_ROOT_NAME = "root";
	public static final String DB_DATABASE_ROOT_PASS = "1546191727";

	/**
	 * 获取数据库链接
	 * 
	 * @return 数据库链接
	 */
	public static String getDatabaseUserInfoURL() {
		return DB_URL_HEAD + "://" + DB_URL_URL + "/" + DB_URL_PORT + "/" + DB_DATABASE_USER_INFO;
	}
}
