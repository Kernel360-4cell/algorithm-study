import java.util.*;
class Solution {
    static int nR;
    static int nC;
    static boolean[][] visited;

    public int solution(String[] board) {
        int answer = 0;
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        nR = board.length;
        nC = board[0].length();
        visited = new boolean[nR][nC];

        Deque<int[]> queue = new ArrayDeque<>();
        for(int r=0; r< board.length; r++){
            for(int c=0; c<board[r].length(); c++){
                if(board[r].charAt(c) == 'R'){
                    queue.add(new int[]{r, c, 0});
                    visited[r][c] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] c = queue.remove();
            if(board[c[0]].charAt(c[1]) == 'G') return c[2];

            int count = c[2]+1;

            for(int i=0; i<4; i++){
                int ncr = c[0] + d[i][0];
                int ncc = c[1] + d[i][1];

                while(isNotBlocked(board, ncr, ncc)){
                    ncr += d[i][0];
                    ncc += d[i][1];
                }

                if(ncr >= 0 && ncr < nR && ncc >= 0 && ncc < nC && board[ncr].charAt(ncc) == 'G'){
                    return count;
                }

                ncr -= d[i][0];
                ncc -= d[i][1];

                if(visited[ncr][ncc]==false){
                    visited[ncr][ncc] = true;
                    queue.add(new int[]{ncr, ncc, count});
                }
            }
        }

        return -1;
    }

    private static boolean isNotBlocked (String[] board, int r, int c){
        if(r<0 || r>=board.length || c<0 || c>=board[r].length()) return false;
        if(board[r].charAt(c) == 'D') return false;
        return true;
    }
}