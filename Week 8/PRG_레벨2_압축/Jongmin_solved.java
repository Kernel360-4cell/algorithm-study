import java.util.*;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();

        for (char alphabet='A'; alphabet<= 'Z'; alphabet++){
            dictionary.add(String.valueOf(alphabet));
        }

        int l = 0;
        int r=0 ;
        int maxLength = 1;

        while(l<msg.length()){

            r = Math.min(l+maxLength, msg.length());
            while(r > l){
                String subString = msg.substring(l, r);
                if (dictionary.contains(subString)) {
                    answer.add(dictionary.indexOf(subString) + 1);

                    if(r < msg.length()) {
                        String newWord = msg.substring(l, r + 1);

                        dictionary.add(newWord);
                        maxLength = Math.max(newWord.length(), maxLength);
                    }
                    l += subString.length();
                }else{
                    r--;
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}