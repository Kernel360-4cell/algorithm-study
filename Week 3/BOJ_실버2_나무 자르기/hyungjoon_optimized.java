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

        int[] arr = new int[n];

        // 나무들은 정렬되어 있지 않다. 따라서, 나무를 대상으로 l과 r포인터를 잡는게 아니라,
        // 높이를 기준으로 l과 r포인터를 잡아야 한다.
        // r을 구할 때 stream으로 구해버리면 N을 두번 돌아서 시초가 발생한다.
        // 따라서 배열을 만들어줌과 동시에 r값을 구해주자.
        int l = 0, r = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, arr[i]);
        }
        
        int answer = 0;
        while(l <= r){
            // 기준을 잡을 mid 값
            int mid = (l+r) / 2;
            long temp = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] > mid){
                    temp += arr[i] - mid;
                }
            }

            // 벌목량이 m 이상이면 정답 갱신
            if(temp >= m){
                l = mid + 1;
                answer = answer > mid ? answer : mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }
}