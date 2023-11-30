import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        int[][] fatigues = {{1, 1, 1},{5, 1, 1},{25, 5, 1}};

        int answer = 0;
        int tools=0;
        int max;
        List<Integer> mineralPackages;

        for(int tool:picks){
            tools+=tool;
        }
        max = tools*5;

        mineralPackages = new ArrayList<>();
        for (int i=0 ; i <minerals.length && i < max; i++){
            //광물 5개씩 묶습니다.
            int idx = i / 5;
            int valueToAdd = 0;
            if (minerals[i].equals("diamond")) {
                valueToAdd = 36;
            } else if (minerals[i].equals("iron")) {
                valueToAdd = 6;
            } else {
                valueToAdd = 1;
            }
            if (idx < mineralPackages.size()) {
                mineralPackages.set(idx, mineralPackages.get(idx) + valueToAdd);
            } else {
                mineralPackages.add(valueToAdd);
            }
        }

        // 5개씩 묶은 광물 정렬
        mineralPackages.sort(Collections.reverseOrder());

        int pickIdx = 0;
        int idx = 0;
        while(idx < mineralPackages.size()){
            if(picks[pickIdx] == 0){
                //곡괭이가 없으면 다음으로 강한 곡괭이로
                pickIdx++;
            }else{
                int pack = mineralPackages.get(idx);

                int diamonds = pack / 36;
                answer += fatigues[pickIdx][0] * diamonds;

                pack = pack - diamonds * 36;
                int irons = pack / 6;
                answer += fatigues[pickIdx][1] * irons;

                int stones = pack - irons * 6;
                answer += fatigues[pickIdx][2] * stones;
                // 소모한 곡괭이 감소
                picks[pickIdx]--;
                idx++;
            }
        }
        return answer;
    }
}