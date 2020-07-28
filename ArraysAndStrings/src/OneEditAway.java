public class OneEditAway {
    public static boolean oneEditAway(String s1, String s2) {
        //edge case
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        int numberOfChanges = 0;
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) == s2.charAt(j)) continue;
            else {
                numberOfChanges++;
                if ((s1.length() > s2.length())) {
                    i--;
                } else {
                    j--;
                }
            }
            if (numberOfChanges > 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "bake";

        System.out.println("Strings one edit away? " + oneEditAway(s1, s2));
    }
}
