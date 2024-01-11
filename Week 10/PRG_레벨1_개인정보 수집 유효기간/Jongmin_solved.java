import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> termMap = new HashMap<>();

        for(String term: terms){
            StringTokenizer st = new StringTokenizer(term);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        int[] todayInt = getDays(today);

        for(int i=0;i<privacies.length; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String termDate = st.nextToken();
            String termType = st.nextToken();
            int [] privacyDate = getDays(termDate);
            int [] expireDate = getExpireDate(privacyDate, termMap.get(termType));

            if(isExpired(todayInt, expireDate)){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // String으로 된 날짜를 {연, 월, 일} 형태의 배열로 변환
    private static int[] getDays(String stringDate){
        StringTokenizer st = new StringTokenizer(stringDate, ".");

        return  new int[]{Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())};
    }

    // 약관에 명시된 개월 수를 더해 유효기간 계산.
    private static int[] getExpireDate(int[] privacyDate, int month){
        int [] expireDate = new int[3];

        // 월은 1~12까지 있고 월을 12로 나눈 결과는 0~11이므로 미리 1을 빼고 +1을 해야 원하는 결과가 나옵니다.
        expireDate[0] = privacyDate[0] + (privacyDate[1]+month-1) / 12;
        expireDate[1] = (privacyDate[1] + month-1) % 12 + 1;
        expireDate[2] = privacyDate[2];
        return expireDate;
    }
    private static boolean isExpired(int[] today, int[] expireDate){
        if(today[0] > expireDate[0]) return true;
        if(today[0] < expireDate[0]) return false;
        if(today[1] > expireDate[1]) return true;
        if(today[1] < expireDate[1]) return false;
        if(today[2] >= expireDate[2]) return true;
        else return false;
    }
}