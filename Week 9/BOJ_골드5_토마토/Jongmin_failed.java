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
        // 관리를 위해 안 익은 토마토의 수를 저장해놓음.
        for(int r=0; r<nRows; r++){
            for(int c=0; c<nCols; c++){
                if (tomatos[r][c] == 0){
                    unripe += 1;

                }
            }
        }

        // 지나간 날짜를 저장.
        int count = 0;
        while(unripe != 0){
            boolean changed = false;
            boolean[][] todayChanged = new boolean[nRows][nCols];

            for(int row=0; row<nRows; row++){
                for (int col=0; col<nCols; col++){
                    if (tomatos[row][col] == 1 && !todayChanged[row][col]){
                        for(int i=0; i<4; i++){
                            int nr = row + dr[i];
                            int nc = col + dc[i];
                            if(validCoord(nr, nc)&& tomatos[nr][nc] == 0){
                                tomatos[nr][nc] = 1;
                                todayChanged[nr][nc] = true;
                                changed = true;
                                unripe--;
                            }
                        }
                    }
                }
            }
            if(!changed ) break;
            count++;
        }

        return unripe ==0? count : -1;


    }
    private static boolean validCoord(int row, int col){
        return row >=0 && row<nRows && col>=0 && col<nCols;
    }
}
