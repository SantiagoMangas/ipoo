public class NaveEspacial {
    private static final int maxDeposito=1000;
    private static final int parsec=100;
    private char color;
    private int combustible;

    public NaveEspacial(char o, int c){
        color = o;
        if (c > maxDeposito)
            combustible = maxDeposito;
        else
            combustible = c;
    }
    public void NaveEspacial(char o){
        combustible = maxDeposito;
        color = o;
    }

    public void establecerColor(char o){
        color = o;
    }

    public void establecerCombustible(int c){
        if(c > maxDeposito)
            combustible = maxDeposito;
        else
            combustible = c;
    }

    public void llenarDeposito(){
        combustible = maxDeposito;
    }

    public char obtenerColor(){
        return color;
    }

    public int obtenerCombustible(){
        return combustible;
    }

    public float obtenerAutonomia(){
        return combustible/parsec;
    }
    public void copy (NaveEspacial n){
        color = n.obtenerColor();
        combustible = n.obtenerCombustible();
    }
    public boolean equals(NaveEspacial n){
        return combustible == n.obtenerCombustible() && color == n.obtenerColor(); 
        //si el combustible y el color son iguales, retorna true
    }
    public NaveEspacial clone(){
        return new NaveEspacial(color, combustible); //crea un nuevo objeto con el mismo estado
    }
}