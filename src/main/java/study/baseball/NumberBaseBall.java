package study.baseball;

public class NumberBaseBall {

    boolean isStringLengthTree(String str){
        boolean bool = str.length() == 3;
        return bool;
    }

    boolean matchText(String str,String matchStr){

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
        System.out.print("strike "+strike);
        System.out.println(" ball "+ball);

        return strike == 3;
    }
}
