import java.util.*;

/**
 * 문제 : 그리움 점수
 * 난이도 : 레벨 1
 * 소요 시간 : 11분
 */
class Solution {
    public static Map<String, Integer> map = new HashMap<>();

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = yearning.length;

        int[] answer = new int[photo.length];

        // 그리움 점수 매핑
        for(int i = 0; i < n; i++){
            map.put(name[i], yearning[i]);
        }

        // map.forEach((strKey, strValue) -> {
        //     System.out.println(strKey + " : " + strValue);
        // });

        // 그리움 점수 계산하고 answer에 할당
        for(int i = 0; i < photo.length; i++){
            int temp = 0;
            for(String s : photo[i]){
                if(map.get(s) != null){
                    temp += map.get(s);
                }
            }
            answer[i] = temp;
        }

        return answer;
    }
}