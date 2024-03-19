import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("code", 0);
        hashMap.put("date", 1);
        hashMap.put("maximum",2);
        hashMap.put("remain", 3);

        return Arrays.stream(data)
            .filter(row -> row[hashMap.get(ext)] < val_ext)
            .sorted(Comparator.comparingInt(row -> row[hashMap.get(sort_by)]))
            .toArray(int[][]::new);
    }
}