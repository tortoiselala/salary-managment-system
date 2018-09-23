/**
 * 
 */
package salary.managment.system;

import java.sql.*;

/**
 * @author Tortoise
 *
 */
public class BasicInformationOfEmployeeManagment extends BasicInformationOfEmployee {
	public static void main(String[] args) {
		BasicInformationOfEmployeeManagment test;
		try {
			test = new BasicInformationOfEmployeeManagment("620421199908145140", "tort", man, (short) 10, 10000, "test");
			test.addOrUpdateEmployee();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Connection connection;
	private Statement statement;

	/**
	 * @param id
	 * @throws Exception
	 */
	public BasicInformationOfEmployeeManagment(String id, String name) throws Exception {
		super(id, name);
	}

	/**
	 * @param id
	 * @param name
	 * @param sex
	 * @param age
	 * @param baseSalary
	 * @param category
	 * @throws Exception
	 */
	public BasicInformationOfEmployeeManagment(String id, String name, short sex, short age, double baseSalary,
			String category) throws Exception {
		super(id, name, sex, age, baseSalary, category);
	}

	private void getConnection() throws ClassNotFoundException, SQLException {
		// 注册JDBC驱动
		Class.forName(DatabaseFiled.JDBC_DRIVER);
		// 打开数据库
		connection = DriverManager.getConnection(DatabaseFiled.getDatabaseBaseInformationURL(),
				DatabaseFiled.DB_DATABASE_ROOT_NAME, DatabaseFiled.DB_DATABASE_ROOT_PASS);
		statement = connection.createStatement();
	}

	public boolean isEmployeeInformationExits() throws ClassNotFoundException, SQLException {
		getConnection();
		String sql = "SELECT * FROM "
				+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM;
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			if (this.getId().equals(resultSet
					.getString(DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_ID))) {
				return true;
			}
		}
		connection.close();
		return false;
	}

	public void addOrUpdateEmployee() throws ClassNotFoundException, SQLException {
		
		String sql;

		if (isEmployeeInformationExits()) {
			sql = "UPDATE " + DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM + " SET "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_NAME + " = \""
					+ getName() + "\", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_SEX + " = \""
					+ getSex() + "\", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_AGE + " = \""
					+ getAge() + "\", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_BASESALARY
					+ " = \"" + getBaseSalary() + "\", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_CATEGORY
					+ " = \"" + getCategory() + "\" " + " WHERE "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_ID + " = \""
					+ getId() + "\"";
			System.out.println("update");
			System.out.println(sql);
		} else {
			sql = "INSERT INTO " + DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM
					+ "(" + DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_ID + ", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_NAME + ", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_SEX + ", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_AGE + ", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_BASESALARY + ", "
					+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_CATEGORY
					+ ") VALUES  (" + " \"" + getId() + "\", " + " \"" + getName() + "\", " +  getSex() +", "
					 + getAge()  +", " + getBaseSalary() +", "+ " \"" + getCategory() + "\" "
					+ ")";
			System.out.println("insert");
			
		}
		getConnection();
		statement.executeUpdate(sql);
		connection.close();
	}
}
