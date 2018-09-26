/**
 * 
 */
package salary.managment.system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.javafx.event.EventQueue;

import javafx.scene.control.ToolBar;
import salary.managment.system.view.panel.PanelComputeAndPrintSalary;
import salary.managment.system.view.panel.PanelInputAndModification;
import sun.applet.Main;

/**
 * @author Tortoise
 *
 */
public class MainFrame extends JFrame {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			try {
				MainFrame test = new MainFrame();
				test.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2994581375047812681L;

	/**
	 * 
	 */
	private String systemName;

	public static boolean isLogin = false;
	public static boolean isAdmin = false;
	public static boolean isGener = false;

	public static JPanel panelMain;
	public static JPanel panelInputAndModification;
	public static JPanel panelComputeAndPrintSalary;
	public static JPanel panelInauirySalary;
	public static JPanel panelSystemMaintenance;
	public static JPanel panelSystemSettings;
	public static JPanel panelAbout;

	public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			FileNotFoundException, UnsupportedLookAndFeelException, IOException {
		initFrame();
	}

	public void initFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, FileNotFoundException, IOException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setToolBar();

		// 设置窗口监听器
		addWindowListener(new mainFrameWindowListener());
		// 系统语言以及字符串
		getPanelText();
		// 设置窗口标题
		setTitle(systemName);
		// 设置系统icon
		setIconImage(AppConstantsField.APP_ICON);
		// 设置窗口主色,JFrame与Frame不同
		// JFrame需要使用getContenrPane.setBackground()
		// Frame需要使用setBackground();
		getContentPane().setBackground(Color.WHITE);
		// 设置窗口使用默认关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置系统默认位置
		setLocation(AppConstantsField.MAIN_WINDOW_X_POSITION, AppConstantsField.MAIN_WINDOW_Y_POSITION);
		// 设置窗口默认大小
		setSize(AppConstantsField.MAIN_WINDOW_WIDTH, AppConstantsField.MAIN_WINDOW_HEIGHT);
		// 设置窗口大小不能改变
		setResizable(false);
	}

	private void getPanelText() throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		// 獲取系统语言
		properties.load(new FileInputStream(PathManager.PATH_MAIN_SYSTEM_PROPERTIES));
		String language = properties.getProperty(AppConstantsField.KEY_LANGUAGE);

		if (language.equals(AppConstantsField.KEY_EN_US)) {
			properties.load(new FileInputStream(PathManager.PATH_MAIN_EN_US_PROPERTIES));
		} else {
			properties.load(new FileInputStream(PathManager.PATH_MAIN_ZH_CN_PROPERTIES));

		}

		systemName = properties.getProperty(AppConstantsField.KEY_SYSTEM_NAME, "工资管理系统");

	}

	public void setToolBar() throws FileNotFoundException, IOException {
		this.setLayout(new BorderLayout());
		this.add(new MenuBarPanel(), BorderLayout.WEST);
		//this.add(new PanelInputAndModification());
		this.add(new PanelComputeAndPrintSalary());
		
	}

	class mainFrameWindowListener implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}

	}
}
