package DvorakJSemestralProject12;

/**
 * 12. Program počítá korelační koeficient posloupnosti náhodných čísel
 *
 * @author Jakub Dvorak
 * @version 0.2 20/12/22
 */
public class DvorakJSemestralProject {

    private DvorakJSemestralProject() {

    }

    /**
     * Metoda pocita korelacni koeficient podle Pearsonova vzorce, pomoci
     * parametru a dilcich metod, kterym postupne predava hodnoty
     *
     * @param min, minimalni hodnota nahodneho cisla
     * @param max, maximalni hodnota nahodneho cisla
     * @param n, pocet nahodnych cisel posloupnosti
     * @param k, krok mezi dvojici nahodnych cisel matice
     * @return korelKoef, hodnota korelacniho koeficientu
     */
    public static double getKorelKoef(double min, double max, int n, int k) {
        double korelKoef;
        double[] a;
        double[][] aPair;
        double avrgX;
        double avrgY;
        double sumCitatel = 0;
        double sumJmenovatelX = 0;
        double sumJmenovatelY = 0;
        double sumJmenovatel;

        a = getRandomArray(min, max, n);
        aPair = getPairArray(k, a);
        avrgX = getAvrgOf(aPair, 0);
        avrgY = getAvrgOf(aPair, 1);

        for (int i = 0; i < aPair.length; i++) {
            sumCitatel += (aPair[i][0] - avrgX) * (aPair[i][1] - avrgY);
            sumJmenovatelX += Math.pow((aPair[i][0] - avrgX), 2);
            sumJmenovatelY += Math.pow((aPair[i][1] - avrgY), 2);
        }
        sumJmenovatel = Math.sqrt(sumJmenovatelX * sumJmenovatelY);
        korelKoef = sumCitatel / sumJmenovatel;

        return korelKoef;
    }

    /**
     * Metoda generuje posloupnost nahodnych n cisel
     *
     * @param min, minimalní hodnota nahodneho čisla
     * @param max, maximalni hodnota nahodneho čisla
     * @param n, počet nahodnych hodnot
     * @return posloupnost nahodnych cisel
     */
    public static double[] getRandomArray(double min, double max, int n) {
        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = (Math.random() * (0.01 + max - min) + min);
            //System.out.println(a[i]);
        }
        return a;
    }

    /**
     * Metoda generuje matici dvojic nahodnych cisel z posloupnosti b, a krokem
     * k
     *
     * @param k, krok mezi dvojicemi náhodných čísel
     * @param b, posloupnost náhodných čísel
     * @return matice dvojic náhodných čísel
     */
    public static double[][] getPairArray(int k, double[] b) {
        double[][] a = new double[b.length - k][2];

        for (int i = 0; i < a.length; i++) {
            a[i][0] = b[i];
            a[i][1] = b[i + k];
        }
        //MatrixTools.display(a);
        return a;
    }

    /**
     * Metoda vypocita prumernou hodnotu vsech hodnot ve sloupci j, z matice
     * aPair
     *
     * @param aPair, matice dvojic náhodných čísel
     * @param j, index sloupce
     * @return avrg, průměrná hodnota všech hodnot sloupce j
     */
    public static double getAvrgOf(double[][] aPair, int j) {
        double avrg = 0;

        for (int i = 0; i < aPair.length; i++) {
            avrg += aPair[i][j];
        }
        avrg = avrg / aPair.length;
        return avrg;
    }

}
