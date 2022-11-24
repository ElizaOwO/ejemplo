import java.util.ArrayList;

public class Doctor implements Administrar {

    String id, nombre, espacialidad;

    public static ArrayList<Doctor> doctors = new ArrayList<>();

    public Doctor(){}

    public Doctor(String id, String nombre, String especialidad){
        this.id= id;
        this.nombre= nombre;
        this.espacialidad= especialidad;
    }

    @Override
    public void leerArchivo() {
        Archivos.leerArc("D:\\Descargas\\doctor.txt",0);
    }

    @Override
    public void darAlta() {
        System.out.println("#########################################################");
        System.out.println("              DAR DE ALTA UN DOCTOR                      ");
        System.out.println("#########################################################");
        Menu.crear(doctors,0);
    }

    @Override
    public void visualizar() {
        System.out.println("#########################################################");
        System.out.println("                  LISTA DE DOCTORES                      ");
        System.out.println("#########################################################");
        for(Doctor cadena : doctors){
            System.out.println(cadena);
        }
    }

    @Override
    public void guardarArchivo() {
        Archivos.guardarArc("D:\\Descargas\\doctor.txt",doctors);
    }

    @Override
    public String toString(){
        return id+ ","+ nombre + ","+ espacialidad;
    }

}
