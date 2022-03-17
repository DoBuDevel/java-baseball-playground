package study.baseball;

import java.util.Scanner;

public class NumberBaseBallExcute{
    public static void main(String[] args) {

        boolean isStrike = false;
        while (!isStrike) {
            isStrike = repeatStrike();
        }
        System.out.println("ㅊㅋㅊㅋ");
    }

    static boolean repeatStrike() {
        NumberBaseBall nbb = new NumberBaseBall();
        System.out.println("숫자를 입력해 주세요");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (!nbb.isStringLengthTree(str)) {
            System.out.println("숫자 길이를 확인해 주세요.");
        }

        return nbb.matchText(str, "433");
    }
}
