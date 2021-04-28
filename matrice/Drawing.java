package matrice;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Drawing extends JComponent
{
    private final int taille;
    private final int [][] matrice;
    private final int taillePixel;

    public Drawing(int w, int t, int[][] m)
    {
        taille = t;
        matrice = m;
        taillePixel = w /taille;
    }

    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D.Double[][] r3 = new Rectangle2D.Double[taille][taille];

        for (int i=0; i<taille; i++)
        {
            for (int j=0; j<taille; j++)
            {
                if(matrice[i][j]==0)
                {
                    g2d.setColor(new Color(255, 244, 144));
                    r3[i][j] = new Rectangle2D.Double(j*taillePixel,i*taillePixel,
                            taillePixel,taillePixel);
                    g2d.fill(r3[i][j]);
                }
                if (matrice[i][j]==1)
                {
                    g2d.setColor(new Color(250, 101, 101));
                    r3[i][j] = new Rectangle2D.Double(j*taillePixel,i*taillePixel,
                            taillePixel,taillePixel);
                    g2d.fill(r3[i][j]);
                }
                if(matrice[i][j]==2)
                {
                    g2d.setColor(new Color(144, 255, 242));
                    r3[i][j] = new Rectangle2D.Double(j*taillePixel,i*taillePixel,
                            taillePixel,taillePixel);
                    g2d.fill(r3[i][j]);
                }
            }
        }
    }
}
