/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * Determining points - 3D
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */
public class Point3D {
    public double x;
    public double y;
    public double z;
    double w;

    // 3D point init
     public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }


    public Point3D(double[][] cooVector) {
        this.x = cooVector[0][0];
        this.y = cooVector[1][0];
        this.z = cooVector[2][0];
        this.w = cooVector[3][0];
        
    }

    public double[][] cooVector() {
        double t[][] = {
            {this.x},
            {this.y},
            {this.z},
            {this.w}
        };
        return t;
    }


    void normalise() {
        this.x = this.x / this.w;
        this.y = this.y / this.w;
        this.z = this.z / this.w;
        this.w = this.w / this.w;
    }

    
}
