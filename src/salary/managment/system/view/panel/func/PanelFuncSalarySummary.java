/**
 * 
 */
package salary.managment.system.view.panel.func;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.javafx.collections.MappingChange.Map;

import salary.managment.system.base.DatabaseFiled;

/**
 * @author Tortoise
 *
 */
public class PanelFuncSalarySummary extends JPanel {

	private static String tipTitle = "    部门汇总表";
	private static String tipDepartmentID = "部门编号";
	private static String tipBaseSalary = "基本工资";
	private static String tipBonus = "奖金";
	private static String tipSickFee = "病事扣款";
	private static String tipPayrollSubtotal = "应发小计";
	private static String tipChildCareFee = "托儿费";
	private static String tipRentFee = "房费";
	private static String tipWaterEleFee = "水电费";
	private static String tipRealWage = "实发";

	private String tableName;
	private String date;

	Connection connection;
	Statement statement;

	HashMap<String, Double[]> result = new HashMap<>();

	/**
	 * @throws IOException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * 
	 */
	public PanelFuncSalarySummary() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Calendar calendar = Calendar.getInstance();
		setTableName(calendar.get(Calendar.YEAR), calendar.get(calendar.MONTH));
		createTable();
	}

	public void getConnect() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// 注册JDBC驱动
		Class.forName(DatabaseFiled.JDBC_DRIVER);
		// 打开数据库
		connection = DriverManager.getConnection(DatabaseFiled.getDatabaseBaseInformationURL(),
				DatabaseFiled.DB_DATABASE_ROOT_NAME, DatabaseFiled.DB_DATABASE_ROOT_PASS);
		statement = connection.createStatement();

	}

	private void setTableName(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		date = simpleDateFormat.format(calendar.getTime());
		tableName = "table_" + date;
	}

	public void createTable() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String[][] datas = getInfo();
		String[] titles = {};
		JTable table = new JTable(datas, titles);
		JLabel title = new JLabel(tipTitle);
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		// table.setFillsViewportHeight(true);
	}

	public String[][] getInfo() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		double sumbaseSalary = 0;
		double sumBonus = 0;
		double sumSickFee = 0;
		double sumPayrollSubtotal = 0;
		double sumChildCareFee = 0;
		double sumChildCareFeeRentFeeWaterEleFee = 0;
		double sumWaterEleFee = 0;
		double sumRealWage = 0;

		getConnect();
		String sql = "SELECT * FROM " + tableName;
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String departmentID = resultSet.getString(
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_DEPARTMENT_ID);
			double baseSalary = resultSet.getDouble(
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_BASESALARY);

			double bonus = resultSet.getDouble(
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_OTHER_FEE);

			double sickFee = resultSet.getDouble(
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_SICK_FEE);

			double payrollSubtotal = baseSalary + bonus - sickFee;

			double childCareFee = resultSet.getDouble(
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_CHILD_CARE_FEE);

			double rentFee = resultSet.getDouble(
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_RENT_FEE);

			double waterEleFee = resultSet.getDouble(
					DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_WATER_ELE_FEE);

			double subtotal = childCareFee + rentFee + waterEleFee;
			double realWage = payrollSubtotal - subtotal;

			Double[] resultField = new Double[8];
			resultField[0] = baseSalary;
			resultField[1] = bonus;
			resultField[2] = sickFee;
			resultField[3] = payrollSubtotal;
			resultField[4] = childCareFee;
			resultField[5] = rentFee;
			resultField[6] = waterEleFee;
			resultField[7] = realWage;

			result.put(departmentID, resultField);
		}
		Set<String> keys = result.keySet();
		for (int i = 0; i < result.size(); i++) {
			String[] tmp = new String[9];
			tmp[0] = result
		}
	}

	public static void main(String[] args) {

	}

}
