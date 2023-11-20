package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19637 {

	static int N, M;

	static int[] score;

	static String[] scoreName;

	static int[] A;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		M = scan.nextInt();
		score = new int[N + 1];
		scoreName = new String[N + 1];
		A = new int[M + 1];
		for (int i = 1; i <= N; i++) {
			scoreName[i] = scan.next();
			score[i] = scan.nextInt();
		}
		for (int i = 1; i <= M; i++) {
			A[i] = scan.nextInt();
		}
	}

	static String binarySearch(int X) {
		int start = 1;
		int last = N;

		while (start <= last) {
			int mid = (start + last) / 2;

			if (score[mid] < X) {
				start = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return scoreName[start];
	}

	public static void main(String[] args) {
		input();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= M; i++) {
			sb.append(binarySearch(A[i])).append("\n");
		}
		System.out.println(sb);
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
