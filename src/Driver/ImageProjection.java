/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.util.ArrayList;

/**
 *
 * Projection of the platform image
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */


public class ImageProjection {
    double d;

    // Calling the matrix class
    BasicMatrix BasicMatrix;

    public ImageProjection(double d) {
        this.d = d;
        BasicMatrix = new BasicMatrix(BasicMatrix.Projection_Matrix(d));
    }

    // point init
    Point3D project_point(Point3D p) {
        Point3D pt = new Point3D(p.x * this.d / p.z, p.y * this.d / p.z, this.d);
        return pt;
    }

    // edge init
    Edge3D project_edge(Edge3D edg) {
        return new Edge3D(project_point(edg.point1), project_point(edg.point2), edg.wall1_nb, edg.wall2_nb);
        
    }

    // list of all edges - init
    ArrayList<Edge3D> projectEdges(ArrayList<Edge3D> edges) {
        ArrayList<Edge3D> projectedEdges = new ArrayList<Edge3D>();
        for (Edge3D edg : edges) {
            projectedEdges.add(project_edge(edg));
        }
        return projectedEdges;
    }

    // list of all Walls - init
    ArrayList<Wall> projectWalls(ArrayList<Wall> Walls) {
        ArrayList<Wall> projectedWalls = new ArrayList<Wall>();
        for (Wall wl : Walls) {
            projectedWalls.add(projectWall(wl));
        }
        return projectedWalls;
    }

    // creating Wall
    Wall projectWall(Wall wall) {
        wall.edge1 = project_edge(wall.edge1);
        wall.edge2 = project_edge(wall.edge2);
        wall.edge3 = project_edge(wall.edge3);
        wall.edge4 = project_edge(wall.edge4);
        return wall;
    } 
}
