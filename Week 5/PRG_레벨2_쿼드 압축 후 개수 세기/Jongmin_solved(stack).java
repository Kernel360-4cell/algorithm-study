import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	private static final int DIFFERENT_COLOR = -1;
	public int[] solution(int[][] arr) {
		int [] result = new int[2];

		Deque<Matrix>stack = new ArrayDeque<>();
		stack.push(new Matrix(arr, arr.length));

		while(!stack.isEmpty()){
			Matrix matrix = stack.remove();

			if(matrix.color == DIFFERENT_COLOR){
				stack.push(matrix.getSub(0, 0));
				stack.push(matrix.getSub(0, 1));
				stack.push(matrix.getSub(1, 0));
				stack.push(matrix.getSub(1, 1));
			}else{
				result[matrix.color]++;
			}
		}
		return result;
	}

	/**
	 * Matrix가 생성 될 때 단일 단일 색상이면 color 값은 0, 1을 갖고 아니면 -1(DIFFERENT_COLOR)을 갖도록 했습니다.
 	 */

	public static class Matrix{
		int [][] arr;
		int size ;
		int color; // -1이면 다른 색상 0이면 모두 화이트, 1이면 모두 블랙
		public Matrix(int [][] arr, int size){
			this.arr = arr;
			this.size = size;
			this.color = determinColor();
		}
		private int determinColor(){
			boolean uniColor= true;
			for(int i=0; i<size;i++){
				for(int j=0; j<size;j++){
					if(this.arr[i][j] != this.arr[0][0]){
						return DIFFERENT_COLOR;
					}
				}
			}
			// 모두 같은 색이면 0(white), 1(black)의 값을 가짐
			return arr[0][0];
		}

		/**
		 *
		 * @param row 0, 1
		 * @param col 0, 1
		 *            0, 0은 왼쪽 위
		 *            0, 1은 오른쪽 위
		 *            1, 0은 왼쪽 아래
		 *            1, 1은 오른쪽 아래
		 * @return Matrix 객체
		 */
		public Matrix getSub(int row, int col){
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

