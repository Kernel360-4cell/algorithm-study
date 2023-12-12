/**
 * 문제 : Valid Parentheses
 * 난이도 : Easy
 * 소요 시간 : 20분
 */
class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack();

        // split으로 string형 배열 생성
        String[] list = s.split("");
        if (list[0].equals(")") || list[0].equals("}") || list[0].equals("]"))
            return false;

        // stack에 push 및 pop
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("(") || list[i].equals("{") || list[i].equals("[")) {
                stack.push(list[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    String temp = stack.peek();
                    switch (temp) {
                        case "(":
                            if (list[i].equals(")")) {
                                stack.pop();
                                continue;
                            } else {
                                return false;
                            }
                        case "{":
                            if (list[i].equals("}")) {
                                stack.pop();
                                continue;
                            } else {
                                return false;
                            }
                        case "[":
                            if (list[i].equals("]")) {
                                stack.pop();
                                continue;
                            } else {
                                return false;
                            }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}