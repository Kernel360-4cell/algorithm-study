package programmers.brute_force.level_1_161990;

/**
 * 문제 : 바탕화면 정리
 * 난이도 : 레벨 1
 * 소요시간 : 19분
 */
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        // S는 파일이 존재하는 선에서 제일 왼쪽+위쪽
        // E는         ''       제일 아래쪽+오른쪽
        // N^2로 돌고나면 알 수 있다.

        // lux, luy, rdx, rdy의 최소,최댓값을 계속 업데이트해주면 된다.
        // lux, luy는 최소
        // rdx, rdy는 최대값으로 업데이트해주자.

        int lux = 51, luy = 51;
        int rdx = -1, rdy = -1;

        int n = wallpaper.length;
        int m = wallpaper[0].length();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        // 커서가 끝나는 오른쪽은 파일을 포함해야 해서 +1 해줘야함.
        answer = new int[]{lux, luy, rdx+1, rdy+1};

        return answer;
    }
}