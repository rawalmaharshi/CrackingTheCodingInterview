import java.util.Arrays;
import java.util.HashSet;

public class ZeroMatrix {
    public static int[][] zeroMatrix (int [][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int [][] result = new int [M][N];
        for (int a = 0; a < result.length; a++) {
            Arrays.fill(result[a], -1);
        }

        HashSet<Integer> iZero = new HashSet<>();
        HashSet<Integer> jZero = new HashSet<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (iZero.size() == M || jZero.size() == N) {
                    return result;  //the matrix would already be zero
                }

                if (matrix[i][j] == 0) {
                    if (!iZero.contains(i)) {
                        iZero.add(i);
                        int x = 0;
                        while (x < N) {
                            result[i][x] = 0;
                            x++;
                        }
                    }

                    if (!jZero.contains(j)) {
                        jZero.add(j);
                        int y = 0;
                        while (y < M) {
                            result[y][j] = 0;
                            y++;
                        }
                    }
                } else {
                    if (result[i][j] == -1)
                        result[i][j] = matrix[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] input = {
                {1,6,8,2},
                {4,3,0,1},
                {7,0,9,5},
                {6,8,3,1},
                {8,9,7,6}
        };

        int [][] result = zeroMatrix(input);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
