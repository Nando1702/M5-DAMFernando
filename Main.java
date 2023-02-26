
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    public static void main(String[] args) {
        int num = 40;

//vector de notes generades
        Integer[] notasExamen = new Integer[num];
        int max = 0;
        int min = 0;
        int indMaxNota, indMinNota;
        int postEval;

        //Genera notes random entre 1 i 10
        for (int i = 0; i < notasExamen.length; i++) {
            notasExamen[i] = (int) (Math.random() * 11);
        }
        //Es busca la mes gran
        postEval = notasExamen[0];
        for (int i = 1; i < notasExamen.length; i++) {
            int preEval = notasExamen[i];
            if (preEval < postEval) {
                min = preEval;
                postEval = notasExamen[i];
            }
        }
        //Es busca la mes petita
        postEval = notasExamen[0];
        for (int i = 1; i < notasExamen.length; i++) {
            int preEval = notasExamen[i];
            if (preEval > postEval) {
                max = preEval;
                postEval = notasExamen[i];
            }
        }

//Alumnes de la classe, con un contador basta 

//        int[] listaClase = new int[num];
//        for (int i = 1; i < num; i++) {
//            listaClase[i] = i + 1;
//        }

//LLista per a facilitar us de index
        List notes = Arrays.asList(notasExamen);
        indMinNota = notes.indexOf(min) + 1;
        indMaxNota = notes.indexOf(max) + 1;

        //Comprobem
        System.out.println("Mínim és: " + min);
        System.out.println("Màxim és: " + max);
        System.out.println("Index del mínim és : " + indMinNota);
        System.out.println("Index del màxim és : " + indMaxNota);
//    System.out.println("Lista de classe :" + Arrays.toString(listaClase));
        System.out.println("Array de Notes :" + notes);

        //generamos las notes  de las practicas "
        int[] notaPracticas = new int[num];
        for (int i = 0; i < notaPracticas.length; i++) {
            notaPracticas[i] = (int) (Math.random() * 11);
        }
        //qualificacions
        float[] notaFinal = new float[num];
        for (int i = 0; i < notasExamen.length; i++) {
            notaFinal[i]
                    = (((float) notasExamen[i]
                    + (float) notaPracticas[i])
                    / 2);
        }
        
        System.out.println("Práctiques      :" + Arrays.toString(notaPracticas));
        System.out.println("Qualificacions :" + Arrays.toString(notaFinal));

        //estadística de qualif
        float[] estadistica = new float[10];

        for (int i = 0; i < 10; i++) {
            float count = 0;
            float sum = 0;
            for (int j = 0; j < notasExamen.length; j++) {
                if ((i < notaFinal[j]) && ((i + 1) >= notaFinal[j])) {
                    sum += notaFinal[j];
                    count += 1;
                }
            }
            if (count != 0) {
                estadistica[i] = ((float) count / num);
            } else {
                estadistica[i] = 0;
            }
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tram <="
                    + (i + 1) + " = "
                    + sol + "%");
        }
        //Aprovats i suspesos
        int[] aprovats = new int[num];
        int[] supesos = new int[num];
        int cAprovats = 0;
        int cSuspesos = 0;
        for (int i = 0; i < num; i++) {
            if (notaFinal[i] < 5) {
                aprovats[i] = i;
                cAprovats += 1;
            } else {
                supesos[i] = i;
                cSuspesos += 1;
            }
        }
        System.out.println("Relació d'aprovats per nº de llista: "
                + Arrays.toString(aprovats));
        System.out.println("Relació d'aprovats per nº de lista: "
                + Arrays.toString(supesos));

        //Resumen de aprovats i supesos
        int i = 0;
        int x = 0;
        int[] a = new int[cAprovats];
        int[] s = new int[cSuspesos];
        while (i < aprovats.length) {
            if (aprovats[i] != 0) {
                a[x] = aprovats[i];
                i++;
                x++;
            } else {
                i++;
            }
        }

        i = x = 0;
        while (i < supesos.length) {
            if (supesos[i] != 0) {
                s[x] = supesos[i];
                i++;
                x++;
            } else {
                i++;
            }
        }
        System.out.println("Resum aprovats per nº de llista: "
                + Arrays.toString(a));
        System.out.println("Resum suspesos per nº de llista: "
                + Arrays.toString(s));

    }

}
