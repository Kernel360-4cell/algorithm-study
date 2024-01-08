import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static int nCols;
    static int nRows;
    static int unripe = 0;

    static int [][] tomatos;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nCols = Integer.parseInt(st.nextToken());
        nRows = Integer.parseInt(st.nextToken());

        tomatos = new int[nRows][nCols];

        for (int y=0; y< nRows; y++){
            st = new StringTokenizer(br.readLine());
            for (int x=0; x< nCols; x++){
                tomatos[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());

    }
    private static int solution(){
        boolean [][] checked = new boolean[nRows][nCols];
        int maxD = 0;
        // 관리를 위해 안 익은 토마토의 수를 저장해놓음.
        Deque<TomatoInfo> queue = new ArrayDeque<>();
        for(int row=0; row<nRows; row++){
            for(int col=0; col<nCols; col++){
                if(tomatos[row][col] == 0){
                    unripe++;
                }else if(tomatos[row][col] == 1){
                    queue.add(new TomatoInfo(row, col));
                    checked[row][col] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            TomatoInfo info = queue.remove();
            int r = info.row;
            int c = info.col;
            int d = info.day;

            for(int i=0;i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 상하좌우가 큐에 추가되지 않았으면
                if(validCoord(nr, nc) && tomatos[nr][nc] == 0 && !checked[nr][nc]){
                    checked[nr][nc] = true;
                    maxD = Math.max(d+1, maxD);
                    unripe--;
                    queue.add(new TomatoInfo(nr, nc, d+1));
                }
            }

        }
        return unripe == 0? maxD : -1;
    }
    private static boolean validCoord(int row, int col){
        return row >=0 && row<nRows && col>=0 && col<nCols;
    }

    static class TomatoInfo {
        protected int row;
        protected int col;
        protected int day;

        protected TomatoInfo(int row, int col){
            this.row = row;
            this.col = col;
            this.day = 0;
        }
        protected TomatoInfo(int row, int col, int day){
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }
}
