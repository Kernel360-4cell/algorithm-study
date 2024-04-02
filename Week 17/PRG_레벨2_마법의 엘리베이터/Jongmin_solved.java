class Solution {
    public int solution(int storey) {
        int answer = 0;

        while(storey != 0){
            int digit = storey%10;
            storey = storey/10;

            if(digit == 5){
                if(storey % 10 < 5){
                    answer += digit;
                }else{
                    answer += (10 - digit);
                    storey += 1;
                }
            }else if( digit < 5){
                answer += digit;
            }else{
                answer += (10-digit);
                storey +=1;
            }
        }
        return answer;
    }
}