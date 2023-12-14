import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;

import java.util.Set;
import java.util.StringTokenizer;

public class Boj19583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String line = null;

        Set<String> onList = new HashSet<>();
        Set<String> offList = new HashSet<>();
        // 첫라인 시작 시간, 끝낸 시간, 스트리밍 종료 시간
        String[] times = new String[3];
        for (int i=0; i<3; i++){
            times[i] = st.nextToken();
        }

        // 한 줄씩 읽어서 처리
        while( (line = br.readLine()) != null && !line.isEmpty()){
            st = new StringTokenizer(line);
            String time = st.nextToken();
            String name = st.nextToken();

            // 시간이 개강총회 시작(times[0] 전이면
            if(time.compareTo(times[0]) <= 0) {
                onList.add(name);
            }
            else if(time.compareTo(times[1]) >= 0  && time.compareTo(times[2]) <= 0 ){
                offList.add(name);
            }
            // 중간에 입력한 채팅은 무시
        }

        onList.retainAll(offList);
        System.out.println(onList.size());
    }

}