public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 슬라이딩 윈도우로 풀 수는 있는데, 투포인터로 풀어보자.
        int l = 0, r = k-1;
        // 정답 초기화
        int tempSum = Arrays.stream(arr, l, r).sum();
        int answer = tempSum;

        // 다음 계산을 하기 위한 인덱스 당겨주기
        l++;
        r++;
        while(r < n){
            tempSum += arr[r];
            tempSum -= arr[l];
            answer = Math.max(answer, tempSum);

            l++;
            r++;
        }
        System.out.println(answer);
    }
}
