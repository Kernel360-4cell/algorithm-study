package leetcode.string.easy_find_the_index_of_the_first_occurrence_in_a_string;

public class Solution_optimized {
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
