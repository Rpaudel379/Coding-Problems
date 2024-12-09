public class ThirtyNine {
    public static void main(String[] args) {
        Search2DMatrix search = new Search2DMatrix();

        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
                { 23, 30, 34, 60 } };

        System.out.println(search.bruteForce(matrix, 3));
        System.out.println(search.searchMatrix1(matrix, 17));
        System.out.println(search.searchMatrix2(matrix, 17));
        System.out.println(search.binarySearch1(matrix, 1));
        System.out.println(search.binarySearch2(matrix, 20));

    }
}

class Search2DMatrix {

    // T - O(log n * m)
    public boolean binarySearch2(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;

        int lo = 0, hi = (rows * cols) - 1;

        while (lo <= hi) {

            int midIdx = (lo + hi) / 2;
            int curRow = midIdx / cols;
            int curCol = midIdx % cols;

            int mid = matrix[curRow][curCol];

            if (mid < target) {
                lo = midIdx + 1;
            } else if (mid > target) {
                hi = midIdx - 1;
            } else {
                return true;
            }

        }

        return false;
    }

    // T - O(log n * m)
    public boolean binarySearch1(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;

        int topRow = 0, bottomRow = rows - 1;

        while (topRow <= bottomRow) {
            int midRowIdx = (topRow + bottomRow) / 2;

            if (target < matrix[midRowIdx][0]) {
                bottomRow = midRowIdx - 1;
            } else if (target > matrix[midRowIdx][cols - 1]) {
                topRow = midRowIdx + 1;
            } else {
                break;
            }

        }

        if (topRow > bottomRow) {
            return false;
        } else {

            int midRowIdx = (topRow + bottomRow) / 2;
            int lo = 0, hi = cols - 1;

            while (lo <= hi) {
                int midIdx = (lo + hi) / 2;
                int mid = matrix[midRowIdx][midIdx];

                if (mid == target) {
                    return true;
                } else if (mid < target) {
                    lo = midIdx + 1;
                } else {
                    hi = midIdx - 1;
                }
            }

        }

        return false;
    }

    // T - O(n)
    // S - O(1)
    public boolean searchMatrix2(int[][] matrix, int target) {

        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }

        }

        return false;
    }

    // O(nlog m)
    public boolean searchMatrix1(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            int length = matrix[0].length;
            int lo = 0, hi = length - 1;

            while (lo <= hi) {
                int midIdx = (lo + hi) / 2;
                int mid = matrix[i][midIdx];

                if (mid == target) {
                    return true;
                } else if (target < mid) {
                    hi = midIdx - 1;
                } else {
                    lo = midIdx + 1;
                }
            }

        }

        return false;
    }

    // brute force
    // O(n2)
    public boolean bruteForce(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}