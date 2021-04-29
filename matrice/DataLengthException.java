package matrice;

public class DataLengthException extends Exception
{
    public DataLengthException(int t)
    {
        System.out.println("La longueur de votre donnée est trop longue.");
        System.out.println("cela donne une matrice de: "+t+"x"+t+" " +
                "alors que la taille max est de 177x177.");
    }
}
