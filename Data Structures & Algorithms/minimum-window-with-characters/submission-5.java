class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] sArr = new int[128];
        int[] tArr = new int[128];

        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i)]++;
        }

        int need = 0;
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] > 0) need++;
        }

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int have = 0;

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i)]++;
            if (tArr[s.charAt(i)] == sArr[s.charAt(i)]) have++;
            
            while (have == need) {
                if ((i - left + 1) < minLength) {
                    minLeft = left;
                    minLength = i - left + 1;
                }

                sArr[s.charAt(left)]--;
                if (tArr[s.charAt(left)] > sArr[s.charAt(left)]) have--;

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minLeft + minLength);
    }
}
