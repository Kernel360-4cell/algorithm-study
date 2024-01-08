import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] houseInfo;
    static boolean[][] visited ;
    static int n;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        List<Integer> groups = new ArrayList<>();

        houseInfo = new int[n][n];
        visited = new boolean[n][n];

        for(int row=0; row<n; row++){
            String line = br.readLine();
            for(int col=0; col<n; col++){
                houseInfo[row][col] = Integer.parseInt(String.valueOf(line.charAt(col)));
            }
        }

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(houseInfo[row][col] == 1 && !visited[row][col]){
                    visited[row][col] = true;
                    groups.add(findGroup(row, col));
                }
            }
        }
        Collections.sort(groups);
        System.out.println(groups.size());
        groups.forEach(System.out::println);

    }
    private static int findGroup(int row, int col){

        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(row, col));
        int count = 1;

        while(!queue.isEmpty()) {
            Point c = queue.remove();
            count += addIfValid(c.row -1, c.col, queue);
            count += addIfValid(c.row +1, c.col, queue);
            count += addIfValid(c.row, c.col -1, queue);
            count += addIfValid(c.row, c.col +1, queue);
        }
        return count;
    }

    private static int addIfValid(int row, int col, Deque<Point> queue){
        if (coordValidate(row, col) && houseInfo[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            queue.add(new Point(row, col));
            return 1;
        }else return 0;
    }

    private static boolean coordValidate(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    static class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
