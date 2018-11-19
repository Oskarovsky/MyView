/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * Creating the edges of objects - 2D
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// 2D Edge init
public class Edge2D {
    public Point2D point1;
    public Point2D point2;
    public int wall1;
    public int wall2;

    public Edge2D(Point2D point1, Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Edge2D(Point2D point1, Point2D point2, int wall1, int wall2) {
        this.point1 = point1;
        this.point2 = point2;
        this.wall1 = wall1;
        this.wall2 = wall2;
    }

}
