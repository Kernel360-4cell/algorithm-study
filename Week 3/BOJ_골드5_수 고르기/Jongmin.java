
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[]  nums;
    public static void main(String[] args) throws IOException {
        getInput();

        System.out.println(findMinValue());

    }
    public static int findMinValue(){

        int tail=0;
        int head=0;

        int result = 2_000_000_001; // 입력값 상한과 하한의 차이가 2_000_000_000이므로 이보다 1 큰수를 설정합니다.

        // head와 tail이 규칙에 맞게 움직이기 위해서는 정렬이 필요합니다.
        Arrays.sort(nums);

        while(head < N){
            int diff = nums[head] - nums[tail];

            if (diff == M){
                return diff;
            }
            //숫자가 오름차순으로 정렬되어 있으므로 head가 앞서나간다면 항상 diff는 head가 앞서나가면 차이가 커지고 tail이 쫓아가면 차이가 작아집니다
            // 차가 M보다 작으면 head를 보내고 차가 M보다 작으면 tail을 앞으로 보냅니다.
            if (diff < M){
                head++;
            }
            else{
                result = Math.min(result, diff);
                tail++;
            }
        }
        return result;
    }

    public static void getInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
    }
}