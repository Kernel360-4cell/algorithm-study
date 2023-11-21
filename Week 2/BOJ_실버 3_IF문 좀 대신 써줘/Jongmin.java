package week2.fri;

import java.util.*;
import java.io.*;

public class Main {
    static List<Title> titles = new ArrayList<>();
    static int N;
    static int M;

    static class Title implements Comparable<Title>{
        String name;
        int upperPower;

        public Title(String name, int upperPower) {
            this.name = name;
            this.upperPower = upperPower;
        }

        // 사실 필요 없는데 혹시 upperPower를 스트링으로 받아서 생긴 문젠가 해서 만든 생성자
        public Title(String name, String upperPower) {
            this(name, Integer.parseInt(upperPower));
        }


        // 여기서 쓰일 일은 없었는데 입력받은 칭호가 정렬이 되지 않은 상태라면 정렬하기 위해 만든 비교 함수
        @Override
        public int compareTo(Title other) {
            // 오름차순으로 정렬
            return Integer.compare(this.upperPower, other.upperPower);
        }
    }

    /**
     * 캐릭터의 파워를 입력받아 칭호를 부여하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /**
         * 칭호와 upper leve을 입력받아 저장하는 곳을 분리했습니다.
         */

        inputTitles(N, br);

        for (int i = 0; i < M; i++) {
            int newCharacterPower = Integer.parseInt(br.readLine());

            //캐릭터의 파워를 통해서 칭호를 얻습니다.
            String title = findTitle(newCharacterPower);
            // StringBuilder로 결과 출력데이터를 쌓습니다.
            sb.append(title+"\n");
        }
        System.out.println(sb);
    }

    /**
     * 칭호와 upperlevel을 입력받는 곳입니다
     *
     * upperlevel이 겹쳐도 입력을 받습니다.
     */

    private static void inputTitles(int N, BufferedReader br) throws IOException {
        // 칭호(title)와 upper power를 입력받아 저장합니다.

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            titles.add(new Title(name, power));
        }
    }


    /**
     * 캐릭터의 파워를 통해서 칭호를 얻는 이진 탐색 기법
     *
     * @param targetPower: 캐릭터의 파워
     * @return 칭호
     */
    static String findTitle(int targetPower) {
        int left = 0, right =  N-1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (titles.get(mid).upperPower >= targetPower) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return titles.get(left).name;
    }
}
