class Solution {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int n = str.length();
        int i = 0;

        // escape leading spaces
        if (str.charAt(i) == ' ') {
            while (i < n && str.charAt(i) == ' ') {
                ++i;
            }
        }
        if (i == n) {
            return 0;
        }

        int sign = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }

        long res = 0;   // use long to handle overflow
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + (str.charAt(i++) - '0');
            if (res * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (res * sign);
    }
}
