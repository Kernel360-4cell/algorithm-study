import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        HashMap<String, Integer> points = new HashMap<>();
        for(int i=0; i< name.length; i++){
            points.put(name[i], yearning[i]);
        }

        return Arrays.stream(photo).map(
            names -> Arrays.stream(names).map(
                people -> {
                    if(points.containsKey(people))
                        return points.get(people);
                    return 0;
                }
            ).reduce(0, Integer::sum)
        ).mapToInt(i->i).toArray();
    }
}