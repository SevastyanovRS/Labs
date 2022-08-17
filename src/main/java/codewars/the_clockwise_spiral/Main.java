package codewars.the_clockwise_spiral;

import static java.lang.Math.abs;

/**
 * 1  2  3  4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
 */

/**
 * 1  2  3
 * 12 13 4
 * 11 7 5
 */

public class Main {

    public static void main(String[] args) {
        int N = 10;
        int[][] spiral = createSpiral(N);
        int[][] spiral2 = createSpiral2(N);
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                System.out.printf("%02d ", spiral[i][k]);
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                System.out.printf("%02d ", spiral2[i][k]);
            }
            System.out.println();
        }
    }

    public static int[][] createSpiral(int N) {
        int[][] spiral = new int[N][N];
        if (N == 1) {
            spiral[0][0] = 1;
            return spiral;
        }
        int initial = 0;
        int end = N;
        int cycleCount = (N + (N % 2)) / 2 - 1;
        int last = 0;
        while (cycleCount != N) {
            for (int x = initial; x < end; x++) {
                for (int y = initial; y < end; y++) {
                    if (!(x == initial || x == end - 1 || y == initial || y == end - 1)) {
                        continue;
                    }
                    int tr =  (y - x + end) / end;
                    int off = ((x+1) + (y+1) - 1);
                    int cur = tr * off + abs(tr - 1) * (4 * end - 2 - off);
                    spiral[x][y] = last + cur;
                }
            }
            initial  = initial + 1;
            end = end - 1;
            cycleCount = cycleCount + 1;
            last = spiral[initial][initial - 1] - (2 + (initial - 1) * 2);
        }
        return spiral;
    }

    public static int[][] createSpiral2(int N) {
        int[][]res=new int [N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int x = 2 * i - N + 1;
                int y = 2 * j - N + 1;
                int n = Math.max(Math.abs(x), Math.abs(y));
                int p = (x + y) / 2;
                if (i < j) p = 2 * n - p;
                res [j][i] = N * N - n * n - n + p;
            }
        }
        return res;
    }
}
