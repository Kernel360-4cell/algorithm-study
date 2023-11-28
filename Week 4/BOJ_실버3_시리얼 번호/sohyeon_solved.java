package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// Arrays.sort에 사용할 시리얼번호 비교 클래스
class SerialComparator implements Comparator<Serial> {

	@Override
	public int compare(Serial o1, Serial o2) {
		if (o1.length == o2.length) {
			if (o1.sum == o2.sum) {
				return o1.serialString.compareTo(o2.serialString);
			} else {
				return o1.sum - o2.sum;
			}
		} else {
			return o1.length - o2.length;
		}
	}
}

// 시리얼번호를 다루는 클래스
/*
* 비교에 필요한 시리얼번호 길이, 숫자합, 시리얼번호 문자열을 관리함
* */
class Serial {

	int length;
	int sum;
	String serialString;

	Serial(String serialString) {
		this.length = serialString.length();
		this.serialString = serialString;
		this.getSum();
	}

	public void getSum() {
		for (int i = 0; i < this.length; i++) {
			if (Character.isDigit(this.serialString.charAt(i))) {
				this.sum += this.serialString.charAt(i) - '0';
			}
		}
	}
}

public class boj_1431 {

	static int N;
	static Serial[] serial;

	// 입력 관리하는 메서드
	public static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		serial = new Serial[N];
		for (int i = 0; i < N; i++) {
			String str = scan.next();
			serial[i] = new Serial(str);
		}
	}

	// 작성한 비교 클래스를 이용해서 비교하기
	public static void main(String[] args) {
		input();
		Arrays.sort(serial, new SerialComparator());
		for (int i = 0; i < N; i++) {
			System.out.println(serial[i].serialString);
		}
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
