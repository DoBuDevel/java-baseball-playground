package study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculator {

    private Set<String> calStrSet;

    @BeforeEach
    void set(){
        calStrSet = new HashSet<>();
        calStrSet.add("+");
        calStrSet.add("-");
        calStrSet.add("/");
        calStrSet.add("*");
    }

    int add(int i, int j) {
        return i + j;
    }
    int subtract(int i, int j){
        return i - j;
    }
    int multiply(int i, int j){
        return i * j;
    }
    int divide(int i, int j){
        return i / j;
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public static int calculator(String value) {

        String[] strArr = value.split(" ");
        List<Integer> intArr = new ArrayList<>();
        List<String> signArr = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];

            if (i % 2 == 0 && !isNumber(str)) {
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
    public static boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(calculator("2 + 3 * 4 / 2"));
    }

}
