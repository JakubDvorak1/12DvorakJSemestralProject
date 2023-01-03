package DvorakJSemestralProject12;

import java.util.Random;

public final class MatrixTools {

    private MatrixTools() {

    }

    public static int[][] generateRandom(int m, int n, int min, int max) {
        Random rd = new Random();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rd.nextInt((max - min) + 1) + min; //max inclusive
            }
        }
        return matrix;
    }

    public static double[][] generateRandomDouble(int m, int n, int min, int max) {
        Random rd = new Random();
        double[][] matrix = new double[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rd.nextInt((max - min) + 1) + min; //max inclusive
            }
        }
        return matrix;
    }

    public static String toString(double[][] matrix) {
        String s = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                s = s + String.format("%6.2f", matrix[i][j]);
            }
            s = s + "\n";
        }
        return s;
    }

    public static String toString1(double[][] matrix) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                s.append(String.format("%6.2f", matrix[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void display(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.format("%6.2f", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    //pretizeni metody, overload
    public static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.format("%6d", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public static int[][] soucet(int[][] matice1, int[][] matice2) {
        int[][] vyslednaMatice = new int[matice1.length][matice1[0].length];
        for (int i = 0; i < vyslednaMatice.length; i++) {
            for (int j = 0; j < vyslednaMatice[i].length; j++) {
                vyslednaMatice[i][j] = matice1[i][j] + matice2[i][j];

            }

        }
        return vyslednaMatice;
    }

    public static double getMaxAbsValue(double[][] a) {
        double maxAbsValue = 0;

        //if(a.length==0||a[0].length==0) return 0; //lepsi vyhazovat vyjimku nez nulu
        //zatim jde o nevalidni stav a to je v druhem semestru
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (Math.abs(a[i][j]) > maxAbsValue) {
                    maxAbsValue = Math.abs(a[i][j]);
                }
            }
        }
        return maxAbsValue;
    }

    public static void prevodNaNormovanyTvar(double[][] a) {
        double maxAbsValue = getMaxAbsValue(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = a[i][j] / maxAbsValue;
            }
        }
    }

    public static double sumOfArrayRow(double[][] a, int row) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[row][i];
        }
        return sum;
    }
    
    public static double sumOfArrayColumn(double[][] a, int column) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][column];
        }
        return sum;
    }
    
    public static double sumOfArrayMainDiag(double[][] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];
        }
        return sum;
    }
    
    public static double sumOfArraySecondDiag(double[][] a) {
        double sum = 0;
        for (int i = 0; i < a.length ; i++) {
            for(int j = 0; j < a[i].length; j++){
                if((i+j==a.length-1))sum += a[i][j];   
            }
        }
        return sum;
    }

    public static boolean isArrayStochastic(double[][] a) {
        //boolean isStochastic = true;
        double sumRow;
        for (int i = 0; i < a.length; i++) {
            sumRow = sumOfArrayRow(a, i);
            for (int j = 0; j < a[i].length; j++) {
                if (sumRow != 1 && a[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isSymetricHorizontal(double[][] a) {
        //if((a.length % 2) != 0) return false;
        for (int i = 0; i < a.length / 2; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != a[a.length - i - 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSymetricVertical(double[][] a) {
        //if((a[0].length % 2) != 0) return false; // teoreticky, pokud by bylo zadano i%2!=0
        // vynecha to prostredni radek a budo porovnany pod a nad nim... teoreticky... u diagonal to tak je
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length / 2; j++) {
                if (a[i][j] != a[i][a[i].length - j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSymetricMainDiag(double[][] a) {
        //diagonala ma vzdy stejne "i" a "j"
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isSymetricSecondDiag(double[][] a) {
        //diagonala ma vzdy stejne "i" a "j"
        /*for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }*/
        return true;
    } 
        //Domaci ukol
    private static boolean isSumOfRowColumnDiagEqual(double[][] a){
        
        double [] rows = new double [a.length];
        double [] columns = new double [a.length];
        double mDiag = sumOfArrayMainDiag(a);
        double sDiag = sumOfArraySecondDiag(a);
        
        for(int i = 0; i<a.length; i++){
            rows[i] = sumOfArrayRow(a,i);
        }
            
        for(int i = 0; i<a[0].length; i++){
            columns[i] = sumOfArrayColumn(a,i);    
        }
        
        return true;
    } //na tohle se podivat a dod2lat to!!!!! bude to i na gitu (cast), zpetne si myslim že zadani chtelo metodu pro kazde zvlast ne takhle

    public static void main(String[] args) {
//        int[][] myMatrix = generateRandom(3,4,10,20);
//        display(myMatrix);
//        System.out.println();
//        double[][] yourMatrix = {{2.1, 5.3, 1.1}, //staticky inicializator
//                                 {15.7, 1.0, 6.1}};
//        String s = toString(yourMatrix);
//        System.out.println(s);
//        display(yourMatrix);
        int[][] matrix1 = generateRandom(2, 2, 0, 11);
        display(matrix1);
        System.out.println("");
        int[][] matrix2 = generateRandom(2, 2, 0, 21);
        display(matrix2);
        System.out.println("");
        int[][] finalMatrix = soucet(matrix1, matrix2);
        display(finalMatrix);
    }
}
