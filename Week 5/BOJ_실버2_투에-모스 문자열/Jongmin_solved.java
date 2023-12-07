
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj18222 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long k = Long.parseLong(br.readLine());

		boolean result = solution(k);
		System.out.println( result? 1 : 0);
	}

	/**
	 * 앞의 문자열을 숫자를 바꿔서 뒤에 붙이므로 k 번째 숫자는 k를 넘지 않는 최대의 2의 배수를 찾고
	 * 그것을 n이라고 한다면
	 * k번째 숫잔는 k-n 번째 문자열의 반대가 됩니다.
	 * 이것을 재귀로 호출을 반복해서 k가 1이 될 때까지 반복합니다.
 	 */

	public static boolean solution(long k){
		if( k == 1){
			return false;
		}

		// K를 넘지 않는 최대 2의 거듭제곱 꼴 n 찾는 부분
		long n = 1L;
		while(n < k){
			n = n << 1;
		}
		n /= 2;

		return !solution(k - n);

	}
}
