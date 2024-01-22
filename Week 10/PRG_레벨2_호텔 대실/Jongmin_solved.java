import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<List<Integer>> rooms = new ArrayList<>();

        Arrays.sort(book_time, (time1, time2)->{
            return time1[0].compareTo(time2[0]);
        });

        rooms.add(new ArrayList<Integer>());

        for(int i=0; i<book_time.length; i++){
            boolean flag=false; //
            for(int j=0; j<rooms.size(); j++){
                if(rooms.get(j).size() == 0 || isReady(rooms.get(j), getTimeInt(book_time[i][0]))){
                    rooms.get(j).add(getTimeInt(book_time[i][1]) + 10);
                    flag = true;
                    break;
                }
            }

            // 추가되지 않으면 방을 늘려줍니다
            if(!flag){
                List<Integer> newRoom = new ArrayList<>();
                newRoom.add(getTimeInt(book_time[i][1]) + 10);
                rooms.add(newRoom);
            }
        }

        return rooms.size();
    }

    private static boolean isReady(List<Integer> room, int startTime){
        return room.get(room.size()-1) <= startTime;
    }

    private static int getTimeInt(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}