'''
문제 : 쿼드트리
난이도 : 실버 1
소요시간 : 43분
'''
import sys
se = sys.stdin.readline

# 데이터 입력 시작
n = int(se().rstrip())
arr = [ se().rstrip() for _ in range(n) ]
# 데이터 입력 끝

def recursion(r, c, size):
    color = arr[r][c]
    mid = size // 2
    # arr[i][j] 순회하면서 다른 문자가 나오는지 확인
    for i in range(r, r+size):
        for j in range(c, c+size):
            if arr[i][j] != color:
                # 다르면 괄호 생성
                print('(', end='')
                # 1, 2, 3, 4 분면으로 나눠서 탐색
                recursion(r, c, mid)
                recursion(r, c+mid, mid)
                recursion(r+mid, c, mid)
                recursion(r+mid, c+mid, mid)
                print(')', end='')
                return
    # 색이 다 같으면 색상 출력
    print(color, end='')

recursion(0, 0, n)