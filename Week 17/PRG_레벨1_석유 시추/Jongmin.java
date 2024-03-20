import java.util.*;

class Solution {
    public static int TC; // Total colums
    public static int TR; // Totla rows
    public static boolean[][] visited;
    public static int[][] directions = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
    public int solution(int[][] land) {
        int answer = 0;
        int[] oils;
        TC = land[0].length;
        TR = land.length;
        visited = new boolean[TR][TC];

        oils = new int[TC];
        for(int i=0; i< TC; i++){
            oils[i] = 0;
        }

        for(int c=0; c<TC; c++){
            for(int r=0; r<TR; r++)
                if(land[r][c] == 1 &&!visited[r][c]){
                    List<Integer> rv = getOilSize(r, c, land);
                    for(int i=rv.get(1); i<=rv.get(2); i++){
                        oils[i]+=rv.get(0);
                    }
                }
        }
        answer = oils[0];
        for(int i=0; i< TC; i++){
            answer = Math.max(answer, oils[i]);
        }

        return answer;
    }


    static List<Integer> getOilSize(int r, int c, int[][] land){

        int size = 1;
        int minC = c;
        int maxC = c;

        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;

        while(!queue.isEmpty()){

            Point point = queue.removeFirst();

            int cc = point.getC();
            int cr = point.getR();

            for(int i=0; i<4; i++){
                int dc = directions[i][1];
                int dr = directions[i][0];

                int nc = cc + dc;
                int nr = cr + dr;

                if(isValidCooridate(nr, nc)&& land[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    size++;
                    queue.add(new Point(nr, nc));
                    minC = Math.min(minC, nc);
                    maxC = Math.max(maxC, nc);
                }

            }// end for


        }// end while


        return List.of(size, minC, maxC);

    }

    private static boolean isValidCooridate(int r, int c){
        return r>=0 && r<TR && c>=0 && c< TC;
    }
    static class Point{
        private int r;
        private int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        public int getC(){
            return this.c;
        }
        public int getR(){
            return this.r;
        }
    }
}