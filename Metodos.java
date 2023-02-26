package pkg_utilitats;

import java.util.ArrayList;

public class Metodos {

    public static int buscarNota(Integer[] notas, String op) {

        int nota = notas[0];

        for (int i = 1; i < notas.length; i++) {

            switch (op) {
                case "max" -> {
                    if (notas[i] > nota) {

                        nota = notas[i];
                    }
                }
                case "min" -> {
                    if (notas[i] < nota) {

                        nota = notas[i];
                    }
                }

            }

        }

        return nota;
    }

    public static Integer[] generarNotas(int quantAlumnes) {

        Integer[] notas = new Integer[quantAlumnes];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = (int) (Math.random() * 11);
        }

        return notas;
    }

    public static float[] notaFinals(Integer[] examens, Integer[] practicas) {

        float[] notaFinal = new float[examens.length];

        for (int i = 0; i < examens.length; i++) {

            notaFinal[i]
                    = (((float) examens[i]
                    + (float) practicas[i])
                    / 2);
        }

        return notaFinal;
    }

    public static float[] estadisticaNotas(float[] notaFinal) {

        float[] estadistica = new float[10];

        for (int i = 0; i < 10; i++) {

            int count = 0;
            float sum = 0;
            for (int j = 0; j < notaFinal.length; j++) {

                if ((i < notaFinal[j]) && ((i + 1) >= notaFinal[j])) {

                    sum += notaFinal[j];
                    count += 1;
                }
            }

            if (count != 0) {
                estadistica[i] = ((float) count / notaFinal.length);
            } else {
                estadistica[i] = 0;
            }

        }

        return estadistica;
    }

    public static void impEstadistica(float[] estadistica) {

        for (int i = 0; i < estadistica.length; i++) {

            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;

            System.out.println("Estadística nota tram <="
                    + (i + 1) + " = "
                    + sol + "%");
        }

    }

    public static ArrayList<Integer> auxNotas(float[] notaFinal, int max, int min) {

        ArrayList<Integer> notas = new ArrayList();

        for (int i = 0; i < notaFinal.length; i++) {
            if (notaFinal[i] >= min && notaFinal[i] < max) {
                notas.add(i);
            }

        }

        return notas;
    }



}
