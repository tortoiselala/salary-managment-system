/**
 * 
 */
package salary.managment.system.view.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import salary.managment.system.submenubar.SubMenuBarInquirySalary;
import salary.managment.system.submenubar.SubMenuBarSystemMaintenance;
import salary.managment.system.view.AppConstantsField;

/**
 * @author Tortoise
 *
 */
public class PanelSystemMaintenance extends JPanel {

	public static SubMenuBarSystemMaintenance subMenuBarSystemMaintenance;

	public PanelSystemMaintenance() throws FileNotFoundException, IOException {
		Dimension preferredSize = new Dimension(AppConstantsField.MAIN_PANEL_WIDTH,
				AppConstantsField.MAIN_PANEL_HEIGHT);
		this.setPreferredSize(preferredSize);
		this.setMaximumSize(preferredSize);
		this.setMinimumSize(preferredSize);
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.addSubMenuBar();
	}

	private void addSubMenuBar() throws FileNotFoundException, IOException {
		subMenuBarSystemMaintenance = new SubMenuBarSystemMaintenance();
		add(subMenuBarSystemMaintenance, BorderLayout.WEST);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
