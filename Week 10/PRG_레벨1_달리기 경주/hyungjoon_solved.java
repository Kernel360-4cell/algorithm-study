import java.util.*;

/**
 * 문제 : 달리기 경주
 * 난이도 : 레벨 1
 * 소요시간 : 20분
 */
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }

        for(String s : callings){
            // current : 이름이 불린 선수의 인덱스
            // before : 이름이 불린 선수 앞에 있는 선수의 인덱스
            int current = map.get(s);
            int before = current - 1;

            // 둘이 위치 바꾸기
            String temp = players[before];
            players[before] = s;
            players[current] = temp;

            // 맵에 할당된 인덱스 위치도 교환
            map.put(s, before);
            map.put(temp, current);
        }
        return players;
    }
}