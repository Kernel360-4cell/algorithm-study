import java.util.Scanner;

public class Main {
    static int sizeOfList;
    static int targetScore;
    static int[] listNumber;

    public static void main(String[] args) {
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
                sum -= listNumber[++tailIdx];

            }
            else if (sum < targetScore){
                if(headIdx+1 < sizeOfList) {
                    headIdx++;
                    sum += listNumber[headIdx];
                }else{
                    break;
                }
            }
            else{
                sum -= listNumber[++tailIdx];
            }
        }
        return count;
    }

    static void getInput() {
        Scanner scanner = new Scanner(System.in);

        sizeOfList = scanner.nextInt();
        targetScore = scanner.nextInt();

        listNumber = new int[sizeOfList];

        for (int i=0; i < sizeOfList; i++){
            listNumber[i] = scanner.nextInt();
        }
    }
}