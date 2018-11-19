/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Active Edges which we can see on the screen
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class ActiveEdges {
 
    Edges edgesArray;
    public ArrayList<activeEdge> list;

    public ActiveEdges(Edges aE, int screenHeight) {
        this.list = new ArrayList<activeEdge>();
        this.edgesArray = aE;
    }

    public List<activeEdge> nextActiveEdges(int y) {  
        ArrayList<activeEdge> newList = new ArrayList<activeEdge>();
        for (activeEdge aEd : list) {       
            if (aEd.y_top > y) {           
                newList.add(aEd);
            }
        }
        list = newList;
        for (activeEdge aEd : list) {
            if (aEd.vertical == false) {
                aEd.x_cross += aEd.c;
            }
        }

        ArrayList<Edges.Edge> array = edgesArray.list.get(y);
        if (array != null) {
            for (Edges.Edge ed : array) {
                list.add(new activeEdge(ed));
            }
        }
        Collections.sort(list);

        return list;
    }

    // This interface imposes a total ordering on the objects of each class that implements it (Comparable)
    public class activeEdge implements Comparable {

        // 2D rectangles parameters
        int x_low;
        int y_low;
        int x_top;
        int y_top;

        float c;
        int polygonNb;
        int polygonNb2;
        boolean vertical;
        float x_cross;

        // Rectangles declaration - init
        public activeEdge(Edges.Edge ed) {
            this.x_low = ed.x_low;
            this.y_low = ed.y_low;
            this.x_top = ed.x_top;
            this.y_top = ed.y_top;
            this.c = ed.c;
            this.polygonNb = ed.polygonsNb1;
            this.polygonNb2 = ed.polygonNb2;
            this.vertical = ed.vertical;
            this.x_cross = (float) this.x_low;
        }

        @Override
        public int compareTo(Object o) {
            activeEdge aE = (activeEdge) o;
            if (this.x_cross < aE.x_cross) {
                return -1;
            } else if (this.x_cross == aE.x_cross) {
                return 0;
            } else {
                return 1;
            }
        }
    }   
}
