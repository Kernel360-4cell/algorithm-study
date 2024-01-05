import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static int[][] edges;
    static int nV;
    static int nE;
    static int startV;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(st.nextToken())-1;
        edges = new int[nV][nV];

        for(int i=0; i<nE; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            edges[from][to] = 1;
            edges[to][from] = 1;
        }

        travelDFS(startV);
        travelBFS();
    }
    private static void travelDFS(int startV){
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[nV];

        sb.append(startV+1).append(" ");
        visited[startV] = true;
        DFS(startV, visited, sb);

        System.out.println(sb);
    }
    private static void DFS(int start, boolean[] visited, StringBuilder sb){
        int from = start;

        for(int i=0; i < nV; i++){
            if(!visited[i] && edges[from][i] == 1){
                sb.append(i+1).append(" ");
                visited[i] = true;
                DFS(i, visited, sb);
            }
        }
    }
    private static void travelBFS (){
        boolean [] visited = new boolean[nV];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(startV);
        visited[startV] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(startV+1);
        while(!queue.isEmpty()){
            int from = queue.remove();

            for(int to=0; to< nV; to++){
                if(edges[from][to] == 1 && !visited[to]){
                    queue.add(to);
                    visited[to] = true;
                    sb.append(" ").append(to+1);
                }
            }
        }
        System.out.println(sb);
    }
}
