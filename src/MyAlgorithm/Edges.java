/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAlgorithm;

import Driver.Edge2D;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Edges (list of objects)
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class Edges {

    public ArrayList<ArrayList<Edge>> list;
    public Edges(ArrayList<Edge2D> edg, int screenHeight) {
        list = new ArrayList<ArrayList<Edge>>(screenHeight);

        for (int i = 0 ; i < screenHeight ; i++) {
            list.add(new ArrayList<Edge>());
        }

        for (Edge2D ed : edg) {
            if (ed.point1.y == ed.point2.y) {
                continue;      
            }
            Edge e = new Edge(ed);
            ArrayList<Edge> l = list.get(e.y_low);
            if (l.isEmpty()) {
                l.add(e);
            }
            else {          
                l.add(e);
                Collections.sort(l);
            }
        }
    }

    // This interface imposes a total ordering on the objects of each class that implements it (Comparable)
    public class Edge implements Comparable {

        // 2D rectangles parameters
        int x_low;
        int y_low;
        int x_top;
        int y_top;
        float c;
        int polygonsNb1;
        int polygonNb2;
        boolean vertical;

        Edge2D MotherEdge;

        public Edge(Edge2D me) {
            this.MotherEdge = me;
            vertical = false;

            if (me.point1.y < me.point2.y) {
                x_low = me.point1.x;
                y_low = me.point1.y;
                x_top = me.point2.x;
                y_top = me.point2.y;
                c = (float) ((float) x_top - x_low) / (y_top - y_low);
                polygonsNb1 = me.wall1;
                polygonNb2 = me.wall2;
            } else if (me.point1.y >= me.point2.y) {
                x_low = me.point2.x;
                y_low = me.point2.y;
                x_top = me.point1.x;
                y_top = me.point1.y;
                c = (float) (x_top - x_low) / (y_top - y_low);
                polygonsNb1 = me.wall1;
                polygonNb2 = me.wall2;
            }

            if (x_low == x_top) {
               vertical = true;
            }

        }
       
        @Override
        public int compareTo(Object o) {
            Edge e = (Edge) o;
            if (this.x_low < e.x_low) {
                return -1;
            } else if (this.x_low > e.x_low) {
                return 1;
            } else {
                if (this.c < e.c) {
                    return -1;
                } else if (this.c > e.c) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    } 
}
