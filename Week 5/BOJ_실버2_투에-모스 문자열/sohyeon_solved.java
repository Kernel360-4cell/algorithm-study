import java.io.*;

public class Main {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 범위 주의하기
		long N = Long.parseLong(br.readLine());


		arr = new long[64];
		arr[0] = 1;
		for (int i = 1; i < 64; i++) {
			// n의 값은 n보다 작은 2의 거듭제곱을 뺀 숫자에 해당하는 값을 반전한 값
			arr[i] = arr[i-1] * 2;
		}
		System.out.println(sol(N));
	}

	public static int sol(long x) {
		if (x == 1) {
			return 0;
		}
		for (int i = 0; i < 64; i++) {
			if (arr[i] >= x) {
				// 0이면 1, 1이면 0으로 반전되기 때문에 1 - X 꼴로 return
				return 1 - sol(x - arr[i-1]);
			}
		}
		return 0;
	}
}