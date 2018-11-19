/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * Determining points - 2D
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// Points in two-dimensional (2D) space
public class Point2D {
    public int x;
    public int y;

    public double matrixZ;

    // 2D point init
    public Point2D(int x, int y, double matrixZ) {
        this.x = x;
        this.y = y;
        this.matrixZ = matrixZ;
    }
    
}
