import java.util.*;
import java.io.*;

public class Main {
    public static int[][] arr;
    public static int[][] splitArr;

    public static void main(String[] args) throws IOException {
        // 데이터 입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 데이터 입력 끝
        System.out.println(getSecondNumber(0, 0, n));
    }

    // 두 번째로 큰 값 return
    public static int getSecondNumber(int r, int c, int size){
        int mid = size / 2;
        int[] temp = new int[4];
        // 재귀 탈출 조건, 2x2 행렬이 되면 두 번째로 큰 수를 return 해준다.
        if(size == 2){
            temp[0] = arr[r][c];
            temp[1] = arr[r+1][c];
            temp[2] = arr[r][c+1];
            temp[3] = arr[r+1][c+1];
            Arrays.sort(temp);
            return temp[2];
        }
        // 좌상단, 우상단, 좌하단, 우하단 역할의 4개 int값을 놓고, 재귀함수를 돌린다.
        int lt = getSecondNumber(r, c, mid);
        int rt = getSecondNumber(r, c+mid, mid);
        int lb = getSecondNumber(r+mid, c, mid);
        int rb = getSecondNumber(r+mid, c+mid, mid);
        // 위에 mid==2 랑 동일한 로직
        temp[0] = lt;
        temp[1] = rt;
        temp[2] = lb;
        temp[3] = rb;
        Arrays.sort(temp);
        return temp[2];
    }
}
