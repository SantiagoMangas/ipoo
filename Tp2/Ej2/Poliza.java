package Tp2.Ej2;

public class Poliza {
    private static int nroPoliza;
    private static float incendio;
    private static float robo;
    private static boolean activa;

    public Poliza(int np){
        nroPoliza = np;
        activa = true; // Siempre nace activa
    }
    public Poliza(int np, float i, float r){
        nroPoliza = np;
        incendio = i;
        robo = r;
        activa = true;
    }
    public void establecerIncendio(float m){
        incendio = m;
    }
    public void establecerRobo(float m){
        robo = m;
    }
    public void actualizarPorcentaje(int p){
        if(activa){
           incendio = incendio + (incendio * p / 100);
            robo = robo + (robo * p / 100); 
        }  
    }
    public void activa(){
        activa = true;
    }
    public void desactiva(){
        activa = false;
    }
    //consultas
    public int obtenerNroPoliza(){
        return nroPoliza;
    }
    public float obtenerIncendio(){
        return incendio;
    }
    public float obtenerRobo(){
        return robo;
    }
    public float obtenerCostoPoliza(){
        return incendio + robo;
    }
    public boolean estaActiva(){
        return activa;
    }
}
