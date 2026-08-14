class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);

            right++;
        }
        return maxlen;
    }
}