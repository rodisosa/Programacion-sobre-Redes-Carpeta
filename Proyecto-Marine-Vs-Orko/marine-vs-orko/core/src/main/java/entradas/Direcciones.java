package entradas;

import com.badlogic.gdx.Screen;

public enum Direcciones {
    SM("S"),
    ORKO("O"), 
    CONECTAR("conectar"),
    SALTAR("saltar"),
    SELECCIONESCENARIOS("SelecEscc"),
    ESCENARIOS("pantallas.PantallaArena"),
    PELEATERMINADA("pantallas.PeleaTerminada"),
    SELECCIONPJ("pantallas.SeleccionPJ"),
    CERRAR("cerrar"),
    POSX("POSX"),
    POSY("POSY"),
    HP("HP"),
    DISPARAR("29"),
    GOLPEAR("47"),
    ENTER("66"),
    ARRIBA("19"),
    ABAJO("20"),
    IZQUIERDA("21"),
    DERECHA("22");
    
    String string;
    boolean active;
 
    Direcciones(String string){
         
        this.string=string;
    }

    public void doActive() {
        active= true;
    
   }

  public void setPOSX(int nmb){
    this.string=Integer.toString(nmb);
  }

  public void setPOSY(int nmb){
    this.string=Integer.toString(nmb);
  }


   public void HPaRestar(int nmb){
    this.string=Integer.toString(nmb);
   }
   public boolean isActive() {
       
       
       return active;
   }
   public void dontActive() {
    active=false;
}
 
 
    public String getString() {
        return string;
    }

  
    public Screen getClase(){
        Class c;
        Screen p =null;
        try {
            c = Class.forName(this.string); 
            p = (Screen) c.newInstance();
        
        } catch (ClassNotFoundException e) {
             
            e.printStackTrace();
        } catch (InstantiationException e) {
             
            e.printStackTrace();
        } catch (IllegalAccessException e) {
             
            e.printStackTrace();
        }
      return p;
    }

    

    
}