package matrice;

public class StringConvert
{
    private final String s;

    public StringConvert(String s)
    {
        this.s = s;
    }

    // Convertis ma donnée (String) en binaire.
    public String strToBinary()
    {
        int n = s.length();
        StringBuilder bitFinal = new StringBuilder();

        for (int i = 0; i < n; i++)
        {
            // convert each char to
            // ASCII value
            int val = s.charAt(i);

            // Convert ASCII value to binary
            StringBuilder bin = new StringBuilder();
            while (val > 0)
            {
                if (val % 2 == 1)
                {
                    bin.append('1');
                }
                else
                    bin.append('0');
                val /= 2;
            }
            bin = new StringBuilder(reverse(bin.toString()));
            if (bin.length() != 7)
            {
                for (int j=0; j <= 7 - bin.length(); j++)
                {
                    bin.insert(0, 0);
                }
            }

            bitFinal.append(bin);
        }

        return bitFinal.toString();
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
            int val = s.charAt(i);

            AsciiFinal[i] = val;
        }
        return AsciiFinal;
    }

    // Renverse ma donnée binaire dans le bon sens.
    public String reverse(String input)
    {
        char[] a = input.toCharArray();
        int l, r;
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

