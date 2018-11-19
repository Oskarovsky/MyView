/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAlgorithm;

import Driver.Wall;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * Polygons object
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class PolygonsList {
    ArrayList<Polygon> list;

    public PolygonsList(ArrayList<Wall> wl) {
        list = new ArrayList<Polygon>();
        for (Wall w : wl) {
            Polygon p = new Polygon(w);
            list.add(p);
        }     
    }

    public class Polygon {
        double A;
        double B;
        double C;
        double D;
        Color color;
        boolean io;

        public Polygon(Wall w) {
            this.io = false;
            this.color = w.color;
            this.A = w.A;
            this.B = w.B;
            this.C = w.C;
            this.D = w.D;        
        }

        public double resolveFor(int x, int y) {
            double z = -(this.A * x + this.B * y + this.D)/this.C;
            
            return z;
        }
        public double cooCrossingWithStraightLine(double x1, double y1, double z1, double x2, double y2, double z2) {
            double t = -(A * x1 + B * y1 + C * z1 + D) / (A * (x2 - x1) + B * (y2 - y1) + C * (z2 - z1));
            double z = z1 + t * (z2 - z1);
            return z;
        }

        public double distanceOfPointWhichCrossWithStraightLine(double x1, double y1, double z1, double x2, double y2, double z2) {
            double t = -(A * x1 + B * y1 + C * z1 + D) / (A * (x2 - x1) + B * (y2 - y1) + C * (z2 - z1));
            double x = x1 + t * (x2 - x1);
            double y = y1 + t * (y2 - y1);
            double z = z1 + t * (z2 - z1);
            double odl = Math.sqrt((x - x1)*(x - x1) + (y - y1)*(y - y1) + (z - z1)* (z - z1));
            return odl;
        }
    }
}
