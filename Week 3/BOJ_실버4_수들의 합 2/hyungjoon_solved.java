import java.util.*;
import java.io.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // arr 형성
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = 0;
        // 왼쪽에서 시작하는 투포인터
        int l = 0, r = 1;
        while(r <= n && l <= r) {
            // arr[l] ~ arr[r] 까지의 합이 m에 도달하지 못한다면, r을 늘려준다.
            int sum = Arrays.stream(arr, l, r).sum();
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
