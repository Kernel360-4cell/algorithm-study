/**
 * 문제 : Valid Parentheses
 * 난이도 : Easy
 * 소요 시간 : 20분
 */
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                sb.append('(');
            } else if(ch == '{'){
                sb.append('{');
            } else if(ch == '['){
                sb.append('[');
            } else if(sb.length() > 0 && ch == ')' && sb.charAt(sb.length()-1) == '(') {
                sb.deleteCharAt(sb.length()-1);
            } else if(sb.length() > 0 && ch == '}' && sb.charAt(sb.length()-1) == '{') {
                sb.deleteCharAt(sb.length()-1);
            } else if(sb.length() > 0 && ch == ']' && sb.charAt(sb.length()-1) == '[') {
                sb.deleteCharAt(sb.length()-1);
            } else {
                return false;
            }
        }
        if(sb.length() != 0){
            return false;
        }
        return true;
    }
}