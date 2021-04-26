package matrice;

public class StringToBinary
{
    private final Integer valeur;

    public StringToBinary(Integer valeur)
    {
        this.valeur = valeur;
    }

    public String StringEnBit()
    {
        int newValeur = Integer.parseInt(String.valueOf(valeur));

        return Integer.toBinaryString(newValeur);
    }
}
