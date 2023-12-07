import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {

	static int N;
	static int[][] arrayList;
	static int countBlue = 0;
	static int countWhite = 0;
	public static void main(String[] args) throws IOException {

		getInput();
		solution(arrayList, N);
	}
	public static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arrayList = new int[N][];
		for(int i=0 ; i < N; i++) {

			arrayList[i] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arrayList[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}
	// list를 Matrix 클래스 안에 넣고 matrix 클래스에 관련된 메서드를 정의했습니다.
	public static void solution(int[][] list, int n){

		Matrix matrix = new Matrix(list, n);

		divideAndConquer(matrix);

		System.out.println(countWhite);
		System.out.println(countBlue);

	}

	/**
	 * 마땅한 풀이 방법이 생각나지 않아 이름을 풀이 방법대로 정의했습니다.
	 * 재귀 호출을 이용해 구현했습니다. queue를 이용해 풀이하는게 속더 빠르겠지만 구현하는 것에 목적을 두었습니다.
	 *
	* */
	private static void divideAndConquer(Matrix matrix) {

		if(matrix.isAllBlue()){
			countBlue++;
			return;
		}
		if(matrix.isAllWhite()) {
			countWhite++;
			return;
		}

		// 여기까지 왔다면 색이 섞여있는 것이므로 가로 세로 4 개로 갈라서 새 matrix를 만들어 재귀호출합니다.
		for(int row=0; row<2; row++){
			for(int col=0; col<2; col++){
				Matrix subMatrix = matrix.getSubMatrix(row, col);
				divideAndConquer(subMatrix);
			}
		}
	}

	private static class Matrix{
		private final int size ;
		private final int[][] values;

		public Matrix(int [][] values, int size){
			this.values = values;
			this.size = size;
		}
		private boolean isAll(int color){
			for (int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					if(values[i][j] !=color){
						return false;
					}
				}
			}
			return true;
		}

		public boolean isAllBlue(){
			return isAll(1);
		}
		public boolean isAllWhite(){
			return isAll(0);
		}
		public Matrix getSubMatrix(int row, int col){
			int halfSize = size/2;
			int[][] newList;

			newList = new int[halfSize][];
			for(int i=0; i<halfSize; i++){

				newList[i] = new int[halfSize];
				for(int j=0; j<halfSize; j++){
					newList[i][j] = values[row*halfSize + i][col*halfSize + j];
				}
			}
			return new Matrix(newList, halfSize);
		}
	}
}