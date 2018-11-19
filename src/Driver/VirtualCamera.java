/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import MyAlgorithm.EliminationAlgorithm;
import MyAlgorithm.ScreenBuffer;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * Virtual Camera (observer)
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

// virtual observer init
public class VirtualCamera {
    Scene scene;                        // environment
    public double viewportDistance;     // viewport distance from observer
    double startingViewportDistance;    // starting viewport distance from observer
    ImageProjection imageProjection;

    public Camera camera;
    public PointOfView PointOfView;

    int height;
    int width;
    ArrayList<Edge3D> edges;

    static final double zoomingStep = 0.01;         // zoom (step by step - scale ratio)
    static final double translationStep = 0.5;      // translation (step by step - movement ratio)
    static final double rotationStep = 0.01;        // rotation (step by step - turn ratio)

    Color backgroundColor = Color.BLACK;            // background color

    public ScreenBuffer screen;                     // screenBuffer init

    // virtual observer - init
    public VirtualCamera(Scene scene, double viewPortDistance, int height, int width) {
        this.startingViewportDistance = viewPortDistance;
        this.scene = scene;
        this.viewportDistance = viewPortDistance;
        this.height = height;
        this.width = width;
    }

    // processing scene for every action by the user
    public void sceneProcessing() {
        
        ArrayList<Wall> Walls = new ArrayList<Wall>();
        for (Wall s : scene.Walls) {

            Point3D newPt1 = new Point3D(BasicMatrix.multiply(scene.mat.matrix, s.pt1.cooVector()));
            newPt1.normalise();
            Point3D newPt2 = new Point3D(BasicMatrix.multiply(scene.mat.matrix, s.pt2.cooVector()));
            newPt2.normalise();
            Point3D newPt3 = new Point3D(BasicMatrix.multiply(scene.mat.matrix, s.pt3.cooVector()));
            newPt3.normalise();
            Point3D newPt4 = new Point3D(BasicMatrix.multiply(scene.mat.matrix, s.pt4.cooVector()));
            newPt4.normalise();
            Wall newWll = new Wall(newPt1, newPt2, newPt3, newPt4, s.color);
            Walls.add(newWll);
        }

        // all ratios and values injection
        Walls = Scene.backfaceCulling(Walls);
        imageProjection = new ImageProjection(viewportDistance);
        Walls = imageProjection.projectWalls(Walls);
        camera = new Camera();
        Walls = camera.cutWallsToCamera(Walls);
        PointOfView = new PointOfView(height, width, camera);
        EliminationAlgorithm eliminationAlgorithm = new EliminationAlgorithm(PointOfView.edgesOnView, Walls, height, width, backgroundColor, viewportDistance, PointOfView);
        screen = eliminationAlgorithm.eliminate();
        
    }

    public ArrayList<Edge2D> getEdgesToDraw() {
        return this.PointOfView.getEdgesOnView();
    }

    public ScreenBuffer getScreenBuffer() {
        return this.screen;
    }


    // MOVEMENT SECTOR

    // Zooming up
    public void zoom() {
        this.viewportDistance += zoomingStep;
        sceneProcessing();

    }

    // Zooming down
    public void zoomDown() {
        if (this.viewportDistance > zoomingStep) {
            this.viewportDistance -= zoomingStep;
            sceneProcessing();
        }
    }

    // move to the left
    public void minusOXTranslation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.Translation_Matrix(-1 * translationStep, 0, 0), scene.mat.matrix);
        sceneProcessing();

    }

    // move to the right
    public void plusOXTranslation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.Translation_Matrix(1 * translationStep, 0, 0), scene.mat.matrix);
        sceneProcessing();

    }

    // backward movement
    public void minusOYTranslation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.Translation_Matrix(0, -1 * translationStep, 0), scene.mat.matrix);
        sceneProcessing();

    }

    // forward movement
    public void plusOYTranslation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.Translation_Matrix(0, 1 * translationStep, 0), scene.mat.matrix);
        sceneProcessing();

    }

    // downward movement
    public void minusOZTranslation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.Translation_Matrix(0, 0, -1 * translationStep), scene.mat.matrix);
        sceneProcessing();

    }

    // upward movement
    public void plusOZTranslation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.Translation_Matrix(0, 0, 1 * translationStep), scene.mat.matrix);
        sceneProcessing();

    }

    // rotation to the right
    public void plusOXRotation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.OX_Rotation_Matrix(rotationStep), scene.mat.matrix);
        sceneProcessing();
    }

    // rotation to the left
    public void minusOXRotation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.OX_Rotation_Matrix(-1 * rotationStep), scene.mat.matrix);
        sceneProcessing();
    }

    // forward rotation
    public void plusOYRotation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.OY_Rotation_Matrix(rotationStep), scene.mat.matrix);
        sceneProcessing();
    }

    // backward rotation
    public void minusOYRotation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.OY_Rotation_Matrix(-1 * rotationStep), scene.mat.matrix);
        sceneProcessing();
    }

    // rotation up
    public void plusOZRotation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.OZ_Rotation_Matrix(rotationStep), scene.mat.matrix);
        sceneProcessing();
    }

    // rotation down
    public void minusOZRotation() {
        scene.mat.matrix = BasicMatrix.multiply(BasicMatrix.OZ_Rotation_Matrix(-1 * rotationStep), scene.mat.matrix);
        sceneProcessing();
    }

    // resetting the settings
    public void transformationReset() {
        scene.mat.matrix = BasicMatrix.Identity_Matrix();
        this.viewportDistance = this.startingViewportDistance;
        sceneProcessing();
    } 
}
