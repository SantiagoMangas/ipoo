class Vehiculo {
    //Atributos de instancia
    private Hora ingreso;
    private int aCobrar;
    private int numero;
    private String patente;

    //constructor
    public Vehiculo (Hora i, int n, String p){
        if(i != null){
            ingreso = i;
        }
        patente = p;
        numero = n;
        aCobrar = 0;
    }
    //comandos
    public void egresaVehiculo(Hora c, Tarifa t){
        if(c != null && t != null){
            int minTranscurridos = this.obtenerIngreso().diferenciaMinutos(c);

            if(minTranscurridos <= 15){
                aCobrar = t.obtenerT15();
            } else if(minTranscurridos <= 30)
                aCobrar = t.obtenerT30();
                else if(minTranscurridos <=60)
                    aCobrar = t.obtenerT60();
                else
                    aCobrar = t.obtenerTFija();
        }
    }
    public void copy(Vehiculo v){
        ingreso = new Hora(v.obtenerIngreso().obtenerHora(), v.obtenerIngreso().obtenerMinutos());
        aCobrar = v.obteneraCobrar();
        numero = v.obtenerNumero();
        patente = v.obtenerPatente();
        
    }
    // Consultas
    public Hora obtenerIngreso() {
        return ingreso;
    }

    public int obteneraCobrar() {
        return aCobrar;
    }

    public int obtenerNumero() {
        return numero;
    }

    public String obtenerPatente() {
        return patente;
    }/*
    public int obteneraCobrar(Tarifa t){
        int aux;
        if(egreso == null || t == null){
            aux = 0;
        } 
        int minTranscurridos = ingreso.diferenciaMinutos(egreso);

        if(minTranscurridos <= 15){
            aux = t.obtenerT15();
        } else if(minTranscurridos <= 30){
            aux = t.obtenerT30();
        } else if (minTranscurridos <= 60){
            aux = t.obtenerT60();
        } else 
            aux = t.obtenerTFija();
        return aux;
    }
    public boolean anterior(Vehiculo v){
        return this.ingreso.anterior(v.obtenerIngreso());
    }
    public boolean equals(Vehiculo v){
        return ingreso.equals(v.obtenerIngreso()) &&
            egreso.equals(v.obtenerEgreso()) &&
            numero == v.obtenerNumero() &&
            patente == v.obtenerPatente();

    }
    hecho por ia:*/
    public boolean anterior(Vehiculo v) {
        // Asume v ligado
        return this.ingreso.anterior(v.obtenerIngreso());
    }

    public boolean equals(Vehiculo v) {
        return ingreso.equals(v.obtenerIngreso()) &&
               aCobrar == v.obteneraCobrar() &&
               numero == v.obtenerNumero() &&
               patente == v.obtenerPatente(); }
}
