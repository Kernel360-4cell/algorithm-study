package programmers.string.level_1_140108;

import java.util.*;

/**
 * 문제 : 문자열 자르기
 * 난이도 : 레벨 1
 * 소요 시간 : 45분
 */
class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        while(s.length() > 1){
            int index = 0;
            char c = s.charAt(index);
            int xCount = 1;
            int notxCount = 0;
            // 인덱스가 초과되지 않도록 조건을 걸어줘야함
            while(xCount != notxCount && index < s.length()-1){
                index++;
                if(s.charAt(index) == c){
                    xCount++;
                } else {
                    notxCount++;
                }
            }
            if(xCount == notxCount) answer++;
            s = s.substring(index+1);
        }
        answer++;
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aa"));
    }
}
