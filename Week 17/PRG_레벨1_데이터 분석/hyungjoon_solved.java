import java.util.*;

/**
 * 문제 : 데이터 분석
 * 난이도 : 레벨 1
 * 소요 시간 : 24분
 */
class Solution {
    public static List<int[]> list = new ArrayList<>();
    public static Map<String, Integer> map = new HashMap<>();

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // ext에 따른 데이터 맵핑
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        int extIdx = map.get(ext);
        int sortBy = map.get(sort_by);

        // 조건에 맞는 배열을 list로 전달
        for(int[] arr : data){
            int temp = arr[extIdx];
            if(temp < val_ext){
                list.add(arr);
            }
        }

        // list 정렬
        list.sort(Comparator.comparingInt(arr -> arr[sortBy]));

        // list를 2차원배열로 변환
        int[][] answer = new int[list.size()][4];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}