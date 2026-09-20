public class Fecha {
    //atributos de instancia
    private int dia, mes, anio;
    //Constructor
    public Fecha(int d, int m, int a){
        dia = d; mes = m; anio = a;
    }
    //Comandos
    public void establecerDia(int d){
        dia = d;
    }
    public void establecerMes(int m){
        mes = m;
    }
    public void establecerAnio(int a){
        anio = a;
    }
    //Consultas
    public int obtenerDia(){
        return dia;
    }
    public int obtenerMes(){
        return mes;
    }
    public int obtenerAnio(){
        return anio;
    }
    public boolean esBisiesto(){
        return (anio%4==0 && anio%100!=0) || (anio%400==0);
        //si el año es divisible por 4 y no es divisible por 100,
        // o si es divisible por 400, entonces es bisiesto
    }
    public boolean esAnterior(Fecha f){
        if (f != null){
            if (anio < f.obtenerAnio()){
                return true;
            }
            else if (anio == f.obtenerAnio()){
                if (mes < f.obtenerMes()){
                    return true;
                }
                else if (mes == f.obtenerMes()){
                    if (dia < f.obtenerDia()){
                        return true;
                    }
                }
            }          
        }
        return false;
    }
    public boolean mismoAnio(Fecha f){
        if (f != null){
            return anio == f.obtenerAnio();
        }
        return false;
    }
    public boolean equals(Fecha f){
        if (f != null){
            return dia == f.obtenerDia() && mes == f.obtenerMes() && anio == f.obtenerAnio();
        }
        return false;
    }
    public String toString(){
        return dia + "/" + mes + "/" + anio;
    }
}
