class Solution {
    public int solution(String s) {
        int answer = 0;

        int idx = 0;
        int count = 0;
        char baseChar=0;
        while(idx < s.length()){
            char c = s.charAt(idx++);

            if(count == 0) {
                baseChar = c;
                answer++;
            }
            if( c == baseChar){
                count++;
            }
            else{
                count--;
            }
        }
        return answer;
    }
}