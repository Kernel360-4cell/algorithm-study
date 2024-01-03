package programmers.string.level_2_17684;

import java.util.*;

/**
 * 문제 : 압축
 * 난이도 : 레벨 2
 * 소요시간 : 66분
 */
class Solution {
    Map<String, Integer> map;
    List<String> list;
    static int n = 27;

    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();

        // 초기화 작업, map에 알파벳 순으로 인덱스를 넣어준다.
        list = new ArrayList<>();
        map = new HashMap<>();
        char init = 'A';
        for(int i = 1; i < 27; i++){
            map.put(Character.toString(init), i);
            init += 1;
        }

        Queue<String> q = new LinkedList<>();
        for(String word : msg.split("")){
            q.add(word);
        }

        String key = "";
        while(!q.isEmpty() || !"".equals(key)){
            // 다음 단어를 map이 가지고 있다면, 안가지고 있을 때까지 단어 길이를 늘려준다.
            if(map.containsKey(key + q.peek())){
                key = key + q.poll();
                continue;
            }
            // 다음 단어를 map이 안가지고 있다면, 현재 단어에 해당하는 값을 출력해주고, 문자열을 초기화시켜준다.
            list.add(map.get(key));
            addMap(key + q.peek(), n);
            key = "";
        }


        // list를 array로 바꿔서 출력
        int[] answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }

    // map에 더해주는 함수
    public void addMap(String word, int index){
        map.put(word, index);
        n++;
    }
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr = solution.solution("KAKAO");
//    }
}