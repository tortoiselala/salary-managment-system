/**
 * 
 */
package salary.managment.system.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * @author Tortoise
 *
 */
public class MenuBarPanel extends JPanel {
	// 输入与修改按钮
	private static MenuButton buttonInputAndModification;
	// 输入与修改按钮tip
	private String tipInputAndModification;
	// 计算打印工资
	private static MenuButton buttonComputeAndPrintSalary;
	// 计算打印工资tip
	private String tipComputeAndPrintSalary;
	// 查询工资
	private static MenuButton buttonInquirySalary;
	// 查询工资tip
	private String tipInquirySalary;
	// 系统维护
	private static MenuButton buttonSystemMaintenance;
	// 系统维护tip
	private String tipSystemMaintenance;
	// 系统设置
	private static MenuButton buttonSystemSettings;
	// 系统设置tip
	private String tipSystemSettings;
	// 关于
	private static MenuButton buttonAbout;
	// 关于tip
	private String tipAbout;

	public MenuBarPanel() throws FileNotFoundException, IOException {
		getButtonTip();
		initialize();
		addButton();
	}

	private void initialize() {
		Dimension preferredSize = new Dimension(48, AppConstantsField.LOGIN_WINDOW_HEIGHT);
		this.setPreferredSize(preferredSize);
		this.setMaximumSize(preferredSize);
		this.setMinimumSize(preferredSize);
		this.setBackground(AppConstantsField.TOOL_BAR_BACK_COLOR);
		this.setLayout(new GridLayout(2, 1));
		this.setVisible(true);
	}

	private void addButton() {
		JPanel panelUp = new JPanel();
		panelUp.setBackground(AppConstantsField.TOOL_BAR_BACK_COLOR);
		panelUp.setLayout(new FlowLayout(-2, -2, -4));
		JPanel panelDown = new JPanel();
		panelDown.setBackground(AppConstantsField.TOOL_BAR_BACK_COLOR);
		panelDown.setLayout(new BorderLayout(0, 0));

		buttonInputAndModification = new MenuButton(new ImageIcon(PathManager.PATH_MAIN_INPUT_MODIFICATION_DISABLE),
				new ImageIcon(PathManager.PATH_MAIN_INPUT_MODIFICATION_ENABLE),
				new ImageIcon(PathManager.PATH_MAIN_INPUT_MODIFICATION_DISABLE), tipInputAndModification);
		buttonComputeAndPrintSalary = new MenuButton(new ImageIcon(PathManager.NAME_COMPUTE_PRINT_DISABLE),
				new ImageIcon(PathManager.NAME_COMPUTE_PRINT_ENABLE),
				new ImageIcon(PathManager.NAME_COMPUTE_PRINT_DISABLE), tipComputeAndPrintSalary);
		buttonInquirySalary = new MenuButton(new ImageIcon(PathManager.NAME_INQUIRY_DISABLE),
				new ImageIcon(PathManager.NAME_INQUIRY_ENABLE), new ImageIcon(PathManager.NAME_INQUIRY_DISABLE),
				tipComputeAndPrintSalary);
		buttonSystemMaintenance = new MenuButton(new ImageIcon(PathManager.NAME_SYSTEM_MAINTENANCE_DISABLE),
				new ImageIcon(PathManager.NAME_SYSTEM_MAINTENANCE_ENABLE),
				new ImageIcon(PathManager.NAME_SYSTEM_MAINTENANCE_DISABLE), tipSystemMaintenance);
		buttonSystemSettings = new MenuButton(new ImageIcon(PathManager.NAME_SYSTEM_SETTINGS_DISABLE),
				new ImageIcon(PathManager.NAME_SYSTEM_SETTINGS_ENABLE),
				new ImageIcon(PathManager.NAME_SYSTEM_SETTINGS_DISABLE), tipSystemMaintenance);
		buttonAbout = new MenuButton(new ImageIcon(PathManager.NAME_ABOUT_DISABLE),
				new ImageIcon(PathManager.NAME_ABOUT_ENABLE), new ImageIcon(PathManager.NAME_ABOUT_DISABLE), tipAbout);

		panelUp.add(buttonInputAndModification);
		panelUp.add(buttonComputeAndPrintSalary);
		panelUp.add(buttonInquirySalary);
		panelUp.add(buttonSystemMaintenance);
		panelUp.add(buttonSystemSettings);

		panelDown.add(buttonAbout, BorderLayout.SOUTH);
		this.add(panelUp);
		this.add(panelDown);
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
		tipInputAndModification = properties.getProperty(AppConstantsField.KEY_TIP_INPUT_AND_MODIFICATION,
				"input and modification");
		tipComputeAndPrintSalary = properties.getProperty(AppConstantsField.KEY_TIP_COMPUTE_AND_PRINT_SALARY,
				"compute and print salary");
		tipInquirySalary = properties.getProperty(AppConstantsField.KEY_TIP_INQUIRY_SALARY, "tip inquiry salary");
		tipSystemMaintenance = properties.getProperty(AppConstantsField.KEY_TIP_SYSTEM_MAINTENANCE,
				"tip system maintenance");
		tipSystemSettings = properties.getProperty(AppConstantsField.KEY_TIP_SYSTEM_SETTINGS, "tip system settings");
		tipAbout = properties.getProperty(AppConstantsField.KEY_TIP_ABOUT, "tip about");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MenuBarPanel pamel;
			try {
				pamel = new MenuBarPanel();
				pamel.setVisible(true);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

}
