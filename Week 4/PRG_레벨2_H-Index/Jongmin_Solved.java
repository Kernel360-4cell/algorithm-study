import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= (citations.length - i)
                    && ((i == 0) || (citations[i - 1] <= (citations.length - i)))
            ) {
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }
}