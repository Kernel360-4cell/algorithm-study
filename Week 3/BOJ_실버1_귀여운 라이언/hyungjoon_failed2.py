'''
문제 : 귀여운 라이언
난이도 : 실버 1
소요 시간 : 
'''
import sys
se = sys.stdin.readline

n, k = map(int, se().split())
arr = list(map(int, se().split()))
l, r = 0, 0
answer = 1000001

# k가 1일 땐 값이 하나라도 있으면 1임. 바로 종료.
if k == 1:
    cnt = arr.count(1)
    print(1) if cnt > 0 else print(-1)
    exit()

# k개 이상 라이언을 포함하는 집합을 찾았을 때, 다음 l의 좌표를 설정해주기 위한 변수
# next_flag 가 현재 탐색중인 투포인터의 다음 인덱스를 칭한다.
cnt = 0
next_l = 0

# 초항이 라이언이면 cnt 더해주기
if arr[0] == 1:
    cnt += 1

# r이 n에 도달하기 전까지 돈다.
while r < n:
    # k개의 라이언이 존재하는 경우 정답 갱신
    if cnt == k:
        answer = min(answer, r - l + 1)
        # l 포인터를 당겨줘야 되는데, 라이언이 있는 자리였으면 cnt를 빼주기
        if arr[l] == 1:
            cnt -= 1
        l += 1
    else:
        # 아닌 경우 r 늘려주기
        r += 1
        # 만약 r을 늘려줬는데 라이언이 있다면 cnt++ 해주기
        if r < n and arr[r] == 1:
            cnt += 1

print(-1 if answer == 1000001 else answer)
