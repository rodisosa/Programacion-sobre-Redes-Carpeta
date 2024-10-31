package online;

import personajes.PersonajePrefab;


public class Cliente {
	private static HiloCliente hiloC;
	  
    protected boolean escenarios;
    private static PersonajePrefab j1;
    private static PersonajePrefab j2;
    
    
    public Cliente(){
    hiloC= new HiloCliente();
    hiloC.start();
        

    }
    public static HiloCliente getHiloC() {
        return hiloC;
    }

     public static void setJ1(PersonajePrefab j1) {
         Cliente.j1 = j1;
     }
     public static void setJ2(PersonajePrefab j2) {
         Cliente.j2 = j2;
     }
     public static PersonajePrefab getJ1() {
         return j1;
     }
     public static PersonajePrefab getJ2() {
         return j2;
     }
    public static String getMsg(){
        return hiloC.getMsg();
    }
    public static void enviarMensaje(String string){
          hiloC.enviarMensaje(string);
    }
    public static float getCantidad(){
        return hiloC.getCant();
    }
    public static void dispose() {
        if(hiloC!=null){hiloC.stopSv();}
    }
}




