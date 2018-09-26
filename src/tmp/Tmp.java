package tmp;

import java.util.Scanner;

import salary.managment.system.view.PathManager;

public class Tmp {
	public static void main(String[] args) {
		Tmp tmp = new Tmp();
	}

	public Tmp() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String tmp = scanner.nextLine();
			String[] tmpSpilt = tmp.split(" ");
			if (tmpSpilt.length == 2) {
				tmpSpilt[1] = tmpSpilt[1].substring(0, tmpSpilt[1].length() - 2) + "路径";
				for (String each : tmpSpilt) {
					System.out.print(each + " ");
				}
				System.out.println();
				continue;
			} else {
				String change = tmpSpilt[4];
				String change_2 = tmpSpilt[4].substring(0);
				char[] changeToArray = change.toCharArray();
				tmpSpilt[4] = "PATH" + change.substring(4);
				tmpSpilt[6] = "PathManager.PATH_SYSTEM + " + "PathManager.PATH_ICON + " + change_2;
			}
			for (String each : tmpSpilt) {
				System.out.print(each + " ");
			}
			System.out.print(";");
			System.out.println();
		}
	}

}
