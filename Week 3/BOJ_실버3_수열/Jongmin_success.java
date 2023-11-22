import java.util.Scanner;

public class Main {
    // 전체 날짜의 길이
    static int numDays;

    // 연속적인 날짜 길이
    static int consecutiveDays;

    // 전체 온도
    static int[] tempList;
    public static void main(String[] args) {

        //입력
        Scanner scanner = new Scanner(System.in);

        numDays = scanner.nextInt();
        consecutiveDays = scanner.nextInt();

        tempList = new int[numDays];
        for (int i=0; i < numDays; i++){
            tempList[i] = scanner.nextInt();
        }

        // 첫 M일  온도의 합
        int sum=0;
        for(int i=0; i<consecutiveDays;i++){
            sum += tempList[i];
        }

        // 최대값을 첫 M일 온도의 합으로 설정
        int maxTemp = sum;
        int head=consecutiveDays;
        int tail=0;

        // 길이가 고정되었으므로 매일 다음 날짜의 온도를 추가하고 지난 날짜의 온도는 빼면서 sum이 max보다 크면 갱신합니다.
        while(head < numDays){
            sum+= tempList[head++];
            sum -= tempList[tail++];
            maxTemp = Math.max(maxTemp, sum);
        }

        // 출력
        System.out.println(maxTemp);

    }
}
