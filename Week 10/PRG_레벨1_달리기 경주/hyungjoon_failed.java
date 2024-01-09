import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        for(String s : callings){
            int current = Arrays.asList(players).indexOf(s);
            int before = current - 1;

            String temp = players[before];
            players[before] = s;
            players[current] = temp;

        }
        return players;
    }
}