
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 프로그래머스 181188 요격 시스템
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
 *
 **/

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12},{3, 7}, {1, 4}};

        int result = main.solution(targets);
        System.out.println(result);

    }
    public int solution(int[][] targets) {
        int answer = 1;
        int maxS = -1;
        int minE = 100_000_001;

        List<Target> targetList = new ArrayList<>();

        for (int[] target : targets){
            targetList.add(new Target(target[0], target[1]));
        }
        Collections.sort(targetList);

        for (Target target : targetList) {
            maxS = Math.max(maxS, target.getS());
            minE = Math.min(minE, target.getE());
            if (minE <= maxS) {
                answer++;
                maxS = -1;
                minE = 100_000_001;
            }
        }

        return answer;
    }
    class Target implements Comparable<Target>{
        private final int s;
        private final int e;
        public Target(int s, int e){
            this.s = s;
            this.e = e;
        }
        public int getS(){
            return s;
        }
        public int getE(){
            return e;
        }

        @Override
        public int compareTo(Target o) {
            return this.s - o.s;
        }
    }
}