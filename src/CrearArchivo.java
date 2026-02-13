import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrearArchivo {


    public static void guardarDatos() {
        //boolean seguir=true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo: ");
        String nombrearchivo = sc.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombrearchivo))) {
//Recorremos la lista y ponemos los datos en ese archivo
            for (Piloto piloto : Main.pilotos) {
                writer.write(piloto.getNombre());
                writer.write(";");
                writer.write(piloto.getEscuderia());
                writer.write(";");
                writer.write("" + piloto.getPuntos());
                writer.newLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
