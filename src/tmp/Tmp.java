package tmp;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Scanner;

import salary.managment.system.base.DatabaseFiled;
import salary.managment.system.view.PathManager;
import sun.security.provider.VerificationProvider;

public class Tmp {
	public static void main(String[] args) {
		// Tmp tmp = new Tmp();
		String sql = "ALTER TABLE " +" table_201809 " + " ADD ("
				+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_SICK_FEE
				+ " double(11,2) default 0,"
				+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_CHILD_CARE_FEE
				+ " double(11,2) default 0,"
				+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_RENT_FEE
				+ " double(11,2) default 0,"
				+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_WATER_ELE_FEE
				+ " double(11,2) default 0,"
				+ DatabaseFiled.DB_DATABASE_BASE_INFORMATION_TABLE_EMPLOYEE_BASIC_INFORMATION_FORM_OTHER_FEE
				+ " double(11,2) default 0" + ")";
		System.out.println(sql);
	}

	public Tmp() {
		// en_us();
		// zh_cn();
		tip_loader();
	}

	/**
	 * public final static String KEY_TIP_DATABASE_BACKUP = "tip_database_backup";
	 * 
	 * properties_EN_US.setProperty(KEY_TIP_DATABASE_BACKUP, "database backup");
	 */
	public void en_us() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String tmp = scanner.nextLine();
			String[] tmpSpilt = tmp.split(" ");

			System.out.print("properties_EN_US.setProperty(" + tmpSpilt[4] + ", \"");
			char[] chArray = tmpSpilt[tmpSpilt.length - 1].toCharArray();
			for (int i = 5; i < chArray.length - 1; i++) {
				if (chArray[i] == '_') {
					System.out.print(" ");
				} else {
					System.out.print(chArray[i]);
				}
			}
			System.out.println(");");
		}
	}

	/**
	 * public final static String KEY_TIP_DATABASE_BACKUP = "tip_database_backup";
	 * properties_EN_US.setProperty(KEY_TIP_DATABASE_BACKUP, "database backup");
	 */
	public void zh_cn() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String tmp = scanner.nextLine();
			String[] tmpSpilt = tmp.split(" ");

			System.out.print("properties_ZH_CN.setProperty(" + tmpSpilt[4] + ", \"");
			char[] chArray = tmpSpilt[tmpSpilt.length - 1].toCharArray();
			for (int i = 5; i < chArray.length - 1; i++) {
				if (chArray[i] == '_') {
					System.out.print(" ");
				} else {
					System.out.print(chArray[i]);
				}
			}
			System.out.println(");");
		}
	}

	public void tip_loader() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String tmp = scanner.nextLine();
			String[] tmpSpilt = tmp.split(" ");

			System.out.print(" = properties.getProperty(AppConstantsField." + tmpSpilt[4] + ", \"");
			char[] chArray = tmpSpilt[tmpSpilt.length - 1].toCharArray();
			for (int i = 5; i < chArray.length - 1; i++) {
				if (chArray[i] == '_') {
					System.out.print(" ");
				} else {
					System.out.print(chArray[i]);
				}
			}
			System.out.println(");");
		}

	}
}
