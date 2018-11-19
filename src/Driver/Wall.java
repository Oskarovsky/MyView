/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.awt.Color;

/**
 *
 * Wall object
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// Definition of the existence of a wall
public class Wall {
    // 3D Points declaration
    public Point3D pt1;
    public Point3D pt2;
    public Point3D pt3;
    public Point3D pt4;

    // wall's color declaration
    public Color color;

    // 3D Edges declaration
    public Edge3D edge1;
    public Edge3D edge2;
    public Edge3D edge3;
    public Edge3D edge4;

    public double A;        
    public double B;        
    public double C;        
    public double D;

    // Wall object
    public Wall(Point3D pt1, Point3D pt2, Point3D pt3, Point3D pt4, Color color) {
        // 3D points
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.pt3 = pt3;
        this.pt4 = pt4;

        // color
        this.color = color;

        // points definition (in 3D space)
        double x1, x2, x3, y1, y2, y3, z1, z2, z3;
        x1 = pt1.x;
        y1 = pt1.y;
        z1 = pt1.z;
        x2 = pt2.x;
        y2 = pt2.y;
        z2 = pt2.z;
        x3 = pt3.x;
        y3 = pt3.y;
        z3 = pt3.z;

        this.A = y1 * z2 - y1 * z3 - y2 * z1 + y2 * z3 + y3 * z1 - y3 * z2;
        this.B = -x1 * z2 + x1 * z3 + x2 * z1 - x2 * z3 - x3 * z1 + x3 * z2;
        this.C = x1 * y2 - x1 * y3 - x2 * y1 + x2 * y3 + x3 * y1 - x3 * y2;
        this.D = -x1 * y2 * z3 + x1 * y3 * z2 + x2 * y1 * z3 - x2 * y3 * z1 - x3 * y1 * z2 + x3 * y2 * z1;

        this.edge1 = new Edge3D(pt1, pt2);
        this.edge2 = new Edge3D(pt2, pt3);
        this.edge3 = new Edge3D(pt3, pt4);
        this.edge4 = new Edge3D(pt4, pt1);
        
    }
   
}
