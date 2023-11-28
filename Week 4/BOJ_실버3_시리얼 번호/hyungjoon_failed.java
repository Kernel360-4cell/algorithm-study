package backjoon.Sort.Silver_3_1431;

import java.util.*;
import java.io.*;

/**
 * 문제 : 시리얼 번호
 * 난이도 : 실버 3
 * 소요 시간 : 70분
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 조건 2. 자리수 합 비교
                if (o1.length() == o2.length()) {
                    // for문을 돌면서 o1과 o2의 sum을 수행한다.
                    int sum1 = 0, sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) {
                            sum1 += o1.charAt(i) - '0';
                        }
                        if (Character.isDigit(o2.charAt(i))) {
                            sum2 += o2.charAt(i) - '0';
                        }
                    }
                    // 조건 3. 자리수의 합이 같으면 사전순으로 정렬
                    if (sum1 == sum2) {
                        // 사전순으로 정렬하는것은 곧 비교대상(o2)가 양수여야 함을 의미한다. 따라서 -1을 넣었는데 오답. 이유가..?
                        // return -1;
                        return o1.compareTo(o2);
                    } else {
                        // 조건 2. 자리수 합 비교, 작은것이 앞으로
                        // 얘도 마찬가지로 -1을 넣으면 오답임.. 왜일까
                        return sum1 - sum2;
                    }
                } else {
                    // 조건 1. 길이 비교, 짧은 것이 앞으로
                    return o1.length() - o2.length();
                }
            }
        });
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i < n - 1) {
                sb.append(list.get(i)).append("\n");
            } else {
                sb.append(list.get(i));
            }
        }
        System.out.println(sb);
    }
}
