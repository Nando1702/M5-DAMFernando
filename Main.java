
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pkg_utilitats.Metodos;

class Main {

    public static void main(String[] args) {
        final int num = 40;

//vector de notes generades
        Integer[] notasExamen;
        Integer[] notasPractica;
        int max;
        int min;
        int indMaxNota, indMinNota;

// Genera notes random entre 1 i 10
        notasExamen = Metodos.generarNotas(num);
        notasPractica = Metodos.generarNotas(num);

//Es busca la mes gran
        max = Metodos.buscarNota(notasExamen, "max");

        //Es busca la mes petita
        min = Metodos.buscarNota(notasExamen, "min");

//Alumnes de la classe, con un contador basta 
//LLista per a facilitar us de index
        List notes = Arrays.asList(notasExamen);

        //Comprobem
        System.out.println("La nota minima ha sido:  " + min);
        System.out.println("La nota maxima ha sido:  " + max);

        Metodos.impAlumnosMaxNota(Metodos.indiceNota(notasExamen, max), "la maxima");
        System.out.println("");
        Metodos.impAlumnosMaxNota(Metodos.indiceNota(notasExamen, min), "la minima");

// generamos qualificacions
        float[] notaFinal = Metodos.notaFinals(notasExamen, notasPractica);

//        System.out.println("\n");
//        Metodos.impNotas(notasExamen, "el examen");
//        System.out.println("\n");
//        Metodos.impNotas(notasPractica, "las practicas");

        System.out.println("");
        Metodos.impNotas(notasExamen, notasPractica, notaFinal);
        //estadística de qualif
        System.out.println("");
        float[] estadistica = Metodos.estadisticaNotas(notaFinal);
        Metodos.impEstadistica(estadistica);

        //Aprovats i suspesos
        ArrayList<Integer> aprovats = Metodos.auxNotas(notaFinal, 10, 5);
        ArrayList<Integer> suspendidos = Metodos.auxNotas(notaFinal, 5, 0);

        System.out.println("");
        Metodos.impNotas(aprovats, "aprovado");
        Metodos.impNotas(suspendidos, "suspendido");

    }

}
