/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * Creating the edges of objects - 3D
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// 3D Edge init
public class Edge3D {
    Point3D point1;
    Point3D point2;
    int wall1_nb;
    int wall2_nb;

    public Edge3D(Point3D point1, Point3D point2, int wall1_nb, int wall2_nb) {
        this.point1 = point1;
        this.point2 = point2;
        this.wall1_nb = wall1_nb;
        this.wall2_nb = wall2_nb;
    }

    public Edge3D(Point3D point1, Point3D point2) {
        this.point1 = point1;
        this.point2 = point2;

    }

}
