package backjoon.Binary_Search.Silver_1_20922;

import java.util.*;
import java.io.*;

/**
 * 문제 : 겹치는 건 싫어
 * 난이도 : 실버 1
 * 소요 시간 : 40분
 */
public class Main {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 숫자별 갯수를 cnt 하기 위한 배열
        int[] cnt = new int[200001];
        int answer = 0;

        // l, r 모두 0부터 시작하는 투포인터 사용
        int l = 0, r = 0;
        while(r < n) {
            // r을 늘리면서 해당하는 수의 개수가 k개 이하일 때 까지 쭉쭉 늘려준다.
            while (r < n && cnt[arr[r]] + 1 <= k) {
                cnt[arr[r]]++;
                r++;
            }
            // 길이 계산
            int temp = r - l;
            answer = Math.max(temp, answer);
            // 왼쪽 포인터 당겨주고 수의 개수를 차감시켜준다.
            cnt[arr[l]]--;
            l++;
        }
        System.out.println(answer);
    }
}
