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
    temp = set(sushi[:k])

    temp.add(c)
    answer = max(answer, len(temp))
    
    # 회전초밥 레일은 원형이니까, 이를 유지하기 위해서 0번 인덱스를 pop하고 이를 다시 append해줌
    l = sushi.pop(0)
    sushi.append(l)

print(answer)
