package backjoon.string.Silver_2_19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제 : 싸이버개강총회
 * 난이도 : 실버 2
 * 소요 시간 : 52분
 */
public class Main {
    static String s, e, q;
    static int sm, em, qm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = st.nextToken();
        e = st.nextToken();
        q = st.nextToken();

        // 계산의 편의를 위해 s, e, q를 분으로 환산
        String[] sTemp = s.split(":");
        String[] eTemp = e.split(":");
        String[] qTemp = q.split(":");

        // (시 * 60) + 분
        sm = (Integer.parseInt(sTemp[0]) * 60) + Integer.parseInt(sTemp[1]);
        em = (Integer.parseInt(eTemp[0]) * 60) + Integer.parseInt(eTemp[1]);
        qm = (Integer.parseInt(qTemp[0]) * 60) + Integer.parseInt(qTemp[1]);

        // 입장 유저와 퇴장 유저를 구분할 셋 두개 선언
        Set<String> inUsers = new HashSet<>();
        Set<String> outUsers = new HashSet<>();
        String input;

        // 이부분에서 null체크를 먼저 안해서 자꾸 NPE가 발생함.. 아오 여기서 시간 많이걸림;
//        while(!(input = br.readLine()).isEmpty() && input != null){
        while((input = br.readLine()) != null && !input.isEmpty()){
            st = new StringTokenizer(input);

            String tt = st.nextToken();
            String nickname = st.nextToken();
            String[] t = tt.split(":");


            int time = (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);

            // 입장 기준 : 채팅시간 <= 시작시간
            // 퇴장 기준 : 종료시간 >= 채팅시간 <= 스트리밍 종료시간
            // 스트리밍 종료 이후 시간은 count x
            if (time <= sm) {
                inUsers.add(nickname);
            } else if (time >= em && time <= qm) {
                outUsers.add(nickname);
            }
        }

        int count = 0;
        // 입장과 퇴장 모두 한 유저만 골라야 하므로, 입장시간 기준으로 for문을 돈다.
        for (String user : inUsers) {
            if(outUsers.contains(user)) count++;
        }
        System.out.println(count);
    }
}
