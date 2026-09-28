class Vehiculo {
    //Atributos de instancia
    private Hora ingreso;
    private Hora egreso;
    private int numero;
    private String patente;

    //constructor
    public Vehiculo (Hora i, int n, String p){
        if(i != null){
            ingreso = i;
        }
        patente = p;
        numero = n;
        egreso = null;
    }
    //comandos
    public void egresaVehiculo(Hora c){
        if(c != null){
            egreso = c;
        }
    }
    public void copy(Vehiculo v){
        // Requiere v ligado Y que el vehículo ya haya egresado (tenga hora de egreso)
        ingreso = new Hora(v.obtenerIngreso().obtenerHora(), v.obtenerIngreso().obtenerMinutos());
        egreso = new Hora(v.obtenerEgreso().obtenerHora(), v.obtenerEgreso().obtenerMinutos());
        numero = v.obtenerNumero();
        patente = v.obtenerPatente();
        
    }
    // Consultas
    public Hora obtenerIngreso() {
        return ingreso;
    }

    public Hora obtenerEgreso() {
        return egreso;
    }

    public int obtenerNumero() {
        return numero;
    }

    public String obtenerPatente() {
        return patente;
    }
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
    //hecho por ia:
    public int obteneraCobrar(Tarifa t) {
        // ¡Corte temprano! Si falta algún dato, devolvemos 0 directamente y no sigue bajando.
        if(egreso == null || t == null) {
            return 0;
        } 
        
        int aux;
        int minTranscurridos = ingreso.diferenciaMinutos(egreso);

        if(minTranscurridos <= 15) {
            aux = t.obtenerT15();
        } else if(minTranscurridos <= 30) {
            aux = t.obtenerT30();
        } else if (minTranscurridos <= 60) {
            aux = t.obtenerT60();
        } else {
            aux = t.obtenerTFija(); // ¡Corregido el nombre del método!
        }
        
        return aux;
    }

    public boolean anterior(Vehiculo v) {
        // Asume v ligado
        return this.ingreso.anterior(v.obtenerIngreso());
    }

    public boolean equals(Vehiculo v) {
        // Asume v ligado. La patente se evalúa superficial y los demás en profundidad
        
        boolean ingresoIgual = this.ingreso.equals(v.obtenerIngreso());
        
        // Defensa segura contra vehículos no egresados:
        boolean egresoIgual = false;
        if(this.egreso == null && v.obtenerEgreso() == null) {
            egresoIgual = true;
        } else if(this.egreso != null && v.obtenerEgreso() != null) {
            egresoIgual = this.egreso.equals(v.obtenerEgreso());
        }

        return ingresoIgual &&
               egresoIgual &&
               this.numero == v.obtenerNumero() &&
               this.patente == v.obtenerPatente(); // == para comparación superficial del String
    }
}
