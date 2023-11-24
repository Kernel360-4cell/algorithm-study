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

l, r = 0, n-1
answer = 1e9 # 무한대, 10억
while(l <= r):
    temp = arr[r] - arr[l]
    # r과 l의 차이가 m 이상인 경우는 r만 계속 줄여주면 된다.
    if temp >= m:
        answer = min(answer, temp)
        r -= 1
    else:
        l += 1
print(answer)