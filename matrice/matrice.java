package matrice;

public class matrice {

    private int taille;
    private int [][] matrice;
    private final String data;
    private String binaryData;

    /* Constructeur simple pour récupérer la matrice
       et la taille de cette matrice depuis le main. */

    public matrice(String data)
    {
        System.out.println();
        this.data = data;
    }

    public int [][] getMatrice()
    {
        return matrice;
    }

    public void setTaille(int taille)
    {
        this.taille = taille;
    }

    public void setMatrice(int[][] matrice)
    {
        this.matrice = matrice;
    }

    /* Calcule la taille libre dans la matrice pour mettre nos données */

    public int calcDonnees(int t)
    {
        return (t*t) - (8*8*3) - ((t-16)*2);
    }

    /* Permet de moduler la taille de la matrice selon la longueur de la donnée
       que l'on veut encoder dans cette matrice.
       La plus petite matrice étant de taille 21*21 et la plus grande 177*177. */

    public int TailleMatrice()
    {
        int finalTaille = 21;

        while (binaryData.length() > calcDonnees(finalTaille))
        {
            if (finalTaille <= 177)
            {
                finalTaille += 4;
            }
            else
            {
                System.out.println("Taille de la donnée trop grande");
            }
        }

        return finalTaille;
    }

    /* Retourne en binaire sur 15 bits (toujours !!!) la longueur de la donnée que l'on encode */

    public String longueurDonnees()
    {
        new StringBuilder();
        StringBuilder dataLength = new StringBuilder(Integer.toBinaryString(SplitData().length() * 2));

        if (dataLength.length() != 15)
        {
            while(dataLength.length() != 15)
            {
                dataLength.insert(0, 0);
            }
        }

        return dataLength.toString();
    }

    /* Concatène la longueur de la donnée avec deux fois la donnée pour former
       la donnée finale que l'on mettra dans la matrice. */

    public void FinalDataEncoded()
    {
        binaryData = longueurDonnees() + SplitData() + SplitData();
        System.out.println(binaryData);
        System.out.println(binaryData.length());
        System.out.println(TailleMatrice());
    }

    /* Coupe la chaîne de caractère des données en bloc de 3 pour appliquer le
       code de Reed-Solomon sur tous ces blocs, cette partie du code va aussi
       gérer si la String n'est pas divisible par 3 pour pouvoir rajouter un bloc
       de 1 ou un bloc de 2 quand on ne peut pas rajouter le dernier bloc de 3.
       A chaque bloc de 3, on utilise le partie de code "Data" qui concatène nos
       données en binaires et ajoute 2 bloc de code correcteur, quand on a fini
       de traiter toute la String on peut renvoyer la grosse donnée finale qui
       prends tous les blocs (données + correcteurs) et les concatènes */

    public String SplitData()
    {
        int crs = 0;
        char [] DataArray = new char[data.length()];
        StringBuilder FinalData = new StringBuilder();

        for (int i=0; i < data.length(); i++)
        {
            DataArray[i] = data.charAt(i);
        }

        while (crs < DataArray.length)
        {
            StringBuilder tempData = new StringBuilder();

            if (DataArray.length %3 == 0)
            {
                for (int i=0; i<3; i++)
                {
                    tempData.append(DataArray[crs]);
                    crs += 1;
                }
                FinalData.append(Data(tempData.toString()));
            }

            else if (DataArray.length %3 == 1)
            {
                if (crs == DataArray.length - 1)
                {
                    tempData.append(DataArray[crs]);
                    crs += 1;
                    FinalData.append(Data(tempData.toString()));
                }
                else
                {
                    for (int i=0; i<3; i++)
                    {
                        tempData.append(DataArray[crs]);
                        crs += 1;
                    }
                    FinalData.append(Data(tempData.toString()));
                }
            }

            else
            {
                if (crs == DataArray.length - 2)
                {
                    tempData.append(DataArray[crs]);
                    tempData.append(DataArray[crs]);
                    crs += 2;
                    FinalData.append(Data(tempData.toString()));
                }
                else
                {
                    for (int i=0; i<3; i++)
                    {
                        tempData.append(DataArray[crs]);
                        crs += 1;
                    }
                    FinalData.append(Data(tempData.toString()));
                }
            }
        }
        return FinalData.toString();
    }

    public String Data(String data)
    {
        /* chaque donnée sera sur 7 bits, on a rajouter les 0 manquants dans
           la classe StringConvert */
        StringConvert DataBit = new StringConvert(data);

        // convertion String en bit
        String StringBit = DataBit.strToBinary();

        // convertion String en Ascii
        int [] StringAscii = DataBit.strToAscii();

        // création données pour code reed-solomon
        int add = 0;
        int addmult = 0;

        for (int i : StringAscii) {
            add += i;
        }

        for (int i = 0; i < StringAscii.length; i++)
        {
            addmult += (i+1)*StringAscii[i];
        }

        // Convertion String (tous le chiffre) en bit

        // L'addition
        StringBuilder finalAdd;
        StringToBinary addbin = new StringToBinary(add);
        finalAdd = new StringBuilder(addbin.StringEnBit());

        // Ici on s'assure que l'on est toujours sur 9 bits pour l'addition

        if (finalAdd.length() != 9)
        {
            while(finalAdd.length() != 9)
            {
                finalAdd.insert(0, 0);
            }
        }

        // L'addition avec coefficients
        StringBuilder finalAddMult;
        StringToBinary addmultbin = new StringToBinary(addmult);
        finalAddMult = new StringBuilder(addmultbin.StringEnBit());

        // Ici on s'assure que l'on est toujours sur 10 bits pour l'addition avec coefficients

        if (finalAddMult.length() != 10)
        {
            while (finalAddMult.length() != 10)
            {
                finalAddMult.insert(0, 0);
            }
        }

        StringBit += finalAdd;
        StringBit += finalAddMult;

        data = StringBit;

        return data;
    }

    /* Méthode permettant d'initialiser la matrice proprement avec
               des bits aléatoires pour le remplissage des données. */
    public void InitMatrice()
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

    public void MotifSensMatrice()
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

    public void PiloteDeTailleMatrice()
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

    /* Permet de remplir la matrice des données fournies */

    public void DonneesMatrice()
    {
        int cpt = 0;

        // Bloc de données milieu haut
        for (int i = 0; i < 8; i++)
        {
            for (int j = 8; j < taille-8; j++)
            {
                if (i != 6)
                {
                    if (cpt < binaryData.length())
                    {
                        matrice[i][j] = binaryData.charAt(cpt) - 48;
                        cpt++;
                    }
                    else
                    {
                        matrice[i][j] = 2;
                    }
                }
            }
        }

        // Bloc de données milieu gauche
        for (int i = 8; i < taille-8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (j != 6)
                {
                    if (cpt < binaryData.length())
                    {
                        matrice[i][j] = binaryData.charAt(cpt) - 48;
                        cpt++;
                    }
                    else
                    {
                        matrice[i][j] = 2;
                    }
                }
            }
        }

        // Bloc de données bas droite
        for (int i = 8; i < taille; i++)
        {
            for (int j = 8; j < taille; j++)
            {
                if (cpt < binaryData.length())
                {
                    matrice[i][j] = binaryData.charAt(cpt) - 48;
                    cpt++;
                }
                else
                {
                    matrice[i][j] = 2;
                }
            }
        }
    }

    /* Simple méthode pour afficher la matrice proprement. */

    public void AffichageMatrice()
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
