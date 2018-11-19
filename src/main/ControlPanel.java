/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Driver.VirtualCamera;
import GUI.PanelWindow;

/**
 *
 * Control Panel
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class ControlPanel {
     PanelWindow picture;
    VirtualCamera virtualCamera;
    boolean drawEdges = false;

    public ControlPanel(PanelWindow picture, VirtualCamera virutalCamera) {
        this.picture = picture;
        this.virtualCamera = virutalCamera;
    }

    public void zoom() {
        this.virtualCamera.zoom();
        this.drawThePicture();
    }

    public void zoomDown() {
        this.virtualCamera.zoomDown();
        this.drawThePicture();
    }

    public void minusOXTranslation() {
        this.virtualCamera.minusOXTranslation();
        this.drawThePicture();
    }

    public void plusOXTranslation() {
        this.virtualCamera.plusOXTranslation();
        this.drawThePicture();
    }

    public void minusOYTranslation() {
        this.virtualCamera.minusOYTranslation();
        this.drawThePicture();
    }

    public void plusOYTranslation() {
        this.virtualCamera.plusOYTranslation();
        this.drawThePicture();
    }

    public void minusOZTranslation() {
        this.virtualCamera.minusOZTranslation();
        this.drawThePicture();
    }

    public void plusOZTranslation() {
        this.virtualCamera.plusOZTranslation();
        this.drawThePicture();
    }

    public void plusOXRotation() {
        this.virtualCamera.plusOXRotation();
        this.drawThePicture();
    }

    public void minusOXRotation() {
        this.virtualCamera.minusOXRotation();
        this.drawThePicture();
    }

    public void plusOYRotation() {
        this.virtualCamera.plusOYRotation();
        this.drawThePicture();
    }

    public void minusOYRotation() {
        this.virtualCamera.minusOYRotation();
        this.drawThePicture();
    }

    public void plusOZRotation() {
        this.virtualCamera.plusOZRotation();
        this.drawThePicture();
    }

    public void minusOZRotation() {
        this.virtualCamera.minusOZRotation();
        this.drawThePicture();
    }

    public void transformationReset() {
        this.virtualCamera.transformationReset();
        this.drawThePicture();
    }
    
    public void drawEdgesOnOff() {
        this.drawEdges = ! this.drawEdges;
        this.drawThePicture();
    }
    public void drawThePicture() {
        this.picture.drawBufferedImage(this.virtualCamera.getScreenBuffer().transformateToBufferedImage());
        if (drawEdges) {
            this.picture.drawEdges(virtualCamera.getEdgesToDraw());
        }  
    }


    public static void waitMiliSec(long s) {
        try {
            Thread.currentThread().sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
