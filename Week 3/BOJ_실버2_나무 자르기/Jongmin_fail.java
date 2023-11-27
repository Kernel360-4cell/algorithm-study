import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  백준 2805 나무자르기
 * */
public class Main {
    static int N;
    static int M;
    static int[] woodHeightList;

    public static void main(String[] args) throws IOException {
        getData();

        Arrays.sort(woodHeightList);
        int maxheight = woodHeightList[N-1];
        int minHeight = woodHeightList[0];
        int mid;
        while(maxheight >= minHeight){
            mid = (maxheight+minHeight)/2;
            long cutWoodTotalHeight = getWood(mid);

            if(cutWoodTotalHeight == M){
                maxheight = mid;
                break;
            }

            // 잘린 나무의 합이 목표에 미치지 못하면 높이를 낮춘다
            if (cutWoodTotalHeight < M){
                maxheight = mid-1;
            } else{
                minHeight = mid+1;
            }
        }

        System.out.println(maxheight);
    }

    private static long getWood(int h) {
        long totalHeight = 0;
        for(int woodHeight : woodHeightList){
            totalHeight += Math.max(woodHeight-h, 0);
            if(totalHeight > M){
                break;
            }
        }
        return totalHeight;
    }

    private static void getData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        woodHeightList = new int[N];

        for(int i=0; i<N; i++){
            woodHeightList[i] = Integer.parseInt(st.nextToken());
        }
    }
}