class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> remaining = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (!remaining.containsKey(c)) {
                remaining.put(c, 0);
            }
            remaining.put(c, remaining.get(c) + 1);
        }
        int minWinStart = -1;       // min window is [minWinStart, minWinEnd)!!!
        int minWinEnd = s.length();
        int winStart = 0;
        int winEnd = 0;
        int requires = t.length();
        while (winStart < s.length() && winEnd <= s.length()) {
            if (requires > 0) {
                if (winEnd == s.length()) break;    // no more chars left
                char c = s.charAt(winEnd);
                if (remaining.containsKey(c)) {
                    remaining.put(c, remaining.get(c) - 1);
                    if (remaining.get(c) >= 0) {
                        --requires;
                    }
                }
                ++winEnd;
            } else {
                char c = s.charAt(winStart);
                // note that winEnd should not be included in the window!
                if (winEnd - winStart < minWinEnd - minWinStart) {
                    minWinStart = winStart;
                    minWinEnd = winEnd;
                }
                if (remaining.containsKey(c)) {
                    remaining.put(c, remaining.get(c) + 1);
                    if (remaining.get(c) > 0) ++requires;
                }
                ++winStart;
            }
        }
        return minWinStart > -1 ? s.substring(minWinStart, minWinEnd) : "";
    }
}
