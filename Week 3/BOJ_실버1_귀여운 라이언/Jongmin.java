import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] dollList;

    static int numberOfLions = 0;
    public static void main(String[] args) throws IOException {

        int head = -1;
        int tail = -1;

        getData();

        int minLength = N +1;

        tail = findNextLion(tail);
        while (head < N && tail < N){

            // 첫 반복문 이후로 사실상 while문이 의미 없지만 처음에는 세번 돌아야하므로.
            while(numberOfLions < K && head < N) {
                head = findNextLion(head);
                numberOfLions++;
            }
            if( head >= N){
                break;
            }
            minLength = Math.min(head - tail + 1, minLength);

            tail = findNextLion(tail);
            numberOfLions--;
        }// end while

        // 만약 못 찾으면 minLength 가 갱신되지 않을 것이므로 이 경우는 최대한 큰 숫자를 디폴트로 넣어줬습니다.
        if(minLength != N +1){
            System.out.println(minLength);
        }
        else {
            System.out.println(-1);
        }
    }

    //제목대로 다음 라이언의 인덱스를 찾습니다.
    private static int findNextLion(int idx) {
        while(++idx < N){
            if(dollList[idx] == 1){
                break;
            }
        }
        return idx;
    }

    // 데이터를 입력받는 부분입니다.
    private static void getData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dollList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; i++){
            dollList[i] = Integer.parseInt(st.nextToken());
        }
    }
}