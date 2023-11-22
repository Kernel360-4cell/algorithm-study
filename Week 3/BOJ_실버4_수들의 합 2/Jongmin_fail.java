import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sizeOfList;
    static int targetScore;
    static int[] listNumber;

    public static void main(String[] args) throws IOException {
        getInput();

        System.out.println(getCount());
    }

    static int getCount() {
        int headIdx = 0;
        int tailIdx = -1;
        int sum = listNumber[0];
        int count = 0;
        while(headIdx < sizeOfList ){

            if(sum == targetScore){
                count++;

                tailIdx++;
                sum -= listNumber[tailIdx];

                if(headIdx+1 < sizeOfList) {
                    headIdx++;
                    sum += listNumber[headIdx];
                }
            }
            else if (sum < targetScore){
                if(headIdx+1 < sizeOfList) {
                    headIdx++;
                    sum += listNumber[headIdx];
                }
            }
            else{
                tailIdx++;
                sum -= listNumber[tailIdx];
            }
        }
        return count;
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sizeOfList = Integer.parseInt(st.nextToken());
        targetScore = Integer.parseInt(st.nextToken());

        listNumber = new int[sizeOfList];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < sizeOfList; i++){
            listNumber[i] = Integer.parseInt(st.nextToken());
        }
    }
}