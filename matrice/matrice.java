package matrice;

public class matrice {

    private final int taille;
    private final int [][] matrice;

    /* Constructeur simple pour récupérer la matrice
       et la taille de cette matrice depuis le main. */

    public matrice(int [][] matrice, int taille)
    {
        System.out.println("Création matrice");
        this.matrice = matrice;
        this.taille = taille;
    }


    /* Méthode permettant d'initialiser la matrice proprement avec
       des bits aléatoires pour le remplissage des données. */
    public void InitMatrice ()
    {
        for (int i = 0; i < taille; i++)
        {
            for (int j = 0; j < taille; j++)
            {
                matrice[i][j] = 2;
            }
        }
    }

    /* Méthode permettant de mettre les 3 carrés de positionnement
       de la matrice pour déterminer
       Dans quel sens la lire. */

    public void MotifSensMatrice ()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if ((i == 1 && j != 0 && j != 6) || (j == 1 && i != 0 && i != 6) || (i == 5 && j != 0 && j != 6) ||
                        (j == 5 && i != 0 && i != 6) || i == 7 || j == 7)
                {
                    matrice[i][j] = 0;
                }
                else
                {
                    matrice[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < 8; i++)
        {
            for (int j = taille - 8; j < taille; j++)
            {
                if ((i == 1 && j != taille - 7 && j != taille - 1) || (j == taille - 6 && i != 0 && i != 6)
                        || (i == 5 && j != taille - 7 && j != taille - 1) ||
                        (j == taille - 2 && i != 0 && i != 6) || i == 7 || j == taille - 8)
                {
                    matrice[i][j] = 0;
                }
                else
                {
                    matrice[i][j] = 1;
                }
            }
        }

        for (int i = taille - 8; i < taille; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if ((i == taille - 6 && j != 0 && j != 6) ||
                        (j == 1 && i != taille - 7 && i != taille - 1) ||
                        (i == taille - 2 && j != 0 && j != 6) ||
                        (j == 5 && i != taille - 7 && i != taille - 1) || i == taille - 8 || j == 7)
                {
                    matrice[i][j] = 0;
                }
                else
                {
                    matrice[i][j] = 1;
                }
            }
        }
    }

    /* Méthode permettant de faire les deux lignes qui
       alternent entre le Noir et le Blanc pour déterminer la taille
       des cellules. */

    public void PiloteDeTailleMatrice ()
    {
        for (int j = 8; j < taille-8; j++)
        {
            if (j%2 == 0)
            {
                matrice[6][j] = 1;
            }
            else
            {
                matrice[6][j] = 0;
            }
        }
        for (int i = 8; i < taille-8; i++)
        {
            if (i%2 == 0)
            {
                matrice[i][6] = 1;
            }
            else
            {
                matrice[i][6] = 0;
            }
        }
    }

    /* Simple méthode pour afficher la matrice proprement. */

    public void AffichageMatrice ()
    {
        for (int i=0; i<taille; i++)
        {
            for (int j=0; j<taille; j++)
            {
                System.out.print(matrice[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
