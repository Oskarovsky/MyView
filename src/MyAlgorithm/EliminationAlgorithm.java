/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAlgorithm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import Driver.Edge2D;
import Driver.Wall;
import Driver.PointOfView;
import MyAlgorithm.PolygonsList.Polygon;
import MyAlgorithm.ActiveEdges.activeEdge;

/**
 *
 * Elimination Algorithm
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class EliminationAlgorithm {
    ArrayList<Edge2D> edges;
    ArrayList<Wall> Walls;
    int height, width;
    Color backgroundColor;
    public Edges edgesArray;
    public ActiveEdges activeEdgesArray;
    PolygonsList polygonsList;
    public double d;
    PointOfView PointOfView;

    public EliminationAlgorithm(ArrayList<Edge2D> edges, ArrayList<Wall> Walls, int height, int width, Color backgroundColor, double d, PointOfView PointOfView) {
        this.edges = edges;
        this.Walls = Walls;
        this.height = height;
        this.width = width;
        this.backgroundColor = backgroundColor;
        this.edgesArray = new Edges(edges, height);
        this.activeEdgesArray = new ActiveEdges(this.edgesArray, height);
        this.polygonsList = new PolygonsList(Walls);
        this.d = d;
        this.PointOfView = PointOfView;

    }

    public ArrayList<Segment> prepareSegmentsList(int y, List<activeEdge> activeEdges) {
        ArrayList<Segment> segmentsList = new ArrayList<Segment>();
        float xleft = 0;
        float xRight;

        if (activeEdges.isEmpty()) {
            xRight = width - 1;
        } else {
            xRight = activeEdges.get(0).x_cross;
        }

        segmentsList.add(new Segment(y, xleft, xRight, new ArrayList<Polygon>()));

        for (Polygon w : polygonsList.list) {
            w.io = false;
        }

        for (activeEdge aE : activeEdges) {
            xleft = aE.x_cross;
            if (activeEdges.indexOf(aE) == activeEdges.size() - 1) {
                xRight = width - 1;
            } else {
                xRight = activeEdges.get(activeEdges.indexOf(aE) + 1).x_cross;
            }

            polygonsList.list.get(aE.polygonNb).io = !polygonsList.list.get(aE.polygonNb).io;


            ArrayList<PolygonsList.Polygon> toogleTrueList = new ArrayList<Polygon>();
            for (Polygon p : polygonsList.list) {
                if (p.io) {
                    toogleTrueList.add(p);
                }
            }

            Segment seg = new Segment(y, xleft, xRight, toogleTrueList);

            segmentsList.add(seg);
        }

        return segmentsList;
    }

    public ScreenBuffer eliminate() {
        ScreenBuffer screenBuffer = new ScreenBuffer(width, height, backgroundColor);

        for (int y = 0; y < height; y++) {
            List<activeEdge> activeEdges = activeEdgesArray.nextActiveEdges(y);
            ArrayList<Segment> segmenList = prepareSegmentsList(y, activeEdges);

            for (Segment seg : segmenList) {
                screenBuffer.paint(y, Math.round(seg.xLeft), Math.round(seg.xRight), seg.color);
            }

        }
        return screenBuffer;
    }

    public Color paintVisibleWalls(double x, int y, ArrayList<PolygonsList.Polygon> polygons) {
        if (polygons.isEmpty()) {
            return backgroundColor;
        }
        double min_z;
        double[] cooPointOnView = PointOfView.coordinatesBackToCamera(x, (double) y);
        min_z = polygons.get(0).distanceOfPointWhichCrossWithStraightLine(0, 0, 0, cooPointOnView[0], cooPointOnView[1], d);
        Color color = polygons.get(0).color;
        for (PolygonsList.Polygon p : polygons) {
            double z = p.distanceOfPointWhichCrossWithStraightLine(0, 0, 0, cooPointOnView[0], cooPointOnView[1], d);
            if (z < min_z) {
                min_z = z;
                color = p.color;
            }
        }
        return color;
    }

    public class Segment {

        int y;
        float xLeft;
        float xRight;
        ArrayList<Polygon> activePolygonsList;
        Color color;

        public Segment(int y, float xLeft, float xRigth, ArrayList<Polygon> activePolygonsList) {
            this.y = y;
            this.xLeft = xLeft;
            this.xRight = xRigth;
            this.activePolygonsList = activePolygonsList;
            this.color = paintVisibleWalls((xLeft + xRigth) / 2, y, activePolygonsList);

        }
    }

 
}
