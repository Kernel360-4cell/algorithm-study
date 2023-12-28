class Solution {
    public int solution(String word) {
        int answer = 0;

        int[] values = new int[5];
        values[4] = 1;
        // 각 자리수의 value를 계산함.
        for(int i=3; i>=0; i--){
            values[i] = values[i+1]*5 + 1;
        }
        // [780, 156, 31, 6, 1]

        for(int i=0; i<word.length(); i++){
            int digit = 0;
            switch(word.charAt(i)){
                case 'A': digit = 1; break;
                case 'E': digit = 2; break;
                case 'I': digit = 3; break;
                case 'O': digit = 4; break;
                case 'U': digit = 5; break;
                default:
                    System.out.println("error");break;
            }
            answer += (digit - 1) * values[i] + 1;
        }

        return answer;
    }
}