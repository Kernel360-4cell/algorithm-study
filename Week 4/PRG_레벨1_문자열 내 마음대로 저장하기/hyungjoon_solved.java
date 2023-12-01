import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        List<StringIndex> temp = new ArrayList<>();
        
        // for문 돌면서 list 형성
        for(String str : strings) {
            temp.add(new StringIndex(str.charAt(n), str));
        }
        
        // n번 문자 기준으로 1차 정렬 후, 문자열 기준으로 2차 정렬
        temp.sort(Comparator.comparing(StringIndex::getC).thenComparing(StringIndex::getString));
        
        // 정답에 넣어주기
        for(int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i).getString();
        }
        
        return answer;
    }
}

// [문자, 문자열] 형태로 이루어진 클래스
class StringIndex {
    private char c;
    private String str;
    
    public StringIndex(char c, String str) {
        this.c = c;
        this.str = str;
    }
    
    public char getC() {
        return c;
    }
    
    public String getString() {
        return str;
    }
    
}