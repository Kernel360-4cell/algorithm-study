class Solution {
    public String[] solution(String[] players, String[] callings) {
        for(String calling : callings){
            for(int i=0; i< players.length; i++){
                if(players[i].equals(calling)){
                    String temp = players[i];
                    players[i] = players[i-1];
                    players[i-1] = temp;
                    break;
                }
            }
        }
        return players;
    }
}