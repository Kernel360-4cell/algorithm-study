package leetcode.string.easy_find_the_index_of_the_first_occurrence_in_a_string;

/**
 * 문제 : Find the Index of the First Occurrence in a String
 * 난이도 : Easy
 * 소요시간 : 10분
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();

        for(int i = 0; i < haystack.length()-len+1; i++){
            String temp = haystack.substring(i, i+len);
            if(temp.equals(needle)){
                return i;
            }
        }

        return -1;
    }
}
