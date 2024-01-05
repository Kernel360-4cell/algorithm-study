package backjoon.dfs_bfs.silved_1_2667;

import java.util.*;
import java.io.*;

/**
 * 문제 : 단지번호붙이기
 * 난이도 : 실버 1
 * 소요시간 : 31분
 */
class Main {
    static int[][] graph;
    static List<Integer> list = new ArrayList<>();
    // 상, 하, 좌, 우 탐색할 인덱스 선언
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 시작
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        // 입력 끝

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 1){
//                    list.add(dfs(i, j, 1));
                    list.add(bfs(i, j, 1));
                }
            }
        }

        // list에서 정답 추출하는 작업
        sb.append(list.size());
        sb.append("\n");
        Collections.sort(list);
        for(int num : list){
            sb.append(num);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int dfs(int r, int c, int cnt){
        graph[r][c] = 0;

        // 동서남북 돌아보면서 탐색
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            // 범위 밖은 탐색 제외
            if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;
            if(graph[nr][nc] == 1)
                cnt = dfs(nr, nc, cnt+1);
        }

        return cnt;
    }

    public static int bfs(int r, int c, int cnt){
        graph[r][c] = 0;
        Queue<Integer> q = new LinkedList<>();
        // r값과 c값 넣어주기
        q.add(r);
        q.add(c);
        while (!q.isEmpty()) {
            // 큐에서 뽑은 r, c값 할당
            int qr = q.poll();
            int qc = q.poll();
            // 동서남북 돌아보면서 탐색
            for(int i = 0; i < 4; i++){
                int nr = qr + dr[i];
                int nc = qc + dc[i];
                // 범위 밖은 탐색 제외
                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;
                if(graph[nr][nc] == 1){
                    q.add(nr);
                    q.add(nc);
                    graph[nr][nc] = 0;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}