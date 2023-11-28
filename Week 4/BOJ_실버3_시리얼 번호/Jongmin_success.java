import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static Guitar[] guitars;

    public static void main(String[] args) throws IOException {
        getInput();

        Arrays.sort(guitars);

        for (int i = 0; i < N; i++) {
            System.out.println(guitars[i].serial);
        }
    }

    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        guitars = new Guitar[N];
        for (int i = 0; i < N; i++) {
            guitars[i] = new Guitar(br.readLine());
        }
    }

    // 객체의 정렬을 비교하기 위해 Comparable 인터페이스를 상속받았습니다.
    public static class Guitar implements Comparable<Guitar> {
        private String serial;
        int sum;

        // 생성하면서 시리얼 번호를 입력받고 비교에 활용할 sum 값을 계산해줍니다.
        public Guitar(String serial) {
            this.serial = serial;
            this.sum = sumPosNumbers(serial);
        }

        @Override
        public int compareTo(Guitar o) {
            //길이가 같으면 각 기타의 시리얼 넘버 합을 비교합니다.
            // 시리얼 넘버의 합도 같으면 스트링의 기본 비교 함수로 비교합니다.
            if (this.serial.length() == o.serial.length()) {
                if (this.sum == o.sum) {
                    return this.serial.compareTo(o.serial);
                } else {
                    return this.sum - o.sum;
                }
            } else {
                return this.serial.length() - o.serial.length();
            }
        }

        //숫자만 뽑아내 값을 더합니다.
        //
        private static int sumPosNumbers(String serial) {
            int sum = 0;
            for (int i = 0; i < serial.length(); i++) {
                char c = serial.charAt(i);
                if (c >= '0' && c <= '9') {
                    sum += Integer.parseInt(String.valueOf(serial.charAt(i)));
                }
            }
            return sum;
        }
    }
}
