import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17829 {

	static int[][] data;

	public static void main(String[] args) throws IOException {
		int n = getInput();

		int result = getSolution(new Matrix(data, n));

		System.out.println(result);
	}

	private static int getSolution(Matrix matrix) {

		if (matrix.size == 2){
			// 정렬 후 두 번째 값 리턴
			return matrix.getSecondData();
		}


		int [][] subSectionsValue = new int[2][];
		for(int i=0; i<2; i++){
			subSectionsValue[i] = new int[2];
			for(int j=0; j<2; j++){
				subSectionsValue[i][j] = getSolution(matrix.getSubMatrix(i, j, matrix.size/2));
			}
		}
		return getSolution(new Matrix(subSectionsValue, 2));
	}


	public static int getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j=0; j<N; j++)
				data[i][j] = Integer.parseInt(st.nextToken());
		}

		return N;
	}
	static class Matrix{
		int[][] data;
		int size;
		public Matrix(int[][] data, int size){
			this.data = data;
			this.size = size;
		}

		// 부모믈 4등분 한 서브 매트릭스를 구하는 메서드( 2by2의 앞의 두 인자는 가로 세로 0, 1의 값을 가짐)
		// (0, 0), (0, 1), (1, 0), (1, 1)이고 부모를 4등분한 부분의 구역을 구분하는데 쓰임.
		public Matrix getSubMatrix(int row, int col, int size){

			int[][] subData = new int[size][size];

			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					subData[i][j] = this.data[row*size+i][col*size+j];
				}
			}
			return new Matrix(subData, size);
		}
		public int getSecondData(){

			// 여기가 호출될 일은 업겠지만 호출되면 뭔가 잘못 코딩한 것
			if(this.size != 2){
				throw new ArithmeticException("size가 2인 객체만 호출할 수 있습니다. - size: "+ this.size);
			}

			// 우선 2차원 배열을 정렬하는 방법을 몰라서 1차원 배열로 만듦.
			int[] oneDimensionalData = new int[4];
			for(int i=0; i<2; i++){
				for(int j=0; j<2; j++){
					oneDimensionalData[i*2+j]= this.data[i][j];
				}
			}
			Arrays.sort(oneDimensionalData);

			// 오름차순이므로 끝에서 2번째 값 리턴.(여기가지 거쳤을 때 사이즈가 4가 아니면 말이 안됨)
			return oneDimensionalData[2];
		}
	}
}
