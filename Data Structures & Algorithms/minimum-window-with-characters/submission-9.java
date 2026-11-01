class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int endIdx = 0;
        int startIdx = 0;
        int shortestLength = Integer.MAX_VALUE;

        int[] tArr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i)]++;
        }

        int numChars = 0;
        for (int tInt : tArr) {
            if (tInt > 0) numChars++;
        }

        int[] sArr = new int[128];
        int currChars = 0;
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i)]++;

            if (sArr[s.charAt(i)] == tArr[s.charAt(i)]) {
                currChars++;
            }

            while (currChars == numChars) {
                if (shortestLength > i - startIdx + 1) {
                    shortestLength = i - startIdx + 1;
                    endIdx = i;
                }

                sArr[s.charAt(startIdx)]--;

                if (sArr[s.charAt(startIdx)] < tArr[s.charAt(startIdx)]) {
                    currChars--;
                }

                startIdx++;
            }
        }

        if (shortestLength == Integer.MAX_VALUE) return "";
        return s.substring(endIdx - shortestLength + 1, endIdx + 1);
    }
}
