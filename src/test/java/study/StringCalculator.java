package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    int calculator(String value) {

        String[] strArr = value.split(" ");
        List<Integer> intArr = new ArrayList<>();
        List<String> signArr = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];

            if (i / 2 == 0 && !isNumber(str)) {
                System.out.println("계산식을 확인해 주세요.");
                return 0;
            }

            if (isNumber(str)) {
                int num = Integer.parseInt(str);
                intArr.add(num);
            } else {
                signArr.add(str);
            }
        }

        Calculator cal = new Calculator();

        int result = intArr.get(0);
        for (int i = 0; i < signArr.size(); i++) {
            String s = signArr.get(i);

            if (s.equals("+")) {
                result = cal.add(result, intArr.get(i + 1));
            }
            if (s.equals("-")) {
                result = cal.subtract(result, intArr.get(i + 1));
            }
            if (s.equals("/")) {
                result = cal.divide(result, intArr.get(i + 1));
            }
            if (s.equals("*")) {
                result = cal.multiply(result, intArr.get(i + 1));
            }
        }
        return result;
    }

    @ParameterizedTest
    @ValueSource(strings = {"2"})
    boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
