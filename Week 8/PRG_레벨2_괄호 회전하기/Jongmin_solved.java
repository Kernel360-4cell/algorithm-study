import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        while(count < s.length()){
            char c = s.charAt(count);
            // 회전을 했을 때 첫 문자가 여는 괄호면 해당 괄호가 유효한지 체크
            // 아닌 경우 회전
            if(isOpen(c) && check(s.substring(count) + s.substring(0, count))){
                answer++;
            }
            count++;
        }
        return answer;
    }

    public static boolean isOpen(char c){
        return c == '[' || c == '{' || c == '(';
    }

    public static boolean isMatch(char c, char d){
        if (c == '{' && d == '}') return true;
        if (c == '[' && d == ']') return true;
        if (c == '(' && d == ')') return true;
        return false;
    }

    // 괄호가 유효한지 확인하는 메서드
    public static boolean check(String s){
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        int idx = 0;
        while(idx < n){
            char c = s.charAt(idx++);

            if(isOpen(c)){
                stack.push(c);
            }else if (stack.isEmpty()){
                return false;
            }else {
                char top = stack.pop();
                if(!isMatch(top, c)) return false;
            }
        }

        return stack.isEmpty();
    }
}