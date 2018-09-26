/**
 * 
 */
package salary.managment.system.submenubar;

import java.awt.FlowLayout;
import java.awt.Panel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import salary.managment.system.view.AppConstantsField;
import salary.managment.system.view.PathManager;

/**
 * @author Tortoise
 *
 */
public class SubMenuBarInputModification extends JPanel {

	// 职工基本信息录入按钮
	private JButton buttonInputEmployeeBaseInformation;
	// 职工基本信息录入 tip
	private String tipInputEmployeeBaseInformation;
	// 职工基本信息修改按钮
	private JButton buttonModifyEmployeeBaseInformation;
	// 职工基本信息修改tip
	private String tipModifyEmployeeBaseInformation;
	// 职工奖金或扣款录入按钮
	private JButton buttonInputOtherFee;
	// 职工奖金或扣款录入tip
	private String tipInputOtherFee;
	// 按钮图标
	private ImageIcon buttonIcon;

	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	public SubMenuBarInputModification(int width, int height) throws FileNotFoundException, IOException {
		this.setLocation(width, height);
		this.setBackground(AppConstantsField.SUB_MENU_BACK_COLOR);
		getButtonTip();

	}

	private void addbutton() {
		setBackground(AppConstantsField.TOOL_BAR_BACK_COLOR);
		setLayout(new FlowLayout());

	}

	private void getButtonTip() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		// 獲取系统语言
		properties.load(new FileInputStream(PathManager.PATH_MAIN_SYSTEM_PROPERTIES));
		String language = properties.getProperty(AppConstantsField.KEY_LANGUAGE);

		if (language.equals(AppConstantsField.KEY_EN_US)) {
			properties.load(new FileInputStream(PathManager.PATH_MAIN_EN_US_PROPERTIES));
		} else {
			properties.load(new FileInputStream(PathManager.PATH_MAIN_ZH_CN_PROPERTIES));

		}

		tipInputEmployeeBaseInformation = properties.getProperty(
				AppConstantsField.KEY_TIP_INPUT_EMPLOYEE_BASE_INFORMATION, "tip_input_employee_base_information");

		tipModifyEmployeeBaseInformation = properties.getProperty(
				AppConstantsField.KEY_TIP_MODIFY_EMPLOYEE_BASE_INFORMATION, "tip_modify_employee_base_information");

		tipInputOtherFee = properties.getProperty(AppConstantsField.KEY_TIP_INPUT_OTHER_FEE, "tip_input_other_fee");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
