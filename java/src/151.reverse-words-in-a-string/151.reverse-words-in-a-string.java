public class Solution {
    public static void main(String[] args) {
        final String input = "  ab c dec   ";
        System.out.println("[" + new Solution().reverseWords(input) + "]");
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = compressWords(chars);
        reverseStr(chars, 0, len - 1);
        return String.valueOf(chars, 0, len);
    }

    public int compressWords(char[] chars) {
        int i = 0;
        int j = 0;
        int wordsCount = 0;

        while (i < chars.length) {
            // escape spaces and find the beginning of a new word
            while (i < chars.length && chars[i] == ' ') {
                ++i;
            }
            if (i == chars.length) break;
            if (wordsCount > 0) {
                chars[j++] = ' ';   // leave a space in between of words
            }
            int k = j;
            // find the ending of the word
            while (i < chars.length && chars[i] != ' ') {
                chars[j++] = chars[i++];
            }
            reverseStr(chars, k, j - 1);
            ++wordsCount;
        }

        return (j > 0 && chars[j - 1] == ' ') ? j - 1 : j; // remove the trailing space if any
    }

    public void reverseStr(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
