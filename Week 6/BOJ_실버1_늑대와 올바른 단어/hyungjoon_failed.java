import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제 : 늑대와 올바른 단어
 * 난이도 : 실버 2
 * 소요 시간 : 50분
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 이전 단어를 저장하는 맵
        Map<Character, Character> map =new HashMap<>();
        map.put('o','w');
        map.put('l','o');
        map.put('f', 'l');

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = 1;
        StringBuilder sb = new StringBuilder();
        int answer = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // wolf 한 사이클이 돌거나, 처음 시작할 때 n을 1로 초기화 시켜준다.
            if(c == 'w' && (sb.length() == 0 || 'f' == sb.charAt(sb.length()-1))){
                n = 1;
                // 그 후, 새로운 단어를 받아들이기 위해 sb를 초기화 시켜준다.
                sb = new StringBuilder();
                sb.append('w');
            } else {
                // w가 없는 상태에서 o, l, f 가 들어오면 해당 문자는 올바르지 않은 단어이므로, break 시킨다.
                if(sb.length() == 0 && c != 'w') {
                    answer = 0;
                    break;
                }

                sb.append(c);
                if (c != 'w') {
                    if(sb.length() >= n){
                        char temp = sb.charAt(sb.length()-n-1);
                        // w의 개수보다 o, l, f가 많으면 올바르지 않은단어
                        // 반례) wwwoooo -> temp = o, c = o 이므로, o가 4개라서 안됨
                        // 이전 문자(w, o, l, f 중 하나)가 순서가 다르면 false
                        if(map.get(c) != temp){
                            answer = 0;
                            break;
                        }
                    } else if (sb.length() - n < 0) {
                        // sb의 길이가 n보다 작아지는 경우도 성립하지 않음, sb는 n보다 무조건 이상이어야 말이 된다.
                        // 반례) woo -> 틀린 단어
                        answer = 0;
                        break;
                    }
                } else {
                    n++;
                }
            }
        }
        System.out.println(answer);
    }
}