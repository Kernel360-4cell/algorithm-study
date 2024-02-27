class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        int md = getDistance(x, y, r, c);
        int rd = k-md;
        if ( rd % 2 != 0 ) return "impossible";
        String answer = getAnswer(n, m, x, y, r, c, k);
        return answer;
    }

    private String getAnswer(int n, int m, int x, int y, int r, int c, int k){

        String[] directions = {"d", "l", "r", "u"};
        int[][] units = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

        int d = getDistance(x, y, r, c);

        if(d == 0 && k == 0) return "";

        for(int i=0; i<4; i++){
            int nx = x + units[i][0];
            int ny = y + units[i][1];
            if(isValidCoord(n, m, nx, ny) && isPossible(nx, ny, r, c, k-1)){
                String temp = getAnswer(n, m, nx, ny, r, c, k-1);

                if("impossible".equals(temp)){
                    return "impossible";
                }
                return directions[i] + temp;
            }
        }

        return "impossible";
    }
    private boolean isPossible(int x, int y, int r, int c, int k){
        int d = getDistance(x, y, r, c);
        if(d > k) return false;
        return true;
    }

    private int getDistance(int x, int y, int r, int c){
        return Math.abs(x - r) + Math.abs(y - c);
    }

    public static boolean isValidCoord(int n, int m, int x, int y){
        return y>=1 && y<=m && x>=1 && x<=n;
    }
}