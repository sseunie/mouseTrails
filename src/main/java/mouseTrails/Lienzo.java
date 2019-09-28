package mouseTrails;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 * @author Stefany Martín Socas
 * @author Santiago Martínez Willi
 */
public class Lienzo extends JPanel {
    private static Color backgroundColor;
    private static Color brushColor;
    private static int width;
    
    static Point2D[] myPoints = new Point2D[5];
    
    public Lienzo() {
        backgroundColor = Color.WHITE;
        brushColor = Color.BLACK;
        width = 8;
        
    }
    
    @Override
    public void paintComponent(Graphics g) {             
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        this.setBackground(backgroundColor);
        this.setForeground(brushColor);
        
        int numberOfPoints = myPoints.length;
        
        int px[] = new int[numberOfPoints];
        int py[] = new int[numberOfPoints];
        
        for (int i = 0; i < numberOfPoints; i++) {
            if(myPoints[i] == null) break;
            px[i] = (int) myPoints[i].getX();
            py[i] = (int) myPoints[i].getY();
            g2d.fillOval(px[i],py[i], width, width);
        }
    }
    
    public static void changeBrushColor(String newColor) {
        switch (newColor.toLowerCase()) {
            case "negro":
                brushColor = Color.BLACK;
                break;
            case "azul":
                brushColor = Color.BLUE;
                break;
            case "rojo":
                brushColor = Color.RED;
                break;
            case "verde":
                brushColor = Color.GREEN;
                break;
            default:
                break;
        }
    }
    
    public static void changeBackgroundColor(String newColor) {
        switch (newColor.toLowerCase()) {
            case "blanco":
                backgroundColor = Color.WHITE;
                break;
            case "gris":
                backgroundColor = Color.GRAY;
                break;
            case "cian":
                backgroundColor = Color.CYAN;
                break;
            default:
                break;
        }
    }
}
