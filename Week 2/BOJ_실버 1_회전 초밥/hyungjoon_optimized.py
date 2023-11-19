'''
문제 : 회전 초밥
난이도 : 실버 1
소요 시간 : 22분
'''
import sys
from collections import deque
se = sys.stdin.readline

n, d, k, c = map(int, se().split())
sushi = [ int(se().rstrip()) for _ in range(n) ]

answer = 0

# 슬라이딩 윈도우 변형
for i in range(n):
    # set으로 중복 제거
    temp = []

    # 회전 초밥이 원형이니까, 인덱스가 넘어가는 경우 원형으로 범위 지정
    if i + k >= n:
        temp = set(sushi[i:] + sushi[:k-(n-i)])
    else:
        temp = set(sushi[i:i+k])

    temp.add(c)
    answer = max(answer, len(temp))

print(answer)
