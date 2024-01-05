package backjoon.dfs_bfs.gold_5_7576;

import java.util.*;
import java.io.*;

class Failed {
    static int[][] graph;
    static int N;
    static int M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!flag)
                    break;
                if (graph[i][j] == 1) {
                    riping(i, j);
                    answer = dfs(i, j, 0);
                }
            }
            if (!flag)
                break;
        }
        System.out.println(answer);
    }

    public static int dfs(int r, int c, int cnt) {
        int around = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                continue;

            if (graph[nr][nc] == -1) {
                around++;
                continue;
            }

            if (graph[nr][nc] == 0) {
                cnt = dfs(nr, nc, cnt + 1);
            }

        }
        if (around == 4)
            flag = false;

        if (flag) {
            return cnt;
        } else {
            return -1;
        }
    }

    // 4방면 과일들 익히기
    public static void riping(int r, int c) {
        int around = 4;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                around--;
                continue;
            }


            if (graph[nr][nc] == -1) {
                around--;
            }
        }
        if (around == 0)
            flag = false;
    }
}