/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * Matrix init
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class BasicMatrix {
    double[][] matrix;

    public BasicMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    // macierz jednostkowa
    public static double[][] Identity_Matrix() {
        double[][] mat = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return mat;
    }

    // display matrix
    public static double[][] Projection_Matrix(double d) {
        double[][] mat = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 1 / d, 0}
        };
        return mat;

    }

    // translation matrix
    public static double[][] Translation_Matrix(double Tx, double Ty, double Tz) {
        double[][] mac = {
            {1, 0, 0, Tx},
            {0, 1, 0, Ty},
            {0, 0, 1, Tz},
            {0, 0, 0, 1}
        };
        return mac;
    }

    // Matrix for rotation along the OX axis
    public static double[][] OX_Rotation_Matrix(double fi) {
        double[][] mat = {
            {1, 0, 0, 0},
            {0, Math.cos(fi), -1 * Math.sin(fi), 0},
            {0, Math.sin(fi), Math.cos(fi), 0},
            {0, 0, 0, 1}
        };
        return mat;
    }

    // Matrix for rotation along the OY axis
    public static double[][] OY_Rotation_Matrix(double fi) {
        double[][] mat = {
            {Math.cos(fi), 0, Math.sin(fi), 0},
            {0, 1, 0, 0},
            {-1 * Math.sin(fi), 0, Math.cos(fi), 0},
            {0, 0, 0, 1}
        };
        return mat;
    }

    // Matrix for rotation along the OZ axis
    public static double[][] OZ_Rotation_Matrix(double fi) {
        double[][] mat = {
            {Math.cos(fi), -1 * Math.sin(fi), 0, 0},
            {Math.sin(fi), Math.cos(fi), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return mat;
    }

    public static double[][] multiply(double a[][], double b[][]) {

        int aRows = a.length,
                aColumns = a[0].length,
                bRows = b.length,
                bColumns = b[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] resultant = new double[aRows][bColumns];

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    resultant[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return resultant;
    }
}
