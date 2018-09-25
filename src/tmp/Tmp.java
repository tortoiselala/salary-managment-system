package tmp;

import java.util.Scanner;

public class Tmp {
	public static void main(String[] args) {
		Tmp tmp = new Tmp();
	}

	public Tmp() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String tmp = scanner.nextLine();
			char[] tmpToArrayChar = tmp.toCharArray();
			for (char e : tmpToArrayChar) {
				if (e >= 'a' && e <= 'z') {
					char print = (char) (e - 'a' + 'A');
					System.out.print(print);
				} else {
					System.out.print("_" + e);
				}
			}
			System.out.println();
			for (char e : tmpToArrayChar) {
				if (e >= 'A' && e <= 'Z') {
					char print = (char) (e - 'A' + 'a');
					System.out.print("_" + print);
				} else {
					System.out.print(e);
				}
			}
			System.out.println();
		}
	}

}
