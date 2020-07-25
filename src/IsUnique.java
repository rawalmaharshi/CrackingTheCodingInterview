import java.util.HashMap;

public class IsUnique {
    public static boolean unique (String s) {
        //edge case [not implemented for empty string]
        if (s.length() == 1) {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) return false;
            map.put(s.charAt(i), 1);
        }

        return true;
    }

    public static boolean uniqueOptimized (String s) {
        //edge case
        if (s.length() > 128) { //ascii strings
            return false;
        }

        boolean char_set[] = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);  //returns the ascii code for that character
            if (char_set[val])  return false;

            char_set[val] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "quickbrown";
        System.out.println("Is unique: " + uniqueOptimized(input));
    }
}
