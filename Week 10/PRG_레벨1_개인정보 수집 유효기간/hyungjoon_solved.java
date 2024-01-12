import java.util.*;

/**
 * 문제 : 개인정보 수집 유효기간
 * 난이도 : 레벨 1
 * 소요 시간 : 37분
 */
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] temp = terms[i].split(" ");
            // map에 약관 넣어주기
            map.put(temp[0], Integer.parseInt(temp[1]));
        }

        // 날짜 int로 치환
        // '.' 은 정규표현식이라 이스케이프 처리 필요
        String[] temp = today.split("\\.");
        int todayY = Integer.parseInt(temp[0]) * 12 * 28;
        int todayM = Integer.parseInt(temp[1]) * 28;
        int todayD = Integer.parseInt(temp[2]);
        int intToday = todayY + todayM + todayD;

        for(int i = 0; i < privacies.length; i++){

            // 개인정보의 보관일자 유효성 검사
            String[] t = privacies[i].split(" ");
            int termMonth = map.get(t[1]) * 28;
            String[] tt = t[0].split("\\.");
            int tY = Integer.parseInt(tt[0]) * 12 * 28;
            int tM = Integer.parseInt(tt[1]) * 28;
            int tD = Integer.parseInt(tt[2]);

            // 유효기간이 지난 후 일자는 전날로 줄어듦으로 -1 해주기
            int intTemp = tY + tM + tD + termMonth - 1;
            if(intToday > intTemp){
                list.add(i+1);
            }
        }
        // 배열로 변환
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}