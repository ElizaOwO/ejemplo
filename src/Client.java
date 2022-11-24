import java.util.ArrayList;

public class Client implements Administrar {
    String id, nombre;
    static ArrayList<Client> cliente = new ArrayList<>();

    public Client(){ }

    public Client(String id, String nombre){
        this.id= id;
        this.nombre= nombre;
    }

    @Override
    public void leerArchivo() {
        Archivos.leerArc("D:\\Descargas\\cliente.txt",1);
    }

    @Override
    public void darAlta() {
        System.out.println("#########################################################");
        System.out.println("              DAR DE ALTA UN PACIENT                     ");
        System.out.println("#########################################################");
        Menu.crear(cliente,1);
    }

    @Override
    public void visualizar() {
        System.out.println("#########################################################");
        System.out.println("                 LISTA DE PACIENTES                      ");
        System.out.println("#########################################################");
        for(Client cadena : cliente){
            System.out.println(cadena);
        }
    }
    @Override
    public void guardarArchivo() {
        Archivos.guardarArc("D:\\Descargas\\cliente.txt",cliente);
    }

    @Override
    public String toString(){
        return id+ ","+ nombre;
    }
}
