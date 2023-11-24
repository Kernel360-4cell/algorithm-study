'''
 문제 : 수 고르기
 난이도 : 골드 5
 소요 시간 : 
'''
import sys
se = sys.stdin.readline

n, m = map(int, se().split())
arr = [ int(se().rstrip()) for _ in range(n) ]

# 정렬시키고 투포인터 진행
arr.sort()

l, r = 0, 0
answer = int(2e9) # 무한대, 10억
while(l <= r and r < n):
    temp = arr[r] - arr[l]
    # r과 l의 차이가 m 이상인 경우는 r만 계속 줄여주면 된다.
    if temp >= m:
        answer = min(answer, temp)
        l += 1
        # r이 n-1보다 작고, l과 r의 차이가 1밖에 안나는 상황이면 추가적인 탐색을 해야하니 r을 늘려준다.
        if r - l == 1 and r < n-1:
            r += 1
    else:
        r += 1
print(answer)