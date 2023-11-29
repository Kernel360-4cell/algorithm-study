def solution(targets):
    answer = 0
    
    # e 구간 기준으로 정렬
    targets.sort(key=lambda x:x[1])
    
    # 요격 미사일의 현재 위치 초기화
    cur = -1
    # print(targets)
    
    for s, e in targets:
        # 요격 미사일의 현재위치(cur)가 폭격 미사일의 범위 외라면, 요격 미사일을 하나 더 발사한다.
        # 이 때, 이 미사일의 위치는 e - 0.5로 한다. (걸치는 구간에 쏘는건 요격을 못하니까)
        if cur < s:
            answer += 1
            cur = e - 0.5
    
    return answer