/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.util.ArrayList;

/**
 *
 * Observer's point of PointOfView
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class Camera {
    double x_min = -1;
    double x_max = 1;
    double y_min = -1;
    double y_max = 1;

    // list of all existing edges
    ArrayList<Edge3D> edgesOnCamera;
    

    public Camera(ArrayList<Edge3D> edgesOnViewPort) {
        edgesOnCamera = new ArrayList<Edge3D>();
        for(Edge3D edg : edgesOnViewPort) {
            if (isEdgeOnCamera(edg)) {
                edgesOnCamera.add(edg);
            }
        }
    }

    public Camera() { }

    // creating elements on the platform
    public ArrayList<Wall> cutWallsToCamera(ArrayList<Wall> Walls) {
        this.edgesOnCamera = new ArrayList<Edge3D>();

        // creating new Wall
        ArrayList<Wall> newWalls = new ArrayList<Wall>();
        for (Wall wl : Walls) {
            if (isEdgeOnCamera(wl.edge1) && isEdgeOnCamera(wl.edge2)
                    && isEdgeOnCamera(wl.edge3) && isEdgeOnCamera(wl.edge4)) {
                edgesOnCamera.add(wl.edge1);
                edgesOnCamera.add(wl.edge2);
                edgesOnCamera.add(wl.edge3);
                edgesOnCamera.add(wl.edge4);
                newWalls.add(wl);
            }
        }
        for (int i = 0; i < newWalls.size() ; i++) {
            Wall wl = newWalls.get(i);
            wl.edge1.wall1_nb = i;
            wl.edge2.wall1_nb = i;
            wl.edge3.wall1_nb = i;
            wl.edge4.wall1_nb = i;
            
            
        }
        return newWalls;
    }

    // DISPLAYING ELEMENTS
    private boolean isPointOnCamera(Point3D p) {
        if (p.x >= x_min && p.x <= x_max && p.y >= y_min && p.y <= y_max) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean isEdgeOnCamera(Edge3D kr) {
        if (isPointOnCamera(kr.point1) && isPointOnCamera(kr.point2)) {
            return true;
        }
        else {
            return false;
        }
    } 
}
