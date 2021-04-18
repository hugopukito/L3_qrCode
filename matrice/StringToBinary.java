package matrice;

public class StringToBinary
{
    private Integer valeur;

    public StringToBinary(Integer valeur)
    {
        this.valeur = valeur;
    }

    public String StringEnBit()
    {
        Integer newValeur = Integer.valueOf(String.valueOf(valeur));
        String chiffreBinaire=Integer.toBinaryString(newValeur.intValue());

        return chiffreBinaire;
    }
}
