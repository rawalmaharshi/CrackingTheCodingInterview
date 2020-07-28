public class URLify {
    public static char [] urlify (char [] input, int trueLength) {
        char [] answer = input;
        for (int i = input.length - 1, j = trueLength - 1; j >= 0; j--) {
            if (input[j] != ' ') {
                input[i--] = input[j];
            } else {
                input[i--] = '0';
                input[i--] = '2';
                input[i--] = '%';
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String input = "Mr John Smith    " ;
        int trueLength = 13;
        System.out.println("URL String: " + String.valueOf(urlify(input.toCharArray(), trueLength)));
    }
}
