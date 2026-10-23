class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int currPointer = 0;

        while (currPointer < str.length()) {
            int delimiterPos = str.indexOf("#", currPointer);
            int numChars = Integer.parseInt(str.substring(currPointer, delimiterPos));

            String nextWord = str.substring(delimiterPos + 1, delimiterPos + 1 + numChars);
            strs.add(nextWord);

            currPointer = delimiterPos + 1 + numChars;
        }

        return strs;
    }
}
