import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj13022 {
    static final String WOLF = "wolf";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String wolfSentence = br.readLine();

        System.out.println(solution(wolfSentence));

    }
    public static int solution(String sentence) {
        if(sentence.length() % 4 != 0){
            return 0;
        }
        if(sentence.charAt(sentence.length()-1) != 'f'){
            return 0;
        }

        int idx = 0;

        while(idx < sentence.length()) {
            int wCount = 0;

            //연속된 w의 수를 셈
            if(sentence.charAt(idx) != 'w'){
                return 0;
            }

            while (idx < sentence.length()) {
                if (sentence.charAt(idx) == 'w') {
                    wCount++;
                    idx++;
                } else {
                    break;
                }
            }

            // 다른 글자도 같은 수만큼 있는지 체크
            for(int i=1; i<4; i++){
                for(int j=0; j<wCount; j++){
                    if(sentence.charAt(idx) != "wolf".charAt(i)){
                        return 0;
                    }else{
                        idx++;
                    }
                }
            }
        }
        return 1;
    }
}