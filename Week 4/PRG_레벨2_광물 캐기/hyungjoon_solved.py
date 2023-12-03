'''
문제 : 광물 캐기
난이도 : 레벨 2
소요 시간 : 1시간
'''
from collections import deque
def solution(picks, minerals):
    answer = 0
    
    # 다이아/철/돌 을 캐는데 필요한 피로도, 다이아/철/돌 순임
    tired = { 'diamond' : [1, 5, 25], 
              'iron'    : [1, 1, 5],
              'stone'   : [1, 1, 1] }
    
    # 1. 한번 사용한 곡괭이는 끝까지 쓴다.
    # 2. 모든 광물을 캐거나, 사용할 곡괭이가 없을 때까지 광물을 캔다.
    # 3. 종류에 상관없이 5개를 캔 후엔 사용불가
    
    # 광물을 5개씩 캐는걸로 따지면 안된다.
    # 5개단위로 전체를 구한다음에 피로도가 돌 곡괭이로 캤을 때 가장 많이 드는 애를 가장 좋은 곡괭이로 캐주는 식으로 진행해야 한다.
    
    minerals = deque(minerals[:5*sum(picks)])
    digList = []
    while minerals:
        # 5개씩 작업할 리스트를 생성해준다.
        workList = []
        while len(workList) < 5:
            if minerals:
                workList.append(minerals.popleft())
            else:
                break

        # 곡괭이별 소모되는 피로도
        dia, iron, stone = 0, 0, 0

        # 곡괭이별로 5개를 캤을 때 피로도가 얼마나 소모되는지 계산한다.
        for i in workList:
            dia += tired[i][0]
            iron += tired[i][1]
            stone += tired[i][2]

        # 다이아/철/돌 순으로 리스트에 넣어준다.
        digList.append([dia, iron, stone])

    # 돌/철/다이아 피로도 순으로 정렬되게 내림차순으로 설정
    digList.sort(key=lambda x:(x[2],x[1],x[0]), reverse=True)
    digList = deque(digList)

    for index, i in enumerate(picks):
        for j in range(i):
            # 돌 기준으로 피로도가 가장 많이 드는걸 현재 갖고있는 곡괭이중 젤 좋은 곡괭이로 캐는게 효율이 젤 좋음
            if digList:
                answer += digList.popleft()[index]
            else:
                break        
    
    return answer
# 반례
print(solution([1, 1, 0], ["stone", "stone", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"]))