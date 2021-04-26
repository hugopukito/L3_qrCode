package com.company;
import matrice.*;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args)
    {
        // constructeur en prenant que la donnée que l'on veut encoder
        matrice matrice1 = new matrice("https://www.google.fr/");

        // méthodes pour définir la bonne taille de la matrice
        matrice1.FinalDataEncoded();
        int taille = matrice1.TailleMatrice();
        int [][] m = new int [taille][taille];
        matrice1.setTaille(taille);
        matrice1.setMatrice(m);

        // méthodes pour la construction de la matrice
        matrice1.InitMatrice();
        matrice1.MotifSensMatrice();
        matrice1.PiloteDeTailleMatrice();
        matrice1.DonneesMatrice();
        matrice1.AffichageMatrice();

        // graphisme
        int [][] matriceCouleur;
        matriceCouleur = matrice1.getMatrice();
        int w = 525;
        int h = 525;

        JFrame f = new JFrame();
        Drawing d = new Drawing(w, taille,matriceCouleur);
        f.setSize(w,h);
        f.setTitle("Qr code");
        f.add(d);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
