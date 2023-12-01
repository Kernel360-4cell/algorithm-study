import java.util.*;

class Solution {
	public int solution(int[][] targets) {
		Arrays.sort(targets, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});

		int cut = -1;
		int answer = 0;

		for (int i=0; i < targets.length; i++) {
			int left = targets[i][0];
			int right = targets[i][1];
			if (left >= cut) {
				answer++;
				cut = right;
			}
		}
		return answer;
	}
}