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
answer = 10000001

# k가 1일 땐 값이 하나라도 있으면 1임. 바로 종료.
if k == 1:
    cnt = arr.count(1)
    print(1) if cnt > 0 else print(-1)
    exit()

# k개 이상 라이언을 포함하는 집합을 찾았을 때, 다음 l의 좌표를 설정해주기 위한 변수
# next_flag 가 현재 탐색중인 투포인터의 다음 인덱스를 칭한다.
cnt = 0
next_l = 0

# r이 n에 도달하기 전까지 돈다.
while r < n:
    # 라이언을 찾으면 cnt를 늘려준다.
    if arr[r] == 1:
        cnt += 1
        # 만약 두번째로 찾은 라이언, 즉 다음 l 포인터를 찾으면 위치를 저장해둔다.
        if cnt == 2 and arr[r] == 1:
            next_l = r
        # k개 이상의 라이언을 찾으면 정답을 갱신해준다.
        if cnt >= k:
            answer = min(answer, r - l + 1)
            # l의 위치를 저장해둔 next_l로 바꿔주고, 해당 위치엔 라이언이 있으니 cnt를 1로 바꿔준다.
            l = next_l
            cnt = 1
        # k개 만큼 찾은것도 아니고, 다음 l 포인터의 위치를 찾은것도 아니면 그냥 r을 늘려준다.
        else:
            r += 1
    else:
        r += 1

print(-1 if answer == 10000001 else answer)
