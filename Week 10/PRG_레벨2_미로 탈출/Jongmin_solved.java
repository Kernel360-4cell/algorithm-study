import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        int[][] d =  new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int n = maps.length;
        int m = maps[0].length();
        Deque<int[]> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[n][m];
        // two step으로 진행하면 될 듯
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(maps[r].charAt(c) == 'S'){
                    visited[r][c] = true;
                    queue.add(new int[]{r, c, 0});
                }
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int [] info = queue.remove();

            if(maps[info[0]].charAt(info[1]) == 'L'){
                count = info[2];
                queue = new ArrayDeque<>();
                visited = new boolean[n][m];
                visited[info[0]][info[1]] = true;
                queue.add(info);
                break;
            }

            for(int i=0; i<4; i++){

                int nr = info[0] + d[i][0];
                int nc = info[1] + d[i][1];
                int c = info[2]+1;


                if(nc < 0 || nc >=m || nr<0 || nr>=n || maps[nr].charAt(nc)=='X' ||visited[nr][nc] == true){
                    continue;
                }
                queue.add(new int[] {nr, nc, c});
                visited[nr][nc] = true;
            }
        }


        if(count == 0) return -1;

        answer = count;

        while(!queue.isEmpty()){
            int [] info = queue.remove();

            if(maps[info[0]].charAt(info[1]) == 'E'){
                return info[2];
            }

            for(int i=0; i<4; i++){
                int nr = info[0] + d[i][0];
                int nc = info[1] + d[i][1];
                int c = info[2]+1;

                if(nc < 0 || nc >=m || nr<0 || nr>=n || maps[nr].charAt(nc)=='X' ||visited[nr][nc] == true){
                    continue;
                }
                queue.add(new int[] {nr, nc, c});
                visited[nr][nc] = true;
            }
        }
        if(count == answer) return -1;
        return count;

    }

}