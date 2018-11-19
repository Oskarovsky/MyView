/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Driver.Scene;
import Driver.ItemWizard;
import Driver.VirtualCamera;
import GUI.KeyboardWindow;
import GUI.MainWindow;
import GUI.PanelWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import javax.swing.JTextArea;

/**
 *
 * MAIN CLASS
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class OskarroCity {

    // CONST

    // window size
    static final int Width = 800;
    static final int Height = 800;

    // background color
    static final Color backgroundColor = Color.BLACK;

    // lines color
    static final Color linesColor = Color.WHITE;

    // distance between elements and viewer
    static final double startingProjectionDistance = 1.2;

    public static void main(String[] args) {
        // APPs WINDOW
        MainWindow mainWindow = new MainWindow("Virtual CAM");

        // CONTROL PANEL
        KeyboardWindow keyboardWindow = new KeyboardWindow();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyboardWindow);
        String instruction = "MOTION OPTIONS: OX AXIS - A|D;  OY AXIS - W|S;  OZ AXIS - Q|E.    ROTATION: OX AXIS - L|J;  OY AXIS - I|K;  OZ AXIS - O|U.   ZOOM: +|- ";

        // Creating main scene
        Scene scene = ItemWizard.createScene();
        VirtualCamera vc = new VirtualCamera(scene, startingProjectionDistance, Height, Width);
        vc.sceneProcessing();

        // Implementation of the window panel
        PanelWindow picture = new PanelWindow(backgroundColor, linesColor, Width, Height, vc.getEdgesToDraw());
        picture.setSize(Width, Height);                 // window size injection
        JTextArea text= new JTextArea(instruction);     // text field injection
        text.setEditable(false);                        // uneditable text

        // Main window configuration
        mainWindow.getContentPane().add(text,BorderLayout.SOUTH);                   // Returns the contentPane object for this frame (text at the bottom of the window)
        mainWindow.setFocusable(true);                                              // Sets the focusable state of this Component to the specified value
        mainWindow.getContentPane().add(picture, BorderLayout.CENTER);              // Returns the contentPane object for this frame (picture in the center of the window)
        picture.init();

        // Control panel
        ControlPanel controller = new ControlPanel(picture, vc);
        keyboardWindow.setController(controller);
        mainWindow.pack();
        mainWindow.setSize(new Dimension(Width, Height));
        mainWindow.setVisible(true);
        controller.drawThePicture();
    }
    }
    

