/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAlgorithm;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * ScreenBuffer
 * @author Oskar Slyk
 * @title MyView
 * @target Politechnika Warszawska (OKNO)
 *
 */


public class ScreenBuffer {
   Color[][] screen;
    int width;
    int height;
    

    public ScreenBuffer(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.screen = new Color[height][width];
        for (int y = 0; y < height ; y++) {
            for (int x = 0; x < width ; x++) {
                screen[y][x] = backgroundColor;
            }
        }
    }     

    public void paint(int y, int xMin, int xMax, Color color) {
        for (int x = xMin ; x <= xMax; x++) {
            screen[y][x] = color;
        }
    }
    
    public BufferedImage transformateToBufferedImage() {
        BufferedImage bufimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height ; y++) {
            for (int x = 0 ; x < width ; x++) {
                bufimg.setRGB(x, y, screen[y][x].getRGB());
            }
        }
        return bufimg;
    } 
}
