'''
문제 : IF문 좀 대신 써줘
난이도 : 실버 3
소요 시간 : 35분
'''
import sys
se = sys.stdin.readline

n, m = map(int, se().split())
title_arr = []
# 같은 전투력의 칭호가 입력되면, 해당 입력은 무시해버린다. (이거 안하면 시초남)
same_power = 0
# [칭호, 전투력] 형태로 2차원 배열 형성
for i in range(n):
    title, power = se().split()
    if power != same_power:
        same_power = power
        title_arr.append([title, power])

for i in range(m):
    l, r = 0, title_arr
    result = 0
    
    # 캐릭터의 힘을 입력받음
    character = int(se().rstrip())
    while l <= r:
        # 중앙 값 및 전투력 지정
        mid = (l + r) // 2
        power = int(title_arr[mid][1])

        # 이분탐색 수행
        if character <= power:
            r = mid - 1
            result = mid
        else:
            l = mid + 1
    print(title_arr[result][0])