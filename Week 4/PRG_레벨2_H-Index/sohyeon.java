import java.util.Arrays;

public class pg_42747 {

	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			int h = citations.length - i;
			// h는 인덱스이면서 h번 이상 인용된 논문이 h편 이상이어야 한다.
			if (citations[i] >= h) {
				// citation을 오름차순으로 정렬했으므로, h번 이상 인용된 논문이 h편 이상이면 h가 최대값이다.
				// 다시 말하면 h번 인덱스(뒤에서부터 가는거임)로부터 h만큼 떨어진 인덱스가 적어도 h이상이어야 h번 이상 인용된 논문이 h편 이상이게 되는 것이다.
				answer = h;
				break;
			}
		}

		return answer;
	}
}
