import java.util.*;

/**
 * 문제 : 연속된 부분 수열의 합
 * 난이도 : 레벨 2
 * 소요 시간 : 30분
 */
class Solution {
    public int[] solution(int[] sequence, int k) {
        int l = 0, r = 0;
        int n = sequence.length;
        int sum = sequence[0];

        int[] answer = {0, n};

        // 합 >= k이면 왼쪽을 늘리고
        // 합 < k 이면 오른쪽을 늘린다.
        while(true){
            if(sum < k){
                r++;
                if(r == n)
                    break;
                sum += sequence[r];
            } else {
                if(sum == k){
                    // 길이가 짧으면 갱신, 기본값은 0, n이기 때문에
                    // 길이가 같은 경우, 시작 인덱스가 빠른건 무조건 l이 되므로 별도로 비교는 안해줘도 됨.
                    if(r - l < answer[1] - answer[0]){
                        answer = new int[]{l, r};
                    }
                }
                sum -= sequence[l];
                l++;
            }
        }
        return answer;
    }
}