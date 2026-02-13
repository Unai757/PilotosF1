import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    //Creamos el arraylist haciendola estatica para poder usarla en los metodos estaticos
    static List<Piloto> pilotos = new ArrayList<>();


    public static void main(String[] args) {
        //Ponemos todos los metodos que hayamos creado para usarlos
        cargarPilotos();
        mostrarPilotos();
        anhadirPilotos();
        buscarPilotos();
        CrearArchivo.guardarDatos();

    }

    //Creamos el metodo de cargarPilotos
    public static void cargarPilotos() {
        try {
            //Creamos la variable línea para usarla en el reader
            String linea;
//Creamos el bufferedreader para leer el archivo de pilotos
            BufferedReader reader = new BufferedReader(new FileReader("Pilotos.txt"));
            while ((linea = reader.readLine()) != null) {
                //Hacemos un array donde utilizamos la variable línea y lo dividimos en punto y comas
                String[] lineas = linea.split(";");
                //Dividimos la variable en los espacios del array
                String nombre = lineas[0];
                String escuderia = lineas[1];
                String puntos = lineas[2];
                int puntos2 = Integer.parseInt(puntos);
                //Creamos un objeto piloto
                Piloto piloto = new Piloto(nombre, escuderia, puntos2);
                //Y añadimos ese piloto a pilotos
                pilotos.add(piloto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void mostrarPilotos() {
        //En este metodo mostramos la información de los pilotos utilizando un toString para que la información salga legible
        for (Piloto piloto : pilotos) {
            System.out.println(piloto);

        }

    }

    //Creamos el metodo de añadirPilotos
    public static void anhadirPilotos() {
        //Creamos un scanner para usarlo mas tarde
        Scanner sc = new Scanner(System.in);
        System.out.println("Añade un piloto");
        System.out.println("------------------------------");
        //Pedimos el nombre del piloto para que lo busque
        System.out.println("Introduce el nombre del piloto: ");
        String nombre = sc.nextLine();
        //Creamos esta variable booleana para que si lo encuentre se vuelva true
        boolean encontrado = false;
        for (Piloto piloto1 : pilotos) {
            if (piloto1.getNombre().equals(nombre)) {

                encontrado = true;
                System.out.println("El piloto " + nombre + " existe");
            }


        }
        //Si no lo encuentra pedira la escuderia y puntos del piloto para añadirlo al arraylist
        if (!encontrado) {
            System.out.println("Dime la escuderia del piloto");
            String escuderia = sc.nextLine();
            System.out.println("Dime puntos del piloto");
            String puntos = sc.nextLine();
            int puntos2 = Integer.parseInt(puntos);
//Aquí añadimos el nuevo piloto
            pilotos.add(new Piloto(nombre, escuderia, puntos2));
        }


    }

    //En este metodo sirve para buscar pilotos si encuentra el nombre nos da toda la información
    public static void buscarPilotos() {
        System.out.println("Busca un piloto");
        System.out.println("------------------------------");
        System.out.println("Dime el nombre del piloto que quieres buscar: ");
        String nombrebuscado;
        Scanner sc = new Scanner(System.in);
        nombrebuscado = sc.nextLine();
        boolean encontrado = false;
        for (Piloto piloto : pilotos) {
            if (piloto.getNombre().equals(nombrebuscado)) {
                System.out.println(piloto);
                encontrado = true;


            }
            if (encontrado) {
                break;

            }

        }
        if (!encontrado) {
            System.out.println("El piloto " + nombrebuscado + " no existe");
        }
    }

}




