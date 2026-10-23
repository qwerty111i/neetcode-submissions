class Solution {
    public String minWindow(String s, String t) {
        int[] c1 = new int[128];
        int[] c2 = new int[128];

        int numUnique = 0;
        for (char c : t.toCharArray()) {
            if (c1[c] == 0) numUnique++;
            c1[c]++;
        }

        StringBuilder sb = new StringBuilder();
        String currShortestString = s;
        boolean stringFound = false;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            c2[s.charAt(right)]++;
            sb.append(s.charAt(right));

            if (c1[s.charAt(right)] == c2[s.charAt(right)]) numUnique--;
            while (numUnique == 0) {
                stringFound = true;

                c2[s.charAt(left)]--;
                if (c2[s.charAt(left)] < c1[s.charAt(left)]) {
                    numUnique++;
                    if (sb.toString().length() < currShortestString.length()) {
                        currShortestString = sb.toString();
                    }
                }
                
                sb.deleteCharAt(0);
                left++;
            }
        }

        if (stringFound) return currShortestString;
        return "";
    }
}
