class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        int c = 0;
        int n = s.length();
        ArrayList<String> list = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == '1') {
                c++;
            }
            while (c == k) {
                list.add(s.substring(l, r + 1));
                if (s.charAt(l) == '1') {
                    c--;
                }

                l++;
            }
        }
        if (list.isEmpty()) {
            return "";
        }
        Collections.sort(list, (a, b) -> {
             if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
          return list.get(0);
    }
}