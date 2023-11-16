import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(findMaxLength());
    }

    public static int findMaxLength() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int k;
        int headIdx=0;
        int tailIdx=0;
        int maxLength = 0;

        int[] counts = new int[200001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
a
        while(headIdx < n ){
            if(counts[list[headIdx]] < k){
                counts[list[headIdx]]++;
                headIdx++;
                maxLength = Math.max(headIdx - tailIdx, maxLength);
            }else {
                counts[list[tailIdx]]--;
                tailIdx++;
            }
        }

        return maxLength;
    }
}