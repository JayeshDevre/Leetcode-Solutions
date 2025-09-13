class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapst = new HashMap<>();
        HashMap<Character, Character> mapts = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // check s → t mapping
            if (mapst.containsKey(c1)) {
                if (mapst.get(c1) != c2) {
                    return false; // mismatch
                }
            } else {
                mapst.put(c1, c2); // add new mapping
            }

            // check t → s mapping
            if (mapts.containsKey(c2)) {
                if (mapts.get(c2) != c1) {
                    return false; // mismatch
                }
            } else {
                mapts.put(c2, c1); // add new mapping
            }
        }
        return true;
    }
}
