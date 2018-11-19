/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Driver.Edge2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * Panel Window
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */

public class PanelWindow extends JPanel {
   Color backgroundColor;
    Color linesColor;
    int width;
    int height;
    public ArrayList<Edge2D> edgesToDraw;
    BufferedImage buffer;
    boolean rysujBufor = true;  

    public PanelWindow(Color backgroundColor, Color linesColor, int width, int height, ArrayList<Edge2D> edgesToDraw) throws HeadlessException {
        this.backgroundColor = backgroundColor;
        this.linesColor = linesColor;
        this.width = width;
        this.height = height;
        this.edgesToDraw = edgesToDraw;
        init();
    }

    public void init() {
        setBackground(backgroundColor);
        setForeground(backgroundColor);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (rysujBufor) {
            drawBuffer(g);
            drawEdges(g);
        } else {
            drawEdges(g);
        }
        
        

    }

    public ArrayList<Edge2D> getEdgesToDraw() {
        return edgesToDraw;
    }

    public void setEdgesToDraw(ArrayList<Edge2D> edgesToDraw) {
        this.edgesToDraw = edgesToDraw;
    }

    public void drawEdges(Graphics g) {
        for (Edge2D kr : edgesToDraw) {
            
            g.drawLine(kr.point1.x, kr.point1.y, kr.point2.x, kr.point2.y);
        }
    }
    
    public void drawEdges(ArrayList<Edge2D> krw) {
        this.edgesToDraw = krw;
        this.repaint();
    }
    
    public void drawBufferedImage(BufferedImage bufimg) {
        this.edgesToDraw = new ArrayList<Edge2D>();
        this.buffer  = bufimg;
        this.repaint();
        
    }
    
    
    
    public void drawBuffer(Graphics g) {
        g.drawImage(buffer, 0, 0, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    } 
}

   
