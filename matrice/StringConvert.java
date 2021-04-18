package matrice;
import java.util.*;

public class StringConvert
{
    private String s;

    public StringConvert(String s)
    {
        this.s = s;
    }

    // Convertis ma donnée (String) en binaire.
    public String strToBinary()
    {
        int n = s.length();
        String bitFinal = "";

        for (int i = 0; i < n; i++)
        {
            // convert each char to
            // ASCII value
            int val = Integer.valueOf(s.charAt(i));

            // Convert ASCII value to binary
            String bin = "";
            while (val > 0)
            {
                if (val % 2 == 1)
                {
                    bin += '1';
                }
                else
                    bin += '0';
                val /= 2;
            }
            bin = reverse(bin);

            bitFinal += bin;
        }
        return bitFinal;
    }

    /* convertis ma donnée (String) en tableau d'entiers contenant le code
       ascii de chaque caractère de mon String. */
    public int [] strToAscii()
    {
        int n = s.length();
        int [] AsciiFinal = new int [n];

        for (int i = 0; i < n; i++)
        {
            // convert each char to
            // ASCII value
            int val = Integer.valueOf(s.charAt(i));

            AsciiFinal[i] = val;
        }
        return AsciiFinal;
    }

    // Renverse ma donnée binaire dans le bon sens.
    public String reverse(String input)
    {
        char[] a = input.toCharArray();
        int l, r = 0;
        r = a.length - 1;

        for (l = 0; l < r; l++, r--)
        {
            // Swap values of l and r
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }
}

