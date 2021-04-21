package matrice;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Drawing extends JComponent
{
    private int width;
    private int height;
    private int taille;
    private final int [][] matrice;

    public Drawing (int w, int h, int t, int [][] m)
    {
        width = w;
        height = h;
        taille = t;
        matrice = m;
    }

    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(new Color(100,149,237));
        g2d.fill(r);
        /*Rectangle2D.Double r1 = new Rectangle2D.Double(0,0,50,50);
        g2d.setColor(new Color(167,24,238));
        g2d.fill(r1);
        Rectangle2D.Double r2 = new Rectangle2D.Double(50,0,50,50);
        g2d.setColor(new Color(56, 238, 24));
        g2d.fill(r2);*/

        Rectangle2D.Double r3 [][] = new Rectangle2D.Double[taille][taille];

        for (int i=0; i<taille; i++)
        {
            for (int j=0; j<taille; j++)
            {
                if(matrice[i][j]==0)
                {
                    g2d.setColor(new Color(255, 244, 144));
                    r3[i][j] = new Rectangle2D.Double(j*25,i*25,25,25);
                    /*(10*50+i,10*50+j,50,50)*/
                    g2d.fill(r3[i][j]);
                }
                if (matrice[i][j]==1)
                {
                    g2d.setColor(new Color(250, 101, 101));
                    r3[i][j] = new Rectangle2D.Double(j*25,i*25,25,25);
                    /*(10*50+i,10*50+j,50,50)*/
                    g2d.fill(r3[i][j]);
                }
                if(matrice[i][j]==2)
                {
                    g2d.setColor(new Color(144, 255, 242));
                    r3[i][j] = new Rectangle2D.Double(j*25,i*25,25,25);
                    /*(10*50+i,10*50+j,50,50)*/
                    g2d.fill(r3[i][j]);
                }
            }
        }
    }
}
