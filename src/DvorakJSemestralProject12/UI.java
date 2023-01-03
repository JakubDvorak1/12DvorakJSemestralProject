package DvorakJSemestralProject12;

import java.util.Scanner;

/**
 * 12. Program počítá korelační koeficient posloupnosti náhodných čísel
 *
 * @author Jakub Dvorak
 * @version 0.2 22/12/22
 */
public class UI {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean konecProgramu = false;
        int volba;
        //Volani metod na zaklade vyberu uzivatele
        while (!konecProgramu) {
            vypisMenu();
            volba = nactiVolbu();
            switch (volba) {
                case 0:
                    konecProgramu = true;
                    break;

                case 1:
                    semestralniPrace();
                    break;

                case 2:
                    ChristmasDvorakJakub.bambulka();
                    break;
                default:
                    System.out.println("Chybne zadana volba.");
            }
        }
        System.out.println("Koncim ...");
    }

    private static void vypisMenu() {
        System.out.println("");
        System.out.println("1. Semestralni prace (12)");
        System.out.println("2. Vanocni uloha");
        System.out.println("0. Konec programu");
    }

    private static int nactiVolbu() {
        System.out.print("Zadej volbu: ");
        int volba = sc.nextInt();
        return volba;
    }

    private static boolean nactiVolbu2() {
        char aN = 'o';

        while (Character.toLowerCase(aN) != 'a' && Character.toLowerCase(aN) != 'n') {
            System.out.println("Chcete pokracovat ve zpracovani? (a/n)");
            aN = sc.next().charAt(0);
        }
        if (Character.toLowerCase(aN) == 'n') {
            return true;                    
        }

        return false;
    }

    private static void semestralniPrace() {
        double min, max;
        int n, k;

        double korelKoef;
        //Metoda pro komunikaci s uzivatelem a inicializaci hodnot
        while (!nactiVolbu2()) {

            System.out.println("Zadejte:");
            System.out.println("Dolni mez intervalu:");
            min = sc.nextDouble();
            System.out.println("Horni mez intervalu:");
            max = sc.nextDouble();
            System.out.println("Pocet generovanych hodnot:");
            n = sc.nextInt();
            System.out.println("Delku kroku pro vytvareni dvojic:");
            k = sc.nextInt();

            if(min >= max || k > n || k < 0 || n <= 0){
                System.out.println("Zadane hodnoty nejsou validni pro vypocitani korelacniho koeficientu");
                System.out.println("(Nesmi platit min >= max, k > n, n <= 0)");
            }
            
            korelKoef = DvorakJSemestralProject.getKorelKoef(min, max, n, k);           
                                
            System.out.printf("Vypocteny korelacni koeficient ma hodnotu: %.3f%n", korelKoef);
        }
    }
}
