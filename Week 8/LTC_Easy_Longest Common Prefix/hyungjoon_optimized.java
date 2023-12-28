import java.util.*;

class Solution {
    int min = 201;
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);

        // 정렬을 수행해서 맨앞/맨뒤 글자만 판별하면 된다. 따라서 앞/뒤 글자수만 비교하면 된다.
        String first = strs[0];
        String last = strs[strs.length-1];

        min = Math.min(first.length(), last.length());

        for(int i = 0; i < min; i++){
            if(first.charAt(i) != last.charAt(i)){
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }

        return sb.toString();
    }
}