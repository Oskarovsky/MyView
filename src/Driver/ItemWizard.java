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
 * Item wizard
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// Solid creator
public class ItemWizard {
     ArrayList<Edge3D> edges;
    BasicMatrix mat;

    public ItemWizard() {
        edges = new ArrayList<Edge3D>();
        mat = new BasicMatrix(BasicMatrix.Identity_Matrix());
    }

    // creating all solids
    public static Scene createScene() {
        ArrayList<Edge3D> edges = new ArrayList<Edge3D>();
        BasicMatrix mat = new BasicMatrix(BasicMatrix.Identity_Matrix());
        Scene scene = new Scene(edges, mat);

        /*
        scene.addNewCuboid(-40, -10, 145, -30, 20, 150, Color.BLUE);
        scene.addNewCuboid(-35, -10, 105, -30, 20, 115, Color.GREEN);
        scene.addNewCuboid(15, -10, 125, 25, 20, 135, Color.RED);
        scene.addNewCuboid(10, -10, 145, 30, 20, 150, Color.YELLOW);
        scene.addNewCuboid(-5, -10, 125, 0, 20, 130, Color.CYAN);
        scene.addNewCuboid(-15, -10, 205, -1, 20, 220, Color.PINK);
        scene.addNewCuboid(-7, -10, 95, 10, 20, 100, Color.WHITE);
        scene.addNewCuboid(22, -10, 105, 30, 20, 110, Color.GRAY);
        scene.addNewCuboid(-10, -10, 155, 21, 20, 165, Color.MAGENTA);
        scene.addNewCuboid(5, -10, 170, 8, 20, 175, Color.WHITE);
        scene.addNewCuboid(33, -10, 185, 10, 20, 190, Color.ORANGE);
        scene.addNewCuboid(14, -10, 220, 17, 20, 225, Color.WHITE);
        */

        scene.addNewCuboid(-100, -10, 40, -95, 20, 50, Color.BLUE);
        scene.addNewCuboid(-100, -10, 80, -95, 20, 90, Color.BLUE);
        scene.addNewCuboid(-100, -10, 120, -95, 20, 130, Color.BLUE);
        scene.addNewCuboid(-100, -10, 160, -95, 20, 170, Color.BLUE);
        scene.addNewCuboid(-100, -10, 200, -95, 20, 210, Color.BLUE);

        scene.addNewCuboid(20, -10, 40, 25, 20, 45, Color.BLUE);
        scene.addNewCuboid(20, -10, 80, 25, 20, 85, Color.BLUE);
        scene.addNewCuboid(20, -10, 120, 25, 20, 125, Color.BLUE);
        scene.addNewCuboid(20, -10, 160, 25, 20, 165, Color.BLUE);
        scene.addNewCuboid(20, -10, 200, 25, 20, 205, Color.BLUE);

        scene.addNewCuboid(-80, -10, 200, -75, 20, 210, Color.BLUE);
        scene.addNewCuboid(-60, -10, 200, -55, 20, 210, Color.BLUE);
        scene.addNewCuboid(-40, -10, 200, -35, 20, 210, Color.BLUE);
        scene.addNewCuboid(-20, -10, 200, -15, 20, 210, Color.BLUE);
        scene.addNewCuboid(0, -10, 200, 5, 20, 210, Color.BLUE);






        // Z - do przodu/do tyłu
        // Y - do góry/do dołu
        // X - w lewo/w prawo


        return scene;
    }
}
