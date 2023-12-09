class Solution {
	public boolean isValid(String s) {

		Deque<Character> stack = new ArrayDeque();

		for (int i=0; i<s.length(); i++){
			char c = s.charAt(i);


			if(c == ')' || c == '}' || c ==']'){
				// 닫는 괄호가 나오면
				// 먼저 스택이 비어있는지 확인하고 비어있으면 false를 리턴합니다.
				if(stack.isEmpty()) return false;

				// 스택에서 하나 꺼내서 맞는 짝이 아니라면 false를 리턴합니다.
				char top = stack.pop();
				if( c == ')' && top != '(') return false;
				if( c == '}' && top != '{') return false;
				if( c == ']' && top != '[') return false;

			}else{
				// 여는 괄호면 일단 푸쉬합니다.
				stack.push(c);
			}

		} // end for

		// 다 끝나고 스택이 비어있으면 true, 비어있지 않으면 false를 리턴합니다.
		return stack.isEmpty();
	}
}