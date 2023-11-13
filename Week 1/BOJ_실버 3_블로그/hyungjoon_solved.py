'''
문제 : 블로그
난이도 : 실버 3
소요 시간 : 40분
'''
import sys
se = sys.stdin.readline
answer = 0

# 필요한 정보 입력
n, x = map(int, se().split())
arr = list(map(int, se().split()))

# 슬라이딩 윈도우 활용
temp = sum(arr[:x])
maximum = temp
answer = [temp]

for i in range(x, n):
    temp += arr[i]
    temp -= arr[i-x]
    maximum = max(maximum, temp)
    answer.append(temp)

if maximum == 0:
    print('SAD')
else:
    print(maximum)
    print(answer.count(maximum))

