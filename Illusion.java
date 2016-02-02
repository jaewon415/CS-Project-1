// Jaewon Chang, CSE 142,
//Winter 2014, Section EG
// Programming Assignment #3 Part B, 28st/January/2014
//
// This program's behavior drawing a Illusion art with circles and square.

import java.awt.*; 

public class Illusion {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(500, 400);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.GRAY);
      
      drawSingle(g, 0, 0, 90, 3);
      drawSingle(g, 120, 10, 90, 3);
      drawSingle(g, 250, 50, 80, 5);
      drawGrid(g, 10, 120, 100, 10, 2);
      drawGrid(g, 350, 20, 40, 5, 3);
      drawGrid(g, 230, 160, 50, 5, 4);
   }
   
 //This method draws single
circle that exists on the top.
 public static void drawSingle(Graphics g, int x, int y, int size, int
figure) {
      int gap = size / figure / 2;
      g.setColor(Color.RED);
      g.fillOval(x, y, size, size);
      for (int i = 0; i < figure; i++) {
         g.setColor(Color.BLACK);
 g.drawOval(x + gap * i, y + gap * i, size - 2 * gap * i, size - 2 *
gap * i);
      }
      drawDiamond(g, x, y, size);
   }
   
//This method draws multiple of circle according to rows and column
 public static void drawGrid(Graphics g, int x, int y, int size, int figure, int column) {
      int gap = size / figure / 2;
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(x, y, column * size, column * size);
      g.setColor(Color.RED);
      g.drawRect(x, y, size * column, size * column);
      for (int j = 0; j < column; j++) {
         for (int k = 0; k < column; k++) {
            g.setColor(Color.RED);
            g.fillOval(x + size * k, y + size * j, size, size);
            for (int i = 0; i < figure; i++) {
               g.setColor(Color.BLACK);
 g.drawOval(x + size * k + gap * i, y + size * j + gap * i,
                          size - 2 * gap * i, size - 2 * gap * i);
            }
            drawDiamond(g, x + size * k, y + size * j, size);
         }
      }
   }
   
  //This method draws the square inside the cirlce
 public static void drawDiamond(Graphics g, int x, int y, int size) {
      g.setColor(Color.BLACK);
      g.drawLine(x + size / 2, y, x + size, y + size / 2);
      g.drawLine(x + size, y + size / 2, x + size / 2, y + size);
      g.drawLine(x + size / 2, y + size, x, y + size / 2);
      g.drawLine(x, y + size / 2, x + size / 2, y);
   }
}
