from collections import deque

def solution(s):
    answer = 0

    n = len(s)

    for i in range(n):
        stack = deque(list(s))
        flag = True
        # n번 회전해주기
        for j in range(i):
            temp = stack.popleft()
            stack.append(temp)

        # 개괄호 [, {, ( 의 개수를 관리하는 변수들
        big, mid, small = 0, 0, 0

        # 옳은 괄호인지 검증
        for j in stack:
            if j == '[':
                big += 1
            elif j == '{':
                mid += 1
            elif j == '(':
                small += 1
            elif j == ']' and big > 0:
                big -= 1
            elif j == '}' and mid > 0:
                mid -= 1
            elif j == ')' and small > 0:
                small -= 1
            else:
                flag = False
                break

        if flag and big == 0 and mid == 0 and small == 0:
            answer += 1

    return answer