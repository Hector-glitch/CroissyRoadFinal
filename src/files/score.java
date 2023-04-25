package files;

import constants.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class score {
    /**
     * Guarda la puntuació del jugador en un fitxer de puntuacions.
     */
    public static void saveScore() {
        System.out.println("Introdueix el teu nom per guardar la puntuacio:");
        Scanner teclat = new Scanner(System.in);
        String name = teclat.nextLine();
        try {
            FileWriter writer = new FileWriter("src/files/score.txt", true);
            writer.write(name + ": " + Constants.getScore() + "\n");
            writer.close();
            ordenarPuntuacions("src/files/score.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ordena les puntuacions del fitxer especificat.
     * Les puntuacions són llegides des del fitxer, sumades per cada jugador i ordenades per puntuació de manera descendent.
     * A continuació, es mostra la llista de puntuacions ordenada per pantalla.
     *
     * @param nomFitxer Nom del fitxer de puntuacions
     */
    public static void ordenarPuntuacions(String nomFitxer) {
        Map<String, Integer> puntuacions = new TreeMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomFitxer));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] dades = linea.split(":");
                if (dades.length >= 2) {
                    String nomJugador = dades[0].trim();
                    int puntuacio = Integer.parseInt(dades[1].trim());

                    if (puntuacions.containsKey(nomJugador)) {
                        puntuacions.put(nomJugador, puntuacions.get(nomJugador) + puntuacio);
                    } else {
                        puntuacions.put(nomJugador, puntuacio);
                    }
                } else {
                    System.out.println("Error: Format de línia incorrecte: " + linea);
                }
            }
            br.close();

            List<Map.Entry<String, Integer>> llistaOrdenada = new ArrayList<>(puntuacions.entrySet());
            Collections.sort(llistaOrdenada, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> entrada1, Map.Entry<String, Integer> entrada2) {
                    return entrada2.getValue().compareTo(entrada1.getValue());
                }
            });

            System.out.println("[LLISTA DE PUNTUACIONS]");
            for (Map.Entry<String, Integer> entrada : llistaOrdenada) {
                System.out.println(entrada.getKey() + ": " + entrada.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
