public class Prestamo {
    //Atributos de instancia
    private Libro libro;
    private String socio;
    private Fecha fechaPrestamo;
    private Fecha fechaDevolucion;
    private boolean devuelto;

    //constructor
    public Prestamo( Libro l, Fecha fp, Fecha fd, String s) {
        this.devuelto = false; // Inicialmente el libro se encuentra prestado
        this.libro = l;
        this.socio = s;
        this.fechaPrestamo = fp;
        this.fechaDevolucion = fd;
    }

    //consultas
    public boolean estaAtrasado(Fecha hoy){
        // Retorna verdadero si el libro NO se devolvió (!devuelto) 
        // y la fecha de hoy es posterior a la fecha de devolución (fechaDevolucion es anterior a hoy)
        return !devuelto && fechaDevolucion.esAnterior(hoy);
    }

    public Prestamo masAntiguo(Prestamo p){
        if(this.fechaPrestamo.esAnterior(p.obtenerFechaPrestamo())){
            return this;
        } else {
            return p;
        }
    }

    public Libro obtenerLibro(){
        return libro;
    }
    public String obtenerSocio(){
        return socio;
    }
    public Fecha obtenerFechaPrestamo(){
        return fechaPrestamo;
    }
    public Fecha obtenerFechaDevolucion(){
        return fechaDevolucion;
    }
    public boolean estaDevuelto(){
        return devuelto;
    }
    public boolean equals(Prestamo p){
        // Igualdad superficial por socio (==) y en profundidad para los objetos (.equals)
        return this.socio == p.obtenerSocio() && // Igualdad superficial por socio
                   this.libro.equals(p.obtenerLibro()) && // Profundidad
                   this.fechaPrestamo.equals(p.obtenerFechaPrestamo()) && // Profundidad
                   this.fechaDevolucion.equals(p.obtenerFechaDevolucion()) && // Profundidad
                   this.devuelto == p.estaDevuelto();
    }
    public String toString(){
        return "Libro: " + libro.obtenerNombre() + ", Socio: " + socio + ", Fecha de Prestamo: " + fechaPrestamo.toString() + ", Fecha de Devolucion: " + fechaDevolucion.toString() + ", Devuelto: " + devuelto;
    }
}
