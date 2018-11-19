/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import main.ControlPanel;

/**
 *
 * Keyboard Control Panel
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class KeyboardWindow implements KeyEventDispatcher{

      ControlPanel controller;

    public void setController(ControlPanel controller) {
        this.controller = controller;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {   

        if (e.getKeyChar() == '+') {
            controller.zoom();

        }
        if (e.getKeyChar() == '-') {
            controller.zoomDown();
        }
        if (e.getKeyChar() == 'd') {
            controller.minusOXTranslation();
        }
        if (e.getKeyChar() == 'a') {
            controller.plusOXTranslation();
        }
        if (e.getKeyChar() == 'q') {
            controller.plusOYTranslation();
        }
        if (e.getKeyChar() == 'e') {
            controller.minusOYTranslation();
        }
        if (e.getKeyChar() == 'w') {
            controller.minusOZTranslation();
        }
        if (e.getKeyChar() == 's') {
            controller.plusOZTranslation();
        }
        if (e.getKeyChar() == 'l') {
            controller.minusOYRotation();
        }     
        if (e.getKeyChar() == 'j') {
            controller.plusOYRotation();
        }
        if (e.getKeyChar() == 'i') {
            controller.plusOXRotation();
        }     
        if (e.getKeyChar() == 'k') {
            controller.minusOXRotation();
        }
        if (e.getKeyChar() == 'o') {
            controller.plusOZRotation();
        }
        if (e.getKeyChar() == 'u') {
            controller.minusOZRotation();
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            controller.transformationReset();
        }
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            controller.drawEdgesOnOff();
        }
        return false;
    }
}

