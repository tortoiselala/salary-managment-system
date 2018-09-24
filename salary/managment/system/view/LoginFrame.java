/**
 * 
 */
package salary.managment.system.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Tortoise
 *
 */
public class LoginFrame extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new LoginFrame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	/**
	 * 
	 */

	/**
	 * 
	 */
	private JTextField username;
	private JPasswordField passwordField;
	private JButton loginButton;

	private JPanel panelCenter;
	private JPanel panelSouth;

	private static int panelWidth = 535;
	private static int panelHeight = 412;

	public LoginFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		initFrame();
	}

	private void initFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// 设置窗口标题
		setTitle(AppConstantsField.APP_NAME);
		// 设置窗口图标
		setIconImage(AppConstantsField.APP_ICON);
		// 设置窗口使用默认关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口位置居中显示
		setLocation(AppConstantsField.loginWindowXPosition, AppConstantsField.loginWindowYPosition);
		// 设置窗口默认大小
		setSize(panelWidth, panelHeight);
		// 设置窗口总显示在顶部
		setAlwaysOnTop(true);
		// 设置窗口不能改变大小
		setResizable(false);
		// 设置窗口显示
		setVisible(true);
	}

	private void setPanelCenter() {
//		panelCenter = new JPanel();
//		panelCenter.setLayout(new GridLayout(3, 2));
//
//		panelCenter.add(new JLabel("Username"));
//
//		username = new JTextField();
//		panelCenter.add(username);
//		panelCenter.add(new JLabel("Password"));
//		passwordField = new JPasswordField();
//		panelCenter.add(passwordField);
//		loginButton = new JButton("login");
//		panelCenter.add(loginButton);
	}

}
