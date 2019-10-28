/*
* Copyright 2019 David Boyd, all rights reserved
* Program: Quadratic Equation and Matrix Math
* Description:
*     This program creates matrices and performs calculations.
*     This program finds the roots of a quadratic equation.
* Date: Thu Oct 17 13:23:07 CDT 2019
* Revised:
*      Mon Oct 21 15:10:39 CDT 2019
*/
import static java.lang.System.out;
import java.util.Scanner;

class Driver {

    public static int getInt() {
        Scanner scan_r = new Scanner(System.in);
        int number = scan_r.nextInt();
        return number;
    }
    public static double getDouble() {
        Scanner scan_r = new Scanner(System.in);
        double number = scan_r.nextInt();
        return number;
    }
    public static void main(String args[]) {

        // Hardcoded variables
        int hc_rows = 3;
        int hc_cols = 3;
        int hc_scalar = 2;

        // Display Quadratics Section
        out.println("\n\n");
        out.println("=================");
        out.println("=== MATRICIES ===");
        out.println("=================");

        // Get Matrix Dimensions
        out.println("\nMatrix A:");
        out.print("Enter the number of rows: ");
        int rows1 = getInt();
        out.print("Enter the number of columns: ");
        int cols1 = getInt();
        out.println("\nMatrix B:");
        out.print("Enter the number of rows: ");
        int rows2 = getInt();
        out.print("Enter the number of columns: ");
        int cols2 = getInt();

        // Create Matricies
        Matrix A = new Matrix(rows1, cols1);
        Matrix B = new Matrix(rows2, cols2);
        Matrix C = new Matrix(hc_rows, hc_cols);

        // Print matrices
        System.out.println("\nPrinting Matrices");
        System.out.println("=====================");
        out.println();
        System.out.println("Matrix A");
        System.out.println("--------");
        A.printMatrix();
        out.println();
        System.out.println("Matrix B");
        System.out.println("--------");
        B.printMatrix();
        out.println();
        System.out.println("Matrix C");
        System.out.println("--------");
        C.printMatrix();
        out.println();

        // Add matricies and display
        out.println("\nPrinting Sum of Matrices");
        out.println("========================\n");
        out.println("Matrix A + Matrix B");
        out.println("-------------------");
        A.add(B.getMatrix());
        A.printSumMatrix();
        out.println("\n");
        out.println("Matrix A + Matrix C");
        out.println("-------------------");
        A.add(C.getMatrix());
        A.printSumMatrix();


        // Multiply scalar, matricies and display
        System.out.println("\n\nPrinting Product of Matrices");
        System.out.println("============================\n");
        out.println("Matrix A * Scalar("+hc_scalar+")");
        out.println("--------------------");
        A.scalar(hc_scalar);
        A.printProductMatrix();
        System.out.println("\n");
        out.println("Matrix A * Matrix B");
        out.println("-------------------");
        A.multiply(B.getMatrix());
        A.printProductMatrix();
        System.out.println("\n");
        out.println("Matrix A * Matrix C");
        out.println("-------------------");
        A.multiply(C.getMatrix());
        A.printProductMatrix();
        System.out.println("\n");

        // Display Quadratics Section
        out.println("\n\n");
        out.println("==================");
        out.println("=== QUADRATICS ===");
        out.println("==================");

        // Instantiate QuadEd objects
        QuadEq one_eq = new QuadEq(1, 6, 8);        // p=-2, q=-4
        QuadEq two_eq = new QuadEq(1, 2, 143);      // p=11, q=-13
        QuadEq third_eq = new QuadEq(2.3, 4, 5.6);  // p=q= -0.87+1.30i
        out.println("\nEnter your numbers for quadratic");
        out.println("--------------------------------");
        out.print("Enter a: ");
        double a = getDouble();
        out.print("Enter b: ");
        double b = getDouble();
        out.print("Enter c: ");
        double c = getDouble();
        QuadEq user_eq = new QuadEq(a, b, c);

        // Print QuadEq results
        System.out.println("\nPrinting Quadratics");
        System.out.println("===================\n");
        out.println("a = 1, b = 6, c = 8");
        out.println("-------------------");
        one_eq.displayRoots();
        out.println("\n\na = 1, b = 2, c = 143");
        out.println("----------------------");
        two_eq.displayRoots();
        out.println("\n\na = 2.3, b = 4.0, c = 5.6");
        out.println("-------------------------------");
        third_eq.displayRoots();
        out.println("\n\na = "+a+", b = "+b+", c = "+c);
        out.println("-------------------------------");
        user_eq.displayRoots();
        out.println("\n");
    }
}
