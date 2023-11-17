'''
문제 : IF문 좀 대신 써줘
난이도 : 실버 3
소요 시간 : 
'''
import sys
se = sys.stdin.readline

n, m = map(int, se().split())

title_arr = []

# [칭호, 전투력] 형태로 2차원 배열 형성
for i in range(n):
    title, power = se().split()
    title_arr.append([title, power])

for i in range(m):
    l, r = 0, n-1
    result = 0

    character = int(se().rstrip())
    while l <= r:
        mid = (l + r) // 2
        power = int(title_arr[mid][1])
        
        if character <= power:
            r = mid - 1
            result = mid
        else:
            l = mid + 1
    print(title_arr[result][0])