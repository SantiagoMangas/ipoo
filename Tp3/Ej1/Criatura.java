package Tp3.Ej1;

class Criatura {
    //Atributos de clase
    private static final int maxEnergia = 100;
    private static final int minEnergia = 0;
    private static final int consumoEnergia = 10;

    //Atributos de instancia
    private int energia;
    private Refugio refugio;
    private boolean despierto;
    private int caminatas;

    //Constructor
    public Criatura(Refugio r) {
        energia = maxEnergia;
        despierto = true;
        caminatas = 0;
        this.refugio = r;
    }

    //Comandos
    public boolean comer(){
        if(despierto && refugio.obtenerAlimentos() > 0) {
            if(energia < maxEnergia) {
                energia ++;
            }
            refugio.consumirAlimento(); 
            return true;
        }
        return false;
    }

    public boolean beber(){
        if(despierto && refugio.obtenerBebidas() > 0) {
            if(energia < maxEnergia) {
                energia ++;
            }
            refugio.consumirBebida();
            return true;
        }
        return false;
    }

    public boolean dormir(){
        if(despierto && refugio.disponibilidad() > 0) {
            despierto = false;
            refugio.ocuparCama();
            return true;
        }
        return false;
    }

    public boolean despertar(){
        if(!despierto){
            despierto = true;
            refugio.desocuparCama();
            caminatas = 0;
            return true;
        } 
        return false;
    }
    
    public boolean caminar(){
        boolean pudoCaminar = false;

        if (despierto) {
            if (caminatas < 3 && energia >= consumoEnergia) {
                energia -= consumoEnergia;
                caminatas++;
                pudoCaminar = true;
            } else if (caminatas >= 3) {
                // Es la cuarta caminata (o más)
                if (refugio.disponibilidad() > 0) {
                    this.dormir(); // Se duerme automáticamente
                    pudoCaminar = true;
                } else {
                    energia = minEnergia;
                    caminatas = 3;
                    pudoCaminar = false;
                }
            }
        }
        return pudoCaminar;
    }

    //Consultas

    public int obtenerEnergia(){
        return energia;
    }
    public int obtenerCaminatas(){
        return caminatas;
    }
    public int obtenerHumor(){
        int aux;
        if(refugio.esHabitable() && energia > 70){
            aux = 3; // Feliz
        } else if(refugio.esHabitable() && energia > 40){
            aux = 2;
        } else {
            aux = 1; // Triste
        }
        return aux;
    }

    public Refugio obtenerRefugio(){
        return refugio;
    }
    public boolean estaDormido(){
        return !despierto;
    }
    public boolean mayorEnergia(Criatura c){
        return this.energia > c.obtenerEnergia();
    }
    public String toString(){
        return "Energia: " + energia + ", Caminatas: " + caminatas + ", Humor: " + this.obtenerHumor() + ", Despierto: " + despierto;
    }
}
