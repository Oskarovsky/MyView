/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * Environment production
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// building scene
public class Scene {
    ArrayList<Edge3D> edges;    // edges init
    ArrayList<Wall> Walls;      // Walls init
    BasicMatrix mat;            // matrix init
    int last_wall_nb;
    

    public Scene(ArrayList<Edge3D> edges, BasicMatrix BasicMatrix) {
        this.edges = edges;
        this.mat = BasicMatrix;
        last_wall_nb = 0;
        Walls = new ArrayList<Wall>();
    }

    public ArrayList<Edge3D> newCuboid(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Color color) {
        // Declaration of elements of space
        ArrayList<Edge3D> edges = new ArrayList<Edge3D>();
        Point3D pt1 = new Point3D(minX, minY, minZ);
        Point3D pt2 = new Point3D(maxX, minY, minZ);
        Point3D pt3 = new Point3D(maxX, minY, maxZ);
        Point3D pt4 = new Point3D(minX, minY, maxZ);
        Point3D pt5 = new Point3D(minX, maxY, minZ);
        Point3D pt6 = new Point3D(maxX, maxY, minZ);
        Point3D pt7 = new Point3D(maxX, maxY, maxZ);
        Point3D pt8 = new Point3D(minX, maxY, maxZ);

        // Creating a complete Wall model
        Wall wallA = new Wall(pt1, pt2, pt3, pt4, color);     // bottom base
        Wall wallB = new Wall(pt8, pt7, pt6, pt5, color);     // upper base
        Wall wallC = new Wall(pt5, pt6, pt2, pt1, color);     // front Wall
        Wall wallD = new Wall(pt6, pt7, pt3, pt2, color);     // right Wall
        Wall wallE = new Wall(pt7, pt8, pt4, pt3, color);     // back Wall
        Wall wallF = new Wall(pt8, pt5, pt1, pt4, color);     // left Wall

        // Adding all Walls to the solid object
        Walls.add(wallA);
        Walls.add(wallB);
        Walls.add(wallC);
        Walls.add(wallD);
        Walls.add(wallE);
        Walls.add(wallF);

        // The edges of solid declaration
        Edge3D edgeA = new Edge3D(pt1, pt2, Walls.indexOf(wallA), Walls.indexOf(wallC));
        Edge3D edgeB = new Edge3D(pt2, pt3, Walls.indexOf(wallA), Walls.indexOf(wallD));
        Edge3D edgeC = new Edge3D(pt3, pt4, Walls.indexOf(wallA), Walls.indexOf(wallE));
        Edge3D edgeD = new Edge3D(pt4, pt1, Walls.indexOf(wallA), Walls.indexOf(wallF));
        Edge3D edgeE = new Edge3D(pt5, pt6, Walls.indexOf(wallB), Walls.indexOf(wallC));
        Edge3D edgeF = new Edge3D(pt6, pt7, Walls.indexOf(wallB), Walls.indexOf(wallD));
        Edge3D edgeG = new Edge3D(pt7, pt8, Walls.indexOf(wallB), Walls.indexOf(wallE));
        Edge3D edgeH = new Edge3D(pt8, pt5, Walls.indexOf(wallB), Walls.indexOf(wallF));
        Edge3D edgeI = new Edge3D(pt1, pt5, Walls.indexOf(wallC), Walls.indexOf(wallF));
        Edge3D edgeJ = new Edge3D(pt2, pt6, Walls.indexOf(wallC), Walls.indexOf(wallD));
        Edge3D edgeK = new Edge3D(pt3, pt7, Walls.indexOf(wallD), Walls.indexOf(wallE));
        Edge3D edgeL = new Edge3D(pt4, pt8, Walls.indexOf(wallE), Walls.indexOf(wallF));

        // Adding all edges to the solid object
        edges.add(edgeA);
        edges.add(edgeB);
        edges.add(edgeC);
        edges.add(edgeD);
        edges.add(edgeE);
        edges.add(edgeF);
        edges.add(edgeG);
        edges.add(edgeH);
        edges.add(edgeI);
        edges.add(edgeJ);
        edges.add(edgeK);
        edges.add(edgeL);
        
         return edges;
        
    }

    // Adding new solid
    public void addNewCuboid(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Color color) {
        this.edges.addAll(this.newCuboid(minX, minY, minZ, maxX, maxY, maxZ, color));
    }

    @Override
    public String toString() {
        return "Scene{" + "Edges=" + edges + ", Walls=" + Walls + '}';
    }
    
    public static ArrayList<Wall> backfaceCulling(ArrayList<Wall> Walls) {
        ArrayList<Wall> newWalls = new ArrayList<Wall>();
        for (Wall s : Walls) {
            double factor = s.A * s.pt1.x + s.B * s.pt1.y + s.C * s.pt1.z;
            if (factor < 0) {
                newWalls.add(s);
            }
        }
        
        
        
        return newWalls;
    }
}
