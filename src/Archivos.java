import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class Archivos {
    public static void guardarArc(String ruta, ArrayList arrayList){
        try {
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            int longitud = arrayList.size();

            for (int i = 0; i < longitud; i++) {
                writer.write(arrayList.get(i).toString() + "\n");
            }
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void leerArc(String ruta, int usuario){
        String linea="0";
        List<String> parts = new ArrayList<>();
        String palabras[];

        try {
            FileReader lectura = new FileReader(ruta);
            BufferedReader buffer_lectura = new BufferedReader(lectura);

            while ((linea = buffer_lectura.readLine())!=null) {
                //Agregar a la lista los valores de cada , [ , , ,][ , , ,][ , , ,]
                parts.add((Arrays.asList(linea.split(",")).toString()));

                //Separar los valores y guardarlos en un array x posicion [0,1,2]
                palabras= linea.split(",");
                //En cada posicion para hacer un new doctor
                switch (usuario){
                    case 0: Doctor.doctors.add(new Doctor(palabras[0],palabras[1],palabras[2]));break;
                    case 1: Client.cliente.add(new Client(palabras[0],palabras[1]));break;
                    case 2: Cita.cita.add(new Cita(palabras[0],palabras[1],palabras[2],palabras[3],palabras[4])); break;
                    case 3: Menu.usuarioContra.put(palabras[0], palabras[1]);break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
