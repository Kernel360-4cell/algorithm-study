import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992 {

	public static final int BLACK = 1;
	public static final int WHITE = 0;

	private static int [][] data;
	public static void main(String [] args ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		data = new int[N][N];

		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for (int j=0; j<N; j++) {
				data[i][j] = temp.charAt(j) - '0';
			}
		}

		System.out.println(solution(data, N));
	}

	public static String solution(int[][] data, int size){
		String lu;
		String ru;
		String ld;
		String rd;
		//모두 같은 숫자인지 확인
		if (isAllBlack(data, size)){
			return "1";
		}
		if (isAllWhite(data, size)){
			return "0";
		}

		int half = size/2;
		lu = solution(getSubData(data,0, 0, half), half);
		ru = solution(getSubData(data, 0, half, half), half);
		ld = solution(getSubData(data, half, 0, half), half);
		rd = solution(getSubData(data, half, half, half), half);

		return "(" + lu + ru + ld + rd + ")";
	}

	private static int[][] getSubData(int[][]data, int row, int col, int size) {
		int[][] subData = new int[size][size];
		for(int i=0; i<size;i++)
			System.arraycopy(data[row + i], col, subData[i], 0, size);
		return subData;
	}

	private static boolean isAll(int [][] data, int size, int color){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if (data[i][j] != color){
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isAllWhite(int[][] data, int size) {
		return isAll(data, size, WHITE);
	}

	private static boolean isAllBlack(int[][] data, int size) {
		return isAll(data, size, BLACK);
	}
}