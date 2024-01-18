from collections import deque

def bfs(start, end, maps):
    dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]
    
    n = len(maps)
    m = len(maps[0])
    
    visited = [[ False for _ in range(m) ] for __ in range(n)]
    
    # 시작지점 찾기
    flag = False
    r, c = 0, 0
    for i in range(n):
        for j in range(m):
            if maps[i][j] == start:
                flag = True
                r = i
                c = j
                visited[r][c] = True
                break
        if flag:
            break
    
    q = deque([[r, c, 0]])
    while q:
        temp = q.popleft()
        r, c, cost = temp[0], temp[1], temp[2]
        
        if maps[r][c] == end:
            return cost
        
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            
            if nr < 0 or nr >= n or nc < 0 or nc >= m or maps[nr][nc] == 'X':
                continue
                
            if not visited[nr][nc]:
                q.append([nr, nc, cost+1])
                visited[nr][nc] = True
            
    return -1


def solution(maps):
    answer = 0
    
    lever = bfs('S', 'L', maps)
    exit = bfs('L', 'E', maps)
    
    if exit == -1 or lever == -1:
        return -1
    
    answer = lever + exit
    
    return answer

print(solution(["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]))