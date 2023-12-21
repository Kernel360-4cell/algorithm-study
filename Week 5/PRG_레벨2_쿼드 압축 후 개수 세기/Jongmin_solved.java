import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	static int [] result = new int[2];
	private static final int DIFFERENT = -1;
	public int[] solution(int[][] arr) {


		solution(new Matrix(arr, arr.length));

		return result;
	}
	public static void solution(Matrix matrix){
		if(matrix.color != DIFFERENT){
			result[matrix.color]++;
			return;
		}
		solution(matrix.getSub(0, 0));
		solution(matrix.getSub(0, 1));
		solution(matrix.getSub(1, 0));
		solution(matrix.getSub(1, 1));
	}

	/**
	 * Matrix가 생성 될 때 단일 단일 색상이면 color 값은 0, 1을 갖고 아니면 -1(DIFFERENT_COLOR)을 갖도록 했습니다.
	 */
	public static class Matrix{
		int [][] arr;
		int size ;
		int color;
		public Matrix(int [][] arr, int size){
			this.arr = arr;
			this.size = size;
			this.color = getColor();
		}
		private int getColor(){
			boolean uniColor= true;
			for(int i=0; i<size;i++){
				for(int j=0; j<size;j++){
					if(this.arr[i][j] != this.arr[0][0]){
						return DIFFERENT;
					}
				}
			}
			return arr[0][0];
		}
		public Matrix getSub(int row, int col){
			if(this.size<=1){
				throw new RuntimeException("size가 1인걸 쪼개면 뭔가가 잘못된겁니다 다시 짜세요.");
			}

			int half = this.size/2;
			int[][] newArr = new int[half][half];
			for(int i=0; i<half; i++){
				for(int j=0; j<half; j++){
					newArr[i][j] = this.arr[row*half+i][col*half+j];
				}
			}
			return new Matrix(newArr, half);
		}

	}
}