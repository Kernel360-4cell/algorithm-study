class Solution {
    static int nCols;
    static int nRows;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        nRows = heights.length;
        nCols = heights[0].length;

        for(int row=0; row< nRows; row++){
            for(int col=0; col< nCols; col++){
                if(check(heights, row, col)){
                    result.add(List.of(row, col));
                }
            }
        }

        return result;

    }
    public static boolean check(int[][] heights, int row, int col){

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        boolean[][] visited = new boolean[nRows][nCols];

        Deque<List<Integer>> queue = new ArrayDeque<>();
        boolean reachablePacific = false;
        boolean reachableAtlantic = false;

        queue.add(List.of(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty() && !(reachableAtlantic && reachablePacific)){
            List<Integer> position = queue.removeFirst();
            int cr = position.get(0);
            int cc = position.get(1);

            for(int i=0; i<4; i++){
                int nr = position.get(0) + dr[i];
                int nc = position.get(1) + dc[i];

                if(nc < 0 || nr < 0){
                    reachablePacific = true;
                }
                if(nc == nCols || nr == nRows){
                    reachableAtlantic = true;
                }
                if(nc>=0 && nc< nCols && nr>=0 && nr< nRows && heights[nr][nc] <= heights[cr][cc] && !visited[nr][nc]){
                    queue.add(List.of(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        return reachablePacific && reachableAtlantic;
    }
}