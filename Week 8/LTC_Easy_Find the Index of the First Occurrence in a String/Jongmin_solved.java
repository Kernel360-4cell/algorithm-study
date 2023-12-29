class Solution {
    public String longestCommonPrefix(String[] strs) {
        return solution(strs);
    }
    public static String solution(String[] strs){
        int numberOfStrings = strs.length;
        List<Character> prefix = new ArrayList<>();
        int minLength = 201;
        for(String str : strs){
            if(str.length() < minLength){
                minLength = str.length();
            }
        }
        for(int i=0; i<minLength; i++){
            char temp = strs[0].charAt(i);
            for(int j=1; j<numberOfStrings; j++){
                if(strs[j].charAt(i) != temp){
                    return toString(prefix);
                }
            }
            prefix.add(temp);
        }
        return toString(prefix);
    }
    static String toString(List<Character> charList){
        return charList.stream().map(String::valueOf).collect(Collectors.joining());
    }
}