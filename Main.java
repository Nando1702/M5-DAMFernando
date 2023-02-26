
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
        indMinNota = notes.indexOf(min) + 1;
        indMaxNota = notes.indexOf(max) + 1;

        //Comprobem
        System.out.println("Mínim és: " + min);
        System.out.println("Màxim és: " + max);
        System.out.println("Index del mínim és : " + indMinNota);
        System.out.println("Index del màxim és : " + indMaxNota);

        System.out.println("Array de Notes :" + notes);

 
// generamos qualificacions

        float[] notaFinal = Metodos.notaFinals(notasExamen, notasPractica);
        
        System.out.println("Práctiques      :" + Arrays.toString(notasPractica));
        System.out.println("Qualificacions :" + Arrays.toString(notaFinal));

        //estadística de qualif
        
        float[] estadistica = Metodos.estadisticaNotas(notaFinal);
        Metodos.impEstadistica(estadistica);
        
           
        //Aprovats i suspesos
        ArrayList<Integer> aprovats = Metodos.auxNotas(notaFinal, 10, 5);
        ArrayList<Integer> suspendidos = Metodos.auxNotas(notaFinal, 5, 0);

        System.out.println("Relació d'aprovats per nº de llista: "
                + aprovats);
        System.out.println("Relació d'aprovats per nº de lista: "
                + suspendidos);


   
       
        
       

    }

}
