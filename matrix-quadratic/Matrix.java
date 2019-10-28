/*
* Copyright 2019 David Boyd, all rights reserved
* Program: Class Matrix
* Description:
*   Creates a MxN matrix specified by the user.
*   Then generates random values for that matrix.
*   This class also allows addition of matrices
*   and multiplication by either scalar or matrix.
* Date: Thu Oct 17 13:23:07 CDT 2019
* Revised:
*      Mon Oct 21 15:10:39 CDT 2019
*/
//import java.util.Scanner;  // uncomment: usrinput fillmatrix()
import java.util.Random;

class Matrix {
    private int M;  // number of rows
    private int N;  // number of columns
    private int [][] matrix;          // random valued matrix
    private int [][] sumMatrix;
    private int [][] productMatrix;
    private boolean equalDimensions;  // Used for add()
    private boolean equalColRowDim;   // Used for multi()

    // Constructor
    Matrix(int rows, int columns) {
        setM(rows);
        setN(columns);
        setMatrix();
        fillmatrix();
        setSumMatrix();
    }

    // Setters & Getters
    private void setM(int rows) {
        this.M = rows;
    }

    public int getM() {
        return this.M;
    }

    private void setN(int cols) {
        this.N = cols;
    }

    public int getN() {
        return this.N;
    }

    private void setMatrix() {
        this.matrix = new int[getM()][getN()];
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    private void setSumMatrix() {
        this.sumMatrix = new int[getM()][getN()];
    }

    public int[][] getSumMatrix() {
        return this.sumMatrix;
    }

    private void setProductMatrix(int row, int col) {
        this.productMatrix = new int[row][col];
    }

    public int[][] getProductMatrix() {
        return this.productMatrix;
    }

    private void setEqualDimensions(boolean truefalse) {
        this.equalDimensions = truefalse;
    }

    public boolean getEqualDimensions() {
        return this.equalDimensions;
    }

    private void setEqualColRowDim(boolean truefalse) {
        this.equalColRowDim = truefalse;
    }

    public boolean getEqualColRowDim() {
        return this.equalColRowDim;
    }

    // Fill matrix with random integers between 0 and 99
    private void fillmatrix() {
        for (int i=0; i<getM(); ++i) {
            for (int j=0; j<getN(); ++j) {
                Random rand = new Random();
                getMatrix()[i][j] = rand.nextInt(100);
                /*
                // Uncomment userinput matrix values
                Scanner number = new Scanner(System.in);
                System.out.print("\nEnter the element["+i+"]["+j+"]");
                Scanner scan_c = new Scanner(System.in);
                getMatrix()[i][j] = scan_c.nextInt();
                */
            }
        }
    }

    // Display matrix by row x column table
    public void printMatrix() {
        for (int i=0; i<getM(); ++i) {
            for (int j=0; j<getN(); ++j) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
     }

    // Display sumMatrix
    public void printSumMatrix() {
        if (getEqualDimensions()) {
            for (int i=0; i<getM(); ++i) {
                for (int j=0; j<getN(); ++j) {
                    System.out.print(getSumMatrix()[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid Matrix");
        }
     }

    // Display productMatrix
    public void printProductMatrix() {
        if (getEqualColRowDim()) {
            int rows = getProductMatrix().length;
            int cols = getProductMatrix()[0].length;
            for (int i=0; i<rows; ++i) {
                for (int j=0; j<cols; ++j) {
                    System.out.print(getProductMatrix()[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid Matrix");
        }
     }

    // Compare Matricies Dimensions
    private void checkDimensions(int rows, int cols) {
        // Check for addition requirements
        if (getMatrix().length == rows && getMatrix()[0].length == cols) {
            setEqualDimensions(true);
            setEqualColRowDim(true);
        } else {
            setEqualDimensions(false);

            // Check for multiplication requirements
            if (getMatrix()[0].length == rows) {
                setEqualColRowDim(true);
            } else {
                setEqualColRowDim(false);
            }
        }
    }

    // Add Another Matrix
    public int[][] add(int[][] addend) {
        int rows = addend.length;
        int cols = addend[0].length;

        checkDimensions(rows, cols);

        if (getEqualDimensions()) {
            for(int i=0; i<rows; i++) {
                for(int j=0; j<cols; j++) {
                    getSumMatrix()[i][j] = (getMatrix()[i][j] + addend[i][j]);
                }
            }
        }
        return getSumMatrix();
    }

    // Multiply Matrix by Scalar
    public int[][] scalar(int scalar) {
        // Create new productMatrix
        setProductMatrix(getM(), getN());
        setEqualColRowDim(true);

        for(int i=0; i<getM(); i++) {
            for(int j=0; j<getN(); j++) {
                getProductMatrix()[i][j] = (getMatrix()[i][j] * scalar);
            }
        }
        return getProductMatrix();
    }

    // Multiply Matrix by Matrix
    public int[][] multiply(int[][] factorMatrix) {
        int rows = factorMatrix.length;
        int cols = factorMatrix[0].length;
        int sum = 0;

        // Check Multiplication Validity
        checkDimensions(rows, cols);
        if (getEqualColRowDim()) {
            // Create new productMatrix
            setProductMatrix(getM(), cols);

            // Calculate product matrix
            for(int i=0; i<getM(); i++) {           // i=1stM's rows
                for(int j=0; j<cols; j++) {         // j=2ndM's cols
                    for (int k=0; k<getN(); ++k) {  // k=1M's cols && 2M's rows
                        sum += getMatrix()[i][k] * factorMatrix[k][j];
                    } // END for k
                    getProductMatrix()[i][j] = sum;
                    sum = 0;
                } // END for j
            } // END for i
            return getSumMatrix();
        } else {
            return null;
        } // END else
    } // END multiply()
}
