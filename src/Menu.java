
import java.util.*;

public class Menu{

    static String opcion;
    static Scanner sc = new Scanner(System.in);
    static Scanner sci = new Scanner(System.in);
    //Instanciar las clases parar
    //poder llamar los métodos abstractos
    static Doctor doc= new Doctor();
    static Client client= new Client();
    static Cita cita= new Cita();
    static Map<String,String> usuarioContra= new HashMap<>();

    public static void main(String[] arg) {

        //Cargar todos los archivos
        //y llenarlos con sus arrays correspondientes
        doc.leerArchivo();
        client.leerArchivo();
        cita.leerArchivo();

        iniciarSesion();
        menu();
    }

    public static void iniciarSesion(){
        //Variables que se usarán
        //para válidar
        String usuario;
        String contrasena;
        Boolean bool= true;

       // archivos.loadInicio("D:\\Descargas\\admin.txt", usuarioContra);
        Archivos.leerArc("D:\\Descargas\\admin.txt",3);

        //Iterar map para ver los admins actuales
        for (Map.Entry<String, String> entry : usuarioContra.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        //Repeticion para validar
        //usuario y contraseña
        while(bool) {
            mensaje("Ingresa el usuario");
            usuario = sc.nextLine().toLowerCase();

            if(usuarioContra.get(usuario) == null){
                mensaje("Usuario no existe");
            }else{
                while(bool){
                    mensaje("Ingresa contraseña");
                    contrasena = sc.nextLine();
                    if(contrasena.equals(usuarioContra.get(usuario))){
                        bool= false;
                    }else{
                        mensaje("Contraseña incorrecta");
                    }
                }
            }
        }
    }
    public static void menu(){
        while(opcion!="7"){
            mensaje("Elige una opción");
            mensaje("1.- Dar de alta doctor");
            mensaje("2.- Dar de alta paciente");
            mensaje("3.- Crear cita");
            mensaje("4.- Visualizar doctores");
            mensaje("5.- Visualizar clientes");
            mensaje("6.- Visualizar citas");
            mensaje("7.- Salir");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1": doc.darAlta(); break;
                case "2": client.darAlta(); break;
                case "3": cita.darAlta(); break;
                case "4": doc.visualizar(); break;
                case "5": client.visualizar(); break;
                case "6": cita.visualizar(); break;
                case "7":
                    doc.guardarArchivo();
                    client.guardarArchivo();
                    cita.guardarArchivo();
                    System.exit(0); break;
                default:
                    mensaje("Opción no válida");
            }
        }
    }
    public static void crear(ArrayList arrayList, int user) {
        String id,idD,idC,motivo,nombre,especialidad,fecha;
        int dia,mes,anio,hora,minuto;
        Scanner sc = new Scanner(System.in);

        //Dar de alta
        Boolean b=true, bol=true;

        while (b){
            System.out.println(("Ingresa el id"));
            id = sc.nextLine().toLowerCase();//5

            if(validarId(id,arrayList,user)){
                b= false;

                switch (user){
                    case 0:
                        System.out.println(("Ingresa el nombre"));
                        nombre = sc.nextLine().toLowerCase();

                        System.out.println(("Ingresa especialidad"));
                        especialidad = sc.nextLine().toLowerCase();

                        Doctor.doctors.add(new Doctor(id,nombre,especialidad));
                        break;
                    case 1:
                        System.out.println(("Ingresa el nombre"));
                        nombre = sc.nextLine().toLowerCase();
                        Client.cliente.add(new Client(id,nombre));
                        break;
                    case 2:
                        while(bol) {
                            System.out.println(("Ingresa id del doctor"));
                            idD = sc.nextLine().toLowerCase();//98

                            if (!validarId(idD, Doctor.doctors, 0)) {
                                while (bol){
                                    System.out.println(("Ingresa id del cliente"));
                                    idC = sc.nextLine().toLowerCase();

                                    if (!validarId(idC, Client.cliente, 1)) {
                                        bol=false;
                                        System.out.println("Ingresa el dia");
                                        dia= sci.nextInt();
                                        System.out.println("Ingresa el mes");
                                        mes= sci.nextInt();
                                        System.out.println("Ingresa el año");
                                        anio= sci.nextInt();
                                        System.out.println("Ingresa la hora");
                                        hora= sci.nextInt();
                                        System.out.println("Ingresa el minuto");
                                        minuto= sci.nextInt();
                                        mensaje("Ingresa motivo de cita");
                                        motivo= sc.nextLine();

                                        //Pedir e ingresar datos enteros
                                        fecha= String.valueOf(new Date(anio,mes,dia,hora,minuto,00).toLocaleString());
                                        //String fec = fecha.toLocaleString();
                                        Cita.cita.add(new Cita(id,idD,idC,fecha,motivo));

                                    }
                                }
                            }
                        }
                        break;
                }
            }
        }
    }
    public static boolean validarId(String str, ArrayList arrayList, int user){
        System.out.println("validacion");
        Boolean b=true;
        String a;

        System.out.println(arrayList.size());
        for (int i = 0; i< arrayList.size(); i++){
            if(user==0){
                a= Doctor.doctors.get(i).id;
            }else if(user==1){
                a= Client.cliente.get(i).id;
            }else{
                //Cambiara  cita
                a= Cita.cita.get(i).id;
            }
            System.out.println(str+ " es igual a " + a);
            if(str.equals(a)){
                System.out.println("Id existente");
                b=false;
            }
        }
        return b;
    }
    public static void mensaje(String s){
        System.out.println(s);
    }
}
