/**
 * 문제 : 이웃한 칸
 * 난이도 : 레벨 1
 * 소요시간 : 4분
 */
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++){
            int nr = h + dr[i];
            int nc = w + dc[i];

            if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                if(board[nr][nc].equals(board[h][w])){
                    answer++;
                }
            }
        }


        return answer;
    }
}