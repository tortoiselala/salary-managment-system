/**
 * 
 */
package salary.managment.system.view.panel.func;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import salary.managment.system.base.DatabaseFiled;

/**
 * @author Tortoise
 *
 */
public class PanelFuncPayRoll extends JLabel {
	private String tipTitle;
	private String tipDate;
	private String tipName;
	private String tipBaseSalary;
	private String tipBonus;
	private String tipSickFee;
	private String tipChildCareFee;
	private String tipRentFee;
	private String tipWaterEleFee;

	private String tipPayrollSubtotal;
	private String tipSubtotal;
	private String tipRealWage;

	private String tableName;

	private String date;
	Connection connection;
	Statement statement;

	private void setTip() {
		tipTitle = "工资条(单位:元)";
		tipDate = "日期";
		tipName = "姓名";
		tipBaseSalary = "基本工资";
		tipBonus = "奖金";
		tipSickFee = "病事扣款";
		tipChildCareFee = "托儿费";
		tipRentFee = "房费";
		tipWaterEleFee = "水电费";

		tipPayrollSubtotal = "应发小计";
		tipSubtotal = "小计";
		tipRealWage = "实发";
	}

	public PanelFuncPayRoll() {
		setTip();
		Calendar calendar = Calendar.getInstance();
		setTableName(calendar.get(Calendar.YEAR), calendar.get(calendar.MONTH));

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

	public String getTableName() {
		return tableName;
	}

	public void createTable() {
		String[][] datas = {};
		String[] titles = { tipDate, tipName, tipBaseSalary, tipBonus, tipSickFee, tipPayrollSubtotal, tipChildCareFee,
				tipRentFee, tipWaterEleFee, tipSubtotal, tipRealWage };
		JTable table = new JTable(new DefaultTableModel(datas, titles));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
