package sort;

// 광물캐기

public class pg_172927 {

	public static void main(String[] args) {
		pg_172927 pg = new pg_172927();
		int[] picks = {0, 1, 1};
		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron",
						"diamond"};

		int answer = pg.solution(picks, minerals);
		System.out.println(answer);
	}

	public int diamondPick(int number, String[] minerals, int mineralIndex) {
		int tired = 0;

		for (int i = 0; i < 5; i++) {
			tired++;
			mineralIndex++;
			if (mineralIndex >= minerals.length) {
				break;
			}
		}
		return tired;
	}

	public int ironPick(int number, String[] minerals, int mineralIndex) {
		int tired = 0;

		for (int i = 0; i < 5; i++) {
			if (minerals[mineralIndex].equals("diamond")) {
				tired += 5;
			} else {
				tired++;
			}
			mineralIndex++;
			if (mineralIndex >= minerals.length) {
				break;
			}
		}
		return tired;
	}

	public int stonePick(int number, String[] minerals, int mineralIndex) {
		int tired = 0;

		for (int i = 0; i < 5; i++) {
			if (minerals[mineralIndex].equals("diamond")) {
				tired += 25;
			} else if (minerals[mineralIndex].equals("iron")) {
				tired += 5;
			} else {
				tired++;
			}
			mineralIndex++;
			if (mineralIndex >= minerals.length) {
				break;
			}
		}
		return tired;
	}

	public int solution(int[] picks, String[] minerals) {
		// dia -> iron -> stone 순으로 정렬, 어차피 알파벳 순이라서 정렬 함수를 새로 정의하지 않음
		//		Arrays.sort(minerals);
		int index = 0;
		int tired = 0;
		for (int i = 0; i < picks[0]; i++) {
			tired += diamondPick(picks[0], minerals, index);
			index += 5;
			if (index >= minerals.length) {
				return tired;
			}
		}
		for (int i = 0; i < picks[1]; i++) {
			tired += ironPick(picks[1], minerals, index);
			index += 5;
			if (index >= minerals.length) {
				return tired;
			}
		}
		for (int i = 0; i < picks[2]; i++) {
			tired += stonePick(picks[2], minerals, index);
			index += 5;
			if (index >= minerals.length) {
				return tired;
			}
		}
		return tired;
	}
}

//class MineralComparator implements Comparator<String> {
//
//	@Override
//	public int compare(String o1, String o2) {
//		return o1.compareTo(o2);
//	}
//}