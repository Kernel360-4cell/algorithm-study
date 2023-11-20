import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;

	static int[] exist = new int[100001];

	static int[] num;

	public static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		K = scan.nextInt();
		num = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = scan.nextInt();
		}
	}

	public static void main(String[] args) throws IOException {

		input();

		int max = 0;
		int end = 0;

		for (int i = 1; i <= N; i++) {
			if (exist[num[i - 1]] > 0) {
				exist[num[i - 1]]--;
			}
			while (end + 1 <= N && exist[num[end + 1]] < K) {
				exist[num[++end]]++;
			}
			max = Math.max(end - i + 1, max);
		}
		System.out.println(max);
	}

	static class FastReader {

		BufferedReader br;

		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}



