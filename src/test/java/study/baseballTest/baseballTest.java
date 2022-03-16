package study.baseballTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class baseballTest {
    @ParameterizedTest
    @ValueSource(strings = {"1","234","3","4"})
    void isStringLenthTree(String str){
        boolean bool = str.length() == 3;
        assertTrue(bool);
        //return bool;
    }
    @ParameterizedTest
    @ValueSource(strings = {"123","234","333","411"})
    void matchText(String str){
        String matchStr = "123";

        int strike =0;
        int ball = 0;

        for(int i=0; i<str.length(); i++){
            char a = str.charAt(i);
            if(matchStr.contains(a+"")){
                if(matchStr.charAt(i) == a){
                    strike++;
                }else {
                    ball++;
                }
            }
        }
        System.out.println("str :"+str);
        System.out.print("strike "+strike);
        System.out.println(" ball "+ball);

        assertEquals(strike,3);
    }

}
