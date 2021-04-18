package com.company;
import matrice.*;

public class Main {

    public static void main(String[] args)
    {
        // variables pour utiliser la classe
        int taille = 21;
        int [][] m = new int [taille][taille];

        // constructeur de base
        matrice matrice1 = new matrice(m, taille);
        StringConvert test = new StringConvert("pukito");

        // méthodes pour la construction de la matrice
        matrice1.InitMatrice();
        matrice1.MotifSensMatrice();
        matrice1.PiloteDeTailleMatrice();
        matrice1.AffichageMatrice();

        // convertion String en bit
        String StringBit;
        StringBit = test.strToBinary();
        System.out.println(StringBit);

        // convertion String en Ascii
        int [] StringAscii;
        StringAscii = test.strToAscii();

        for (int i = 0; i < StringAscii.length; i++)
        {
            System.out.println(StringAscii[i]);
        }
    }
}
