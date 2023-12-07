import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2630_2 {
	static int N;
	static int[][] arrayList;
	static int countBlue = 0;
	static int countWhite = 0;
	final static int BLUE=1;
	final static int WHITE=0;
	public static void main(String[] args) throws IOException {

		getInput();
		solution();

		System.out.println(countWhite);
		System.out.println(countBlue);
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
	public static void solution(){

		SectionInfo entireSection = new SectionInfo(0, 0, N);
		Deque<SectionInfo> sectionInfos = new ArrayDeque<>();
		sectionInfos.add(entireSection);

		while(!sectionInfos.isEmpty()){

			var newMatrix = sectionInfos.removeFirst();

			if(newMatrix.isAllBlue()){
				countBlue++;
			}else if(newMatrix.isAllWhite()){
				countWhite++;

			}else {

				//섹션을 4등분해서 큐에 추가
				int halfSzie = newMatrix.size/2;
				int baseRowIdx= newMatrix.rowIdx;
				int baseColIdx= newMatrix.colIdx;
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						SectionInfo newSectionInfo = new SectionInfo(baseRowIdx+i*halfSzie, baseColIdx+j*halfSzie,halfSzie);
						sectionInfos.addLast(newSectionInfo);
					}
				}
			}
		}

	}

	// 색종이의 일부분을
	private static class SectionInfo{

		int rowIdx;
		int colIdx;
		int size;

		public SectionInfo(int rowIdx, int colIdx, int size) {
			this.rowIdx = rowIdx;
			this.colIdx = colIdx;
			this.size = size;
		}

		private boolean isAll(int color){
			for (int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					if(arrayList[rowIdx+i][colIdx+j] !=color){
						return false;
					}
				}
			}
			return true;
		}

		public boolean isAllBlue(){
			return isAll(BLUE);
		}
		public boolean isAllWhite(){
			return isAll(WHITE);
		}
	}
}