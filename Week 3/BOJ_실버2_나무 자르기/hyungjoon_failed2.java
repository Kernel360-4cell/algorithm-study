import java.util.*;
import java.io.*;

/**
 * 문제 : 나무 자르기
 * 난이도 : 실버 2
 * 소요 시간 : 80분
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = 0;
        // 나무들은 정렬되어 있지 않다. 따라서, 나무를 대상으로 l과 r포인터를 잡는게 아니라,
        // 높이를 기준으로 l과 r포인터를 잡아야 한다.
        int l = 0, r = Arrays.stream(arr).max().getAsInt();
        while(l <= r){
            // 기준을 잡을 mid 값
            int mid = (l+r) / 2;
            int temp = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] > mid){
                    temp += arr[i] - mid;
                }
            }

            // 벌목량이 m 이상이면 정답 갱신
            if(temp >= m){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l+1);
    }
}