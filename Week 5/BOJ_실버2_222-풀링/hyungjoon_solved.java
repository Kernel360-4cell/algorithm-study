package backjoon.Divide_and_conquer.Silver_2_17829;

import java.util.*;
import java.io.*;

/**
 * 문제 : 222-풀링
 * 난이도 : 실버 2
 * 소요 시간 : 82분
 */
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
            // ex) 8x8 배열을 4x4 배열에 저장해주기 위한 splitArr 배열 초기화
            int r = 0, c = 0;
            splitArr = new int[i/2][i/2];
            for(int j = 0; j < i; j+=2){
                // splitArr 배열은 2차원 배열이니까, 1차원 배열을 만들어서 splitArr에 append해줄 temp 배열 선언
                int[] temp = new int[i/2];
                for(int k = 0; k < i; k+=2){
                    temp[c] = getSecondNumber(j, k);
                    c++;
                    // 만약 temp의 길이가 i/2 만큼 채워지면, 다음 행을 채우기 위해 행을 바꾸고, 열을 0으로 초기화 시켜준다.
                    if(c == i/2){
                        splitArr[r] = temp;
                        r++;
                        c = 0;
                    }
                }
            }
            // 한바퀴 222-풀링을 진행한 다음에 arr을 갱신해준다.
            arr = splitArr.clone();
        }
        // 최종적으로 남게된 arr의 값을 출력
        System.out.println(arr[0][0]);
    }

    // 두 번째로 큰 값 return
    public static int getSecondNumber(int r, int c){
        Queue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        for(int i = r; i < r+2; i++){
            for(int j = c; j < c+2; j++){
                q.add(arr[i][j]);
            }
        }
        q.poll();
        return q.poll();
    }
}
