package programmers.dfs_bfs.level_2_250136;

import java.util.*;

class Solution {
    public int[] dr = new int[]{-1, 1, 0, 0};
    public int[] dc = new int[]{0, 0, -1, 1};

    public int n, m;
    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;

        // 열 하나씩 뚫으면서 dfs를 수행해나간다.
        for(int i = 0; i < m; i++){
            // 깊은 복사
//            int[][] copiedLand = land.clone(); // 이건 2차원 배열에 사용할 수 없음, for문 직접 돌려야 함
            int[][] copiedLand = new int[n][m];

            for(int r = 0; r < n; r++){
                for(int c = 0; c < m; c++){
                    copiedLand[r][c] = land[r][c];
                }
            }

            // i열을 뚫었을 때 얻을 수 있는 석유의 양을 temp에 저장
            int temp = 0;
            for(int j = 0; j < n; j++){
                // 석유를 발견하면 dfs 수행
                if(copiedLand[j][i] == 1){
                    int amount = dfs(j, i, copiedLand, 1);
                    temp += amount;
                }
//                System.out.println(j + "행" + i + "열" + temp + "개");
//                System.out.println(Arrays.deepToString(copiedLand) + "\n");
            }
            answer = Math.max(temp, answer);
        }

        return answer;
    }

    public int dfs(int r, int c, int[][] land, int cnt) {
        // 방문처리
        land[r][c] = 0;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nr >= n || nc < 0 || nc >= m){
                continue;
            }
            if(land[nr][nc] == 1){
                cnt = dfs(nr, nc, land, cnt+1);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] param = new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(solution.solution(param));
    }
}