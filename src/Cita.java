import java.util.ArrayList;

public class Cita implements Administrar{
    String id,idD, idC, fec, motivo;
    static ArrayList<Cita> cita = new ArrayList<>();

    public Cita(){}
    public Cita(String id, String idD, String idC, String fec, String motivo){
        this.id= id;
        this.idD= idD;
        this.idC= idC;
        this.fec= fec;
        this.motivo= motivo;
    }

    @Override
    public void leerArchivo() {
        Archivos.leerArc("D:\\Descargas\\cita.txt",2);
    }

    @Override
    public void darAlta() {
        System.out.println("#########################################################");
        System.out.println("                      CREAR CITA                         ");
        System.out.println("#########################################################");
        Menu.crear(cita,2);
    }

    @Override
    public void visualizar() {
        System.out.println("#########################################################");
        System.out.println("                    LISTA DE CITAS                       ");
        System.out.println("#########################################################");
        for(Cita cadena : cita){
            System.out.println(cadena);
        }
    }

    @Override
    public void guardarArchivo() {
        Archivos.guardarArc("D:\\Descargas\\cita.txt",cita);
    }

    @Override
    public String toString(){
        return id+ ","+ idD+  ","+ idC + "," +fec+ "," +motivo;
    }
}
