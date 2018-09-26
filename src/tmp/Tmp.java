package tmp;

import static org.junit.jupiter.api.Assumptions.assumingThat;

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
			
			
			System.out.println(tmpSpilt[0] + ".setIcon(defaultIcon);");
		}
	}

}
