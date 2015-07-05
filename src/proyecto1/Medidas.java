package proyecto1;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Medidas{

    // nombres y apellidos obtenidos de http://www.generatedata.com

    static String nombres[] = {"Lilah", "Iona", "Ginger", "Kieran", "Uma", "Holmes", "Brandon", "Quinn",
            "Amela", "Emmanuel", "Evangeline", "Dillon", "Valentine", "Summer", "Carol",
            "Alan", "Rama", "Daryl", "Jada", "Mason", "Timothy", "Kaye", "Cherokee", "Katell",
            "Ruth", "Raphael", "Finn", "Dana", "Farrah", "Clementine", "Alfreda", "Kasper",
            "Emily", "Fleur", "Jena", "Zahir", "Julian", "Harrison", "Darius", "Kai", "Rafael",
            "Eden", "Jamal", "Hillary", "Pandora", "Cruz", "Jenette", "Keefe", "Maggie", "Justine",
            "Grant", "India", "Brett", "Jada", "Cairo", "Colorado", "Chantale", "Tara", "Clark",
            "Alika", "Hilel", "Myra", "Wing", "Dara", "Garrison", "Alvin", "Galvin", "Hilary",
            "Elton", "Zenaida", "Hiroko", "Paula", "Perry", "Ruby", "Charlotte", "Henry",
            "Astra", "Yasir", "Karleigh", "Penelope", "Thaddeus", "Wallace", "Anthony",
            "Kirestin", "Paul", "Uriel", "Leilani", "Guinevere", "Sopoline", "Hoyt", "Miranda",
            "Kuame", "Zane", "Meghan", "Odessa", "Preston", "Wayne", "Roary", "Bevis", "Kadeem"};

    static String apellidos[] = {"Mendoza", "Benton", "Kelly", "Payne", "Beard", "Edwards",
            "Adkins", "Gilbert", "Johnson", "Morales", "Tanner", "Wright", "Workman", "Hansen",
            "Bond", "Ayala", "Brady", "Perry", "Ford", "Thompson", "Russell", "Workman",
            "Tyler", "Houston", "Potter", "Webb", "Chang", "Ballard", "Osborne", "Dillard",
            "Williams", "Hooper", "Marsh", "Mayer", "Long", "Sosa", "Castro", "Santos",
            "Davis", "Conrad", "Graves", "Kennedy", "Oneal", "Santana", "Daugherty", "Blanchard",
            "Daniels", "Harrison", "Carrillo", "Walton", "Huffman", "Kramer", "Arnold",
            "Young", "Washington", "Delaney", "Garner", "Mccarthy", "Warren", "Peterson",
            "Duke", "Chambers", "Sanchez", "Hinton", "Guerrero", "Witt", "Jackson", "Jimenez",
            "Tran", "Benjamin", "Kelley", "Woodward", "Valenzuela", "Farmer", "Schwartz",
            "Bates", "Clay", "Reyes", "Colon", "Preston", "Ferguson", "Clarke", "Randolph",
            "Mcmillan", "Kim", "England", "Brown", "Serrano", "Sawyer", "Ford", "Howell",
            "Mcmillan", "West", "Albert", "Cantu", "Taylor", "Roy", "Cleveland", "Browning", "Branch"};

    // 500000 son muchos datos y hacer pruebas es tardado
    static int num[] = {10};//, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000, 200000, 500000};

    // 10 trazas del mismo algoritmo es mucho texto
    static int pruebas = 1;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        Random random = new Random();
        PrintWriter writer = new PrintWriter("resultados.csv", "UTF-8");
        writer.println("n;shell;mezcla");

        for(int cant: num) {
            Dato datos[] = new Dato[cant];
            long tiempoShell = 0, tiempoMezcla = 0;
            for (int i = 0; i < pruebas; i++) {
                Shell s = new Shell();
                Mezcla m = new Mezcla();
                long inicio, fin;

                // hacer ordenamiento Shell
                for (int j = 0; j < cant; j++) {
                    int iNom = random.nextInt(nombres.length);
                    int iApe = random.nextInt(apellidos.length);
                    int edad = random.nextInt(99);
                    datos[j] = new Dato(nombres[iNom], apellidos[iApe], edad);
                }
                inicio = System.currentTimeMillis();
                s.ordena(datos);
                fin = System.currentTimeMillis();
                tiempoShell += (fin-inicio);

                // hacer ordenamiento Mezcla
                for (int j = 0; j < cant; j++) {
                    int iNom = random.nextInt(nombres.length);
                    int iApe = random.nextInt(apellidos.length);
                    int edad = random.nextInt(99);
                    datos[j] = new Dato(nombres[iNom], apellidos[iApe], edad);
                }
                inicio = System.currentTimeMillis();
                m.ordena(datos);
                fin = System.currentTimeMillis();
                tiempoMezcla += (fin-inicio);

            }
            String resultado = cant + ";" + (tiempoShell/pruebas) + ";" + (tiempoMezcla/pruebas);
            writer.println(resultado);
            System.out.println(resultado);

        }
        writer.close();

    }
}
