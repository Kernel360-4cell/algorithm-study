from collections import deque

'''
문제 : 괄호 회전하기
난이도 : 레벨 2
소요 시간 : 31분
'''
def solution(s):
    answer = 0

    n = len(s)

    for i in range(n):
        stack = deque(list(s))
        # n번 회전해주기
        for j in range(i):
            temp = stack.popleft()
            stack.append(temp)

        temp = []
        for j in stack:
            # temp 스택이 존재하면, 닫는 괄호가 유효할때만 pop해주기
            if temp:
                if j == ']' and temp[-1] == '[':
                    temp.pop()
                elif j == '}' and temp[-1] == '{':
                    temp.pop()
                elif j == ')' and temp[-1] == '(':
                    temp.pop()
                else:
                    temp.append(j)
            else:
                temp.append(j)
        # temp 스택이 존재한다는 것은 괄호가 유효하지 않다는 뜻이므로, 길이가 0일때만 answer += 1
        if len(temp) == 0:
            answer += 1

    return answer