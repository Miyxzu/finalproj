package finalproj;

public class test {
    public static void main(String[] args) {
        int[][] test = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                System.out.println("Row: " + (i + 1) + ", Column: " + (j + 1) + ": " + test[i][j]);
            }
        }
    }
}
