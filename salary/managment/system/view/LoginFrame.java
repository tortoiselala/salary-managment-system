/**
 * 
 */
package salary.managment.system.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Tortoise
 *
 */
public class LoginFrame extends JFrame {

	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914586685499059731L;

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

	public LoginFrame() {
		initFrame();
	}

	private void initFrame() {
		setPanelCenter();
		setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置窗口位置居中显示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - panelWidth / 2, screenSize.height/2 - panelHeight / 2);
		this.setSize(panelWidth, panelHeight);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void setPanelCenter() {
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(3, 2));

		panelCenter.add(new JLabel("Username"));

		username = new JTextField();
		panelCenter.add(username);
		panelCenter.add(new JLabel("Password"));
		passwordField = new JPasswordField();
		panelCenter.add(passwordField);
		loginButton = new JButton("login");
		panelCenter.add(loginButton);
	}
	
}
