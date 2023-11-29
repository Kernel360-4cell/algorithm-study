import java.util.*;

public class TestCollectionsSort {
    public int solution(int[][] targets) {
        double cur = -1;
        int answer = 0;

        // 2차원 배열을 List<List<Integer>>으로 변환
        List<List<Integer>> targetList = new ArrayList<>();
        for (int[] target : targets) {
            List<Integer> tempList = new ArrayList<>();
            for (int value : target) {
                tempList.add(value);
            }
            targetList.add(tempList);
        }

        // 두 번째 열을 기준으로 오름차순 정렬
        Collections.sort(targetList, Comparator.comparingInt(list -> list.get(1)));

        for (List<Integer> target : targetList) {
            if (cur < target.get(0)) {
                answer++;
                cur = target.get(1) - 0.5;
            }
        }

        return answer;
    }
}
