import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int l = 0, r = 0;
        int n = sequence.length;


        // 합 >= k이면 왼쪽을 늘리고
        // 합 < k 이면 오른쪽을 늘린다.
        while(l <= r && l < n && r < n){
            int sum = Arrays.stream(sequence, l, r+1).sum();
            // System.out.println(sum);
            // System.out.println(l + ", " + r);
            if(sum > k){
                l++;
            } else if(sum < k){
                r++;
            } else {
                if(answer.length == 0){
                    answer = new int[]{l, r};
                } else {
                    // 기존 부분수열의 길이
                    int len = answer[1] - answer[0];
                    int curLen = r - l;
                    // 기존 부분수열의 길이보다 짧거나, 길이는 같은데 시작인덱스가 앞이라면 현재 인덱스로 변경
                    if(curLen < len || (curLen == len && l < answer[0])) {
                        answer = new int[]{l, r};
                    }
                }
                l = r;
                if(l == r && l == n-1)
                    break;
            }
        }
        return answer;
    }
}