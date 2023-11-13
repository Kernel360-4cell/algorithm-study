'''
문제 : 블로그
난이도 : 실버 3
소요 시간 : 
'''
import sys
se = sys.stdin.readline
answer = 0

# 필요한 정보 입력
n, x = map(int, se().split())
arr = list(map(int, se().split()))

# 누적합 사용, arr[i]와 sum_arr[i-1]의 합으로 sum_arr 세팅
sum_arr = [arr[0]]

for i in range(1, n):
    sum_arr.append(arr[i] + sum_arr[i-1])

# 구간별 합 구하기
result = []
idx = 0
for i in range(idx+x, n):
    result.append(sum_arr[i] - sum_arr[idx])
    idx += 1

if max(result) == 0:
    print('SAD')
else:
    print(max(result))
    print(result.count(max(result)))