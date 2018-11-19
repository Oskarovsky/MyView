/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.util.ArrayList;

/**
 *
 * Determining the point of PointOfView
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// Choice of view
public class PointOfView {
    int height;     // height POV
    int width;      // width POV
    
    ArrayList<Edge2D> edgesOnView;
    Camera camera;

    // POV declaration
    public PointOfView(int height, int width, Camera camera) {
        this.height = height;
        this.width = width;
        this.camera = camera;
        
        this.edgesOnView = moveEdgesToView(camera.edgesOnCamera);
    }


    // changing point's position
    Point2D movePointToView(Point3D p) {
        int x = (int) ((p.x - camera.x_min) * width / (camera.x_max - camera.x_min));
        int y = height - ((int) ((p.y - camera.y_min) * height / (camera.y_max - camera.y_min))); 
        return new Point2D(x, y, p.z);
    }

    // changing edge's position
    Edge2D moveEdgeToView(Edge3D kr) {
        return new Edge2D(movePointToView(kr.point1), movePointToView(kr.point2), kr.wall1_nb, kr.wall2_nb);
    }
    
    ArrayList<Edge2D> moveEdgesToView(ArrayList<Edge3D> edgesOnCamera) {
        ArrayList<Edge2D> edgg = new ArrayList<Edge2D>();
        
        for (Edge3D edg : edgesOnCamera) {
            edgg.add(moveEdgeToView(edg));
        }
        return edgg;
        
    }

    public ArrayList<Edge2D> getEdgesOnView() {
        return edgesOnView;
    }
    
    public String writeEdgesOnView() {
        String ret = new String();
        
        for (Edge2D edg :edgesOnView) {
            ret += edg.toString();
            ret += "\n";
        }
        
        return ret;
    }
    
    public double[] coordinatesBackToCamera(double x, double y) {
        double ret[] = new double[2];
        ret[0] = x * (camera.x_max - camera.x_min) / width + camera.x_min;     
        ret[1] = (height - y) * (camera.y_max - camera.y_min) / height + camera.y_min;
        
        return ret;
        
    }
}
