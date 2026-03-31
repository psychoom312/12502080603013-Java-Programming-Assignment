public class MatrixOperations {

    static class Matrix {
        private final int rows;
        private final int cols;
        private final double[][] data;

        public Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.data = new double[rows][cols];
        }

        public Matrix(double[][] data) {
            this.rows = data.length;
            this.cols = data[0].length;
            this.data = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(data[i], 0, this.data[i], 0, cols);
            }
        }

        public Matrix transpose() {
            Matrix result = new Matrix(cols, rows);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.data[j][i] = this.data[i][j];
                }
            }
            return result;
        }

        public Matrix multiply(Matrix other) {
            if (this.cols != other.rows) {
                throw new IllegalArgumentException("Matrix dimensions mismatch: " + this.cols + " cols vs " + other.rows + " rows.");
            }

            Matrix result = new Matrix(this.rows, other.cols);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < other.cols; j++) {
                    for (int k = 0; k < this.cols; k++) {
                        result.data[i][j] += this.data[i][k] * other.data[k][j];
                    }
                }
            }
            return result;
        }

        public void display(String label) {
            System.out.println(label);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(data[i][j] + "  ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] dataA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        double[][] dataB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        Matrix matrixA = new Matrix(dataA);
        Matrix matrixB = new Matrix(dataB);

        matrixA.display("Matrix A:");
        matrixB.display("Matrix B:");

        Matrix transposedA = matrixA.transpose();
        transposedA.display("Transpose of A:");

        Matrix resultMultiplication = matrixA.multiply(matrixB);
        resultMultiplication.display("Result of A * B:");
    }
}
