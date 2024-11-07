package utiles;

import personajes.PersonajePrefab;

public enum Retratos {
    
    SPACEMARINE("retratos/SM.png", "retratos/SM.png", "com.dojan.marinevsorko.personajes.Marine"),
    ORKO("retratos/ORKO.png", "retratos/ORKO.png", "com.dojan.marinevsorko.personajes.Orko"),
    MARINE("retratos/SM.png", "retratos/SM.png", "com.dojan.marinevsorko.personajes.Marine"),
    LOKO("retratos/ORKO.png", "retratos/ORKO.png", "com.dojan.marinevsorko.personajes.Orko");
	
    private String root;
    private String clase;
    private String root2;
    
    private Retratos(String root, String root2,String clase){
        this.root=root;
        this.root2=root2;
        this.clase=clase;
    }

    public String getRoot2() {
        return root2;
    }
    
    public String getRoot() {
        return root;
    }
    
    public PersonajePrefab getClase(){
        Class c;
        PersonajePrefab p =null;
        try {
            c = Class.forName(this.clase); 
            p = (PersonajePrefab) c.newInstance();
        
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