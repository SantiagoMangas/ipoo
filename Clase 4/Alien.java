public class Alien {
    private static int maxVidas = 5;
    private NaveEspacial nave;
    private static int vidas;
    private static int antenas;

    public Alien (NaveEspacial n, int v, int a){
        //los valores de vida v <= 5 y a > 0.
        nave = n;
        vidas = v;
        antenas = a;
    }

    public void recuperaVidas(){
        if(vidas+2 >= maxVidas)
            vidas = maxVidas;
        else 
            vidas = vidas + 2; 
    }

    public void recibeHerida (){
        if (vidas >= 1)
            vidas--;
    }
    public void establecerNave(NaveEspacial n){
        nave = n;
    }
    public void establecerAntenas(int p){
        p = antenas;
    }
    public void establecerVidas(int p){
        p = vidas;
    }
    public NaveEspacial obtenerNave(){
        return nave;
    }
    public int obtenerVidas(){
        return vidas;
    }
    public int obtenerAntenas(){
        return antenas;
    }
    public float obtenerFuerza(){
        float f = antenas * vidas;
        if (nave != null && f != 0)
            f = f + nave.obtenerAutonomia()/5;
        return f;
    }
    public void copy (Alien a) {
        //SUPERFICIAL 
        nave = a.obtenerNave();
        vidas = a.obtenerVidas();
        antenas = a.obtenerAntenas();
    }
    public void copy2 (Alien a){
        //profundidad
        vidas = a.obtenerVidas();
        antenas = a.obtenerAntenas();
        //suponemos que las naves estan siempre ligadas
        nave.copy2(a.obtenerNave());
    }
}
