'''
문제 : H_Index
난이도 : 레벨 2
소요 시간 : 50분
'''
def solution(citations):
    answer = 0
    n = len(citations)
    citations.sort(reverse=True)

    # h번 이상 인용된 논문이 현재 인덱스보다 많다면 조건에 부합한다. 최대값만 구하면 되니까 그 아래는 볼 필요가 없음.
    # 5 4 3 3 1 을 예시로 보면 i = 3, citations[i] = 3 으로 적합
    # 근데 5 4 3 2 1 을 보면 i = 2, citations[i] = 3 인데, 정답은 3임
    for i in range(n):
        if i >= citations[i]:
            return i
    
    return n