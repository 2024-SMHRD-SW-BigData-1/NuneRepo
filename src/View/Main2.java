package View;

import java.util.Random;
import java.util.Scanner;

import Controller.Controller2;
import Model.NuneDamaDTO;

public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.print("회원 ID >> ");
		String id = sc.next();
		NuneDamaDTO dto = new NuneDamaDTO(id);

		int exp = 0;
		int hp = 100;
		int lv = 1;

		System.out.println("==== 메뉴 선택 ====");

		while (true) {
			System.out.println("[1]먹이 주기 [2]트레이닝 [3]잠자기 [4]놀기 [5]정보창 [6]게임 종료");
			int select = sc.nextInt();

			if (select == 1) {

				System.out.println("==== 먹이주기 ====");

				int ran = rd.nextInt(10);

				System.out.println("홀수일까요 짝수일까요 : [1] 짝수 [2] 홀수");
				int choice = sc.nextInt();
				if (ran % 2 == (choice - 1)) {
					hp += 20;
					System.out.println("정답입니다! " + "체력+20!");
				} else {
					System.out.println("오답입니다...");
				}

			} else if (select == 2) {

				System.out.println("==== 트레이닝 ====");

				int p = rd.nextInt(10);
				int c = rd.nextInt(10);
				if (p > c) {
					exp += 10;
					System.out.println("대결에 승리하였습니다! " + "경험치+10!");
				} else {
					hp -= 5;
					System.out.println("대결에 패배하였습니다... " + "체력-5");
				}

			} else if (select == 3) {

				System.out.println("==== 잠자기 ====");

				int num1 = rd.nextInt(9) + 1;
				int num2 = rd.nextInt(9) + 1;

				System.out.println(num1 + "X" + num2 + "=" + "?");
				int ans = sc.nextInt();

				if (num1 * num2 == ans) {
					System.out.println("편안히 잠에 듭니다 " + "체력+40!");
				} else {
					System.out.println("잠을 재우지 않습니다...");
				}

			} else if (select == 4) {

				System.out.println("==== 놀기 ====");
				int c = rd.nextInt(3) + 1;
				System.out.println("선택하세요 : [1]가위, [2]바위, [3]보");
				int p = sc.nextInt();
				if (c == p) {
					System.out.println("비겼습니다..");
				} else if ((c == 1 && p == 2) || (c == 2 && p == 3) || (c == 3 && p == 1)) {
					exp += 15;
					System.out.println("이겼습니다! " + "경험치+15");
				} else if ((c == 2 && p == 1) || (c == 3 && p == 2) || (c == 1 && p == 3)) {
					hp -= 10;
					System.out.println("졌습니다ㅠㅠ " + "체력-10");
				} else {
					System.out.println("그런 선택지는 없습니다 선생님");
				}

			} else if (select == 5) {
				Controller2 con = new Controller2();
				con.select(dto);

			} else {
				System.out.println("게임이 종료되었습니다.");
				break;
			}

			if (exp >= 100) {
				lv += 1;
				exp -= 100;
				System.out.println("레벨업하였습니다!");
			}
			if (hp <= 0) {
				System.out.println("포켓몬이 무지개 다리를 건넜습니다ㅠㅠ");
				break;
			}
		}

	}

}
