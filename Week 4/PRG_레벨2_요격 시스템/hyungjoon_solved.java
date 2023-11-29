import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        double cur = -1;
        int answer = 0;

        // 끝나는 지점을 기준으로 오름차순 정렬
        Arrays.sort(targets, (a, b) -> {
            return a[1] - b[1];
        });

        // 기존에 발사한 요격 미사일(cur)로 커버가 안되는 미사일이라면 새로 하나 발사하고, 이 미사일의 범위를 e - 0.5로 지정
        // e - 0.5인 이유는 이 미사일로 뽕을 뽑기 위함임
        for(int i = 0; i < targets.length; i++){
            if(cur < targets[i][0]){
                answer++;
                cur = targets[i][1] - 0.5;
            }
        }

        return answer;
    }
}
