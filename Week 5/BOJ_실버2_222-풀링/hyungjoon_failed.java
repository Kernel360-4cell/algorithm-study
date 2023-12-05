package backjoon.Divide_and_conquer.Silver_2_17829;

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

        // arr를 2배씩 줄여나간다.
        for(int i = n; i > 1; i/=2){
            // 8x8 배열을 4x4 배열에 저장해주기 위한 temp 배열 초기화
            int r = 0, c = 0;
            splitArr = new int[i/2][i/2];
            for(int j = 0; j < i; j+=2){
                int[] temp = new int[i/2];
                for(int k = 0; k < i; k+=2){
                    temp[c] = getSecondNumber(j, k);
                    c++;
                    if(c == i/2){
                        splitArr[r] = temp;
                        r++;
                        c = 0;
                    }
                }
            }
            arr = splitArr.clone();
        }
        System.out.println(arr[0][0]);
    }

    // 두 번째로 큰 값 return
    public static int getSecondNumber(int r, int c){
        int first = -10001, second = -10001;
        for(int i = r; i < r+2; i++){
            for(int j = c; j < c+2; j++){
                if(arr[i][j] > first){
                    second = first;
                    first = arr[i][j];
                } else if(arr[i][j] < first && arr[i][j] > second){
                    second = arr[i][j];
                }
            }
        }
        return second;
    }
}
