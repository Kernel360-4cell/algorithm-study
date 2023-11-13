'''
문제 : 랜선 자르기
난이도 : 실버 2
소요 시간 : 20분
'''
import sys
se = sys.stdin.readline
answer = 0

k, n = map(int, se().split())
arr = [ int(se()) for _ in range(k)]

# 이분탐색으로 진행
s, e = 1, max(arr)

while s <= e:
    mid = (s+e) // 2
    lines = 0
    for i in arr:
        lines += i//mid
    
    # 자른 랜선이 목표치에 도달하지 못하면, 더 짧게 잘라야 하니 e = mid - 1
    if lines < n:
        e = mid - 1
    # 목표치를 넘으면 더 길게 잘라야 하니 s = mid + 1
    else:
        s = mid + 1

print(e)