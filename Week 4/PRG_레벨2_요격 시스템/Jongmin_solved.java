import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        int maxS = -1;
        int minE = 100_000_001;

        //정렬
        Arrays.sort(targets, (t1, t2)-> (t1[0]-t2[0]));
        // 처리
        for (int[] target : targets){
            maxS = Math.max(maxS, target[0]);
            minE = Math.min(minE, target[1]);
            if (minE <= maxS) {
                answer++;
                maxS = target[0];
                minE = target[1];
            }
        }
        return answer;
    }
}