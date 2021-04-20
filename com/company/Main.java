package com.company;
import matrice.*;
import javax.swing.JFrame;
import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
        // variables pour utiliser la classe
        int taille = 21;
        int [][] m = new int [taille][taille];

        // constructeur de base
        matrice matrice1 = new matrice(m, taille, "pukito22");

        // méthodes pour la construction de la matrice
        matrice1.InitMatrice();
        matrice1.MotifSensMatrice();
        matrice1.PiloteDeTailleMatrice();
        matrice1.DonneesMatrice();
        matrice1.AffichageMatrice();
        matrice1.SplitData();

        // graphisme
        int [][] matriceCouleur = new int [taille][taille];
        matriceCouleur = matrice1.getMatrice();
        int w = 525;
        int h = 525;

        JFrame f = new JFrame();
        Drawing d = new Drawing(w,h,taille,matriceCouleur);
        f.setSize(w,h);
        f.setTitle("Qr code");
        f.add(d);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
