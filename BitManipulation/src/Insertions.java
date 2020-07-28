public class Insertions {

    public static int updateBits (int n, int m, int i, int j) {
        int allZeros = 0;

        int leftMask = (-1) << j + 1;
        int rightMask = (-1) << (i - 1);

        int mask = leftMask | rightMask;

        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }

    public static int updateBitsBook (int n, int m, int i, int j) {
        int allOnes = ~0;

        int left = allOnes << (j + 1);
        int right = ((1 << i) - 1);

        int mask = left | right;
        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }

    public static void main(String[] args) {
        int n = 100000000;
        int m = 10011;
        int i = 2;
        int j = 6;

        System.out.println(updateBitsBook(n, m, i, j));
    }
}
