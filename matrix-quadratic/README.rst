Matrix Quadratic
################
:Author: David Boyd
:Date: Mon Oct 28 14:18:09 CDT 2019

Matrix Quadratic is a program that performs calculations on matrices and
quadratic equations.

To Run Program
==============

Use Make to compile, run, and clean program.

.. code-block :: Bash

	make
	make run
	make clean

Matrix
======
:obj: Matrix

The Matrix class allows the user to define the dimensions a 2D-array.  The
matrix will auto-fill the values with random numbers between 0 and 99.  The
**math** methods include **add(int)**, and multiplication by either
**scalar(int)** or another matrix: **multiple(int[][])**.

To print the results, use either **printSumMatrix()** or
**printProdcutMatrix()**.

Quadratic Equation
==================
:obj: QuadEq

The QuadEq class accepts 3 numbers for the coefficients of a quadratic
equation.  The class will then calculate the roots of p, q otherwise the
complex roots of real, imaginary.

To print the results, use **displayRoots()**

