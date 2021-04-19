package com.company;
import matrice.*;

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
    }
}
