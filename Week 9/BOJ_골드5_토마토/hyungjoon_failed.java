import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int N;
    static int M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

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
                // 여기가 핵심.. 동시에 bfs를 시작해야 하므로, 큐에 좌표를 넣어줘야 함.
                if(graph[i][j] == 1)
                    q.add(new int[]{i, j});
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                // 익지 않은 사과가 있다면 익힘과 동시에 날짜를 카운트해줌. 즉, graph[nr][nc]-1은 몇 일에 사과가 익었는지를 나타냄.
                if (graph[nr][nc] == 0) {
                    graph[nr][nc] = graph[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        int answer = -1;
        // 다 못익는 토마토상자인지 확인
        if (checkAround()) {
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 가장 높은 값이 모든 사과를 익히는 최소값
                    answer = Math.max(graph[i][j], answer);
                }
            }
        }
        // 1부터 시작했기 때문에 -1 해주기
        return answer-1;
    }

    // bfs를 수행했음에도 안익은 사과(0)가 남아있다는 것은, 다 익히지 못한다는 것을 의미함.
    public static boolean checkAround() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

}