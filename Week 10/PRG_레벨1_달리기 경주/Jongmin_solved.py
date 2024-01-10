def solution(players, callings):
  data = {player:idx for idx, player in enumerate(players)}
  for name in callings:
    idx = data[name]
    #각 선수 순위 업데이트
    data[name] -= 1
    data[players[idx-1]] += 1
    players[idx -1], players[idx] = players[idx], players[idx-1]

  return players