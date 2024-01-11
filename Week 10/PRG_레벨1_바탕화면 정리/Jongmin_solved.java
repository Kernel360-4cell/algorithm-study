class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        int nr = wallpaper.length;
        int nc = wallpaper[0].length();
        int minx = nc;
        int miny = nr;
        int maxx = 1;
        int maxy = 1;

        for(int r=0; r<nr; r++){
            for(int c=0; c<nc; c++){
                if(wallpaper[r].charAt(c) == '#'){
                    minx = Math.min(c, minx);
                    miny = Math.min(r, miny);
                    maxx = Math.max(c+1, maxx);
                    maxy = Math.max(r+1, maxy);
                }
            }
        }
        answer = new int[] {miny, minx, maxy, maxx};
        return answer;
    }
}