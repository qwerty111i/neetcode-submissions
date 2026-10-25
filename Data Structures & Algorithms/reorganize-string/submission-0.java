class Solution {
    public String reorganizeString(String s) {
        int[] charFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) {
                heap.offer(new int[]{i + 'a', charFreq[i]});
                if (charFreq[i] > (s.length() + 1) / 2) {
                    return "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] temp = {-1, -1};
        while (!heap.isEmpty()) {
            int[] nextChar = heap.poll();
            if (temp[0] != -1) {
                heap.offer(temp);
            }

            if (nextChar[1] - 1 > 0) {
                temp = new int[]{nextChar[0], nextChar[1] - 1};
            } else {
                temp = new int[]{-1, -1};
            }

            sb.append((char) nextChar[0]);
        }

        return sb.toString();
    }
}