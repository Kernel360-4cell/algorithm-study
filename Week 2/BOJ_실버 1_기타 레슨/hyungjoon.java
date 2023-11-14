import java.io.*;
import java.util.*;

/**
 * 문제 : 기타 레슨
 * 난이도 : 실버 1
 * 소요 시간 : 1시간 30분
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 이분탐색 수행을 위한 start와 end값 설정
        int s = Arrays.stream(arr).max().orElse(0);
        int e = Arrays.stream(arr).sum();

        while (s <= e) {
            // 블루레이별 길이와 수
            int total = 0;
            int cnt = 1;

            int mid = (s + e) / 2;
            for (int time:arr) {
                if (total + time > mid) {
                    total = 0;
                    cnt += 1;
                }
                total += time;
            }
            if (cnt <= m) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(s);
    }
}
