public class StringCompression {

    public static String compress(String inp) {
        //edge case
        if (inp.length() == 1) {
            return inp;
        }

        StringBuilder sb = new StringBuilder();
        int currCharCount = 1;
        int read = 0, anchor = 0;
        for (; anchor < inp.length(); anchor++) {
            char curr = inp.charAt(read);
            if (anchor < inp.length() - 1 && inp.charAt(anchor + 1) == curr) {
                currCharCount++;
            } else {
                sb.append(curr);
                sb.append(currCharCount);
                read = anchor + 1;
                currCharCount = 1;
            }
        }

        if (inp.length() < sb.length()) {
            return inp;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "aabcccccaaab";
        System.out.println("Compressed String: " + compress(input));
    }
}
