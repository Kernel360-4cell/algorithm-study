package backjoon.Divide_and_conquer.Silver_2_2630;

import java.util.*;
import java.io.*;

/**
 * 문제 : 색종이 만들기
 * 난이도 : 실버 2
 * 소요 시간 : 100분
 */
public class Main {
    public static int white = 0, blue = 0;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 데이터 입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 데이터 입력 끝

        // 재귀함수 실행
        count(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    // 재귀함수를 돌면서 1,2,3,4 분면으로 나눠서 흰색과 파란색을 체크하는 함수
    public static void count(int x, int y, int n) {
        // 현재 (x, y)의 색상
        int color = arr[x][y];
        for(int i = x; i < x+n; i++) {
            for(int j = y; j < x+n; j++) {
                if(arr[i][j] != color) {
                    // 1, 2, 3, 4 분면으로 나눠서 count하기
                    count(x, y+(n/2), n/2);
                    count(x, y, n/2);
                    count(x+(n/2), y, n/2);
                    count(x+(n/2), y+(n/2), n/2);
                    return;
                }
            }
        }

        // 만약 재귀함수를 들어가지 않았다면, 현재 블럭은 모두 하얀색 아니면 파란색이므로, cnt에 더해준다.
        if(color == 0){
            white++;
        } else {
            blue++;
        }
    }
}