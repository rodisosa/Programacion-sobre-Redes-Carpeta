package utiles;


	public enum Background {
	    ESCENARIO1(Recursos.FONDO_ARENA,"escenarios/1.png");
	    
	   
	    private String root;
	   private String root2;
	    Background(String root,String root2){
	        this.root=root;
	        this.root2=root2;
	    }

	    public String getRoot() {
	        return root;
	    }
	    public String getRoot2() {
	        return root2;
	    }
	}

