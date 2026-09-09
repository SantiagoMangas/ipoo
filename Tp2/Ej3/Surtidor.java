package Tp2.Ej3;

public class Surtidor {
    //Atributos de clase
    private static int maximaCarga = 20000;
    //Atributos de instancia
    private static int cantGasoil;
    private static int cantSuper;
    private int cantPremium;
    //Constructor
    public Surtidor(){
        cantGasoil = maximaCarga;
        cantSuper = maximaCarga;
        cantPremium = maximaCarga;
    }
    //Comandos
    public void llenarDepositoGasoil(){
        cantGasoil = maximaCarga;
    }
    public void llenarDepositoSuper(){
        cantSuper = maximaCarga;
    }
    public void llenarDepositoPremium(){
        cantPremium = maximaCarga;
    }
    public void extraerGasoil(int litros){
        if(litros < cantGasoil){
            cantGasoil = cantGasoil - litros;
        }else{
            cantGasoil = 0;
        }
    }
    public void extraerSuper(int litros){
        if(litros < cantSuper){
            cantSuper = cantSuper - litros;
        }else{
            cantSuper = 0;
        }
    }
    public void extraerPremium(int litros){
        if(litros < cantPremium){
            cantPremium = cantPremium - litros;
        }else{
            cantPremium = 0;
        }
    }
    //Consultas
    public int obtenerMaximaCarga(){
        return maximaCarga;
    }
    public int obtenerLitrosGasoil(){
        return cantGasoil;
    }
    public int obtenerLitrosSuper(){
        return cantSuper;
    }
    public int obtenerLitrosPremium(){
        return cantPremium;
    }
    public boolean depositosLlenos(){
        return cantGasoil == maximaCarga && cantSuper == maximaCarga && cantPremium == maximaCarga;
    }
}
