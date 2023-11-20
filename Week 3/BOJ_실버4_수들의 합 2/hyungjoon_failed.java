import java.util.*;
import java.io.*;

public class Main {
    private static int[] arr;
    private static int[] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // arr 형성
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 누적합을 관리하는 sumArr 생성
        sumArr = new int[n];
        sumArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = arr[i] + sumArr[i-1];
        }

        int answer = 0;
        // 왼쪽에서 시작하는 투포인터
        int l = 0, r = 1;
        while(r < n && l <= r) {
            // arr[l] ~ arr[r] 까지의 합이 m에 도달하지 못한다면, r을 늘려준다.
            int sum = sumArr[r] - sumArr[l];
            if (sum < m) {
                r++;
            } else if(sum == m) {
                // m이라면 r을 늘려준다.
                answer++;
                r++;
            } else {
                // sum이 m을 넘어버리면 l을 당겨준다.
                l++;
            }
        }
        System.out.println(answer);
    }
}
