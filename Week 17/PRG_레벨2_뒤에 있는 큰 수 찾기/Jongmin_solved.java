import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

        Boolean[] visited = new Boolean[1_000_001];
        Arrays.fill(visited, Boolean.FALSE); // 이건 검색으로 알아낸건데 굳이 해줄 필요는 없는 것 같습니다.

        // 이번에도 큐를 활용한 DFS방식으로 풀면 좋겠다는 생각이 들었습니다.
        // 현재 숫자와 현재까지의 연산 횟수를 저장하는 리스트를 큐에 넣어주고
        // 큐에서 하나씩 빼면서 연산을 진행합니다.
        // 진행하다 원하는 결과가 나오면, 그게 가장 적은 횟수로 원하는 숫자를 만드는 것이므로
        // 바로 결과를 리턴해줍니다. 만약 해당하는 값이 없다면 -1을 리턴해줍니다.
        
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(List.of(x, 0));
        visited[x] = true;
        int count = 0;

        while(!queue.isEmpty()){
            List<Integer> element = queue.poll();

            int c = element.get(0);
            count = element.get(1);
            if(c == y ) return count;
            count++;

            int nc = c+n;

            if(nc <= y && !visited[nc]){
                visited[nc] = true;
                queue.offer(List.of(nc, count));

            }
            nc = c*2;
            if(nc <= y && !visited[nc]){
                visited[nc] = true;
                queue.offer(List.of(nc, count));
            }

            nc = c*3;
            if(nc <= y && !visited[nc]){
                visited[nc] = true;
                queue.offer(List.of(nc, count));
            }
        }
        return -1;
    }
}