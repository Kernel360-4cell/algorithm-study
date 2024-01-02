import java.util.*;

/**
 * 문제 : Longest Common Prefix
 * 난이도 : Easy
 * 소요 시간 : 20분
 */
class Solution {
    int min = 201;
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strs.length; i++){
            min = Math.min(min, strs[i].length());
        }

        Arrays.sort(strs);

        for(int i = 0; i < min; i++){
            char temp = strs[0].charAt(i);
            boolean flag = true;
            for(int j = 0; j < strs.length; j++){
                char c = strs[j].charAt(i);
                if(temp != c){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
            sb.append(temp);
        }

        return sb.toString();
    }
}