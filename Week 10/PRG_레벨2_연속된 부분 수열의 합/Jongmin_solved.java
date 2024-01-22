
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        answer[0] = 0;
        answer[1] = sequence.length;

        int lidx = 0;
        int ridx = 0;
        int sum=0;
        for(int i=lidx; i<=ridx; i++){
            sum += sequence[i];
        }

        while(lidx<sequence.length && ridx<sequence.length){

            if( sum < k){
                if(ridx+1 < sequence.length) sum += sequence[++ridx];
                else break;
            }else if( sum > k ){
                sum -= sequence[lidx++];
            }else{
                if((ridx - lidx) < (answer[1] - answer[0]) ){
                    answer[0] = lidx;
                    answer[1] = ridx;
                }
                sum -= sequence[lidx++];

            }
        }

        return answer;

    }
}