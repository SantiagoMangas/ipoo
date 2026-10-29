public class SecuenciaEnteros {
    //atributos de intancia
    private int [] sec;
    //Contructor 
    public SecuenciaEnteros(int cant){
        // El contrato del diseño indica: "Requiere cant > 10".
        // En este tipo de ejercicios, asumimos que la clase 
        // cliente que usa este objeto respeta el contrato y 
        // envía un valor válido.
        sec = new int[cant];
    }
    //Comandos
    public void establecerEntero(int p, int n){
        sec[p] = n;
    }
    public void reemplazar(int n1, int n2){
        for(int i = 0; i<cantElementos() ;i++){
            if(sec[i] == n1)
                sec[i] = n2;
        }
    }
    public void reemplazar(int n){
        int primeraPos = -1;
        int ultimaPos = -1;
        for(int i = 0; i<cantElementos() ;i++){
            if(sec[i] == n){
                if(primeraPos == -1)
                    primeraPos = i;
                ultimaPos = i;
            }
        } 
        if(primeraPos != -1){
            sec[primeraPos] = 0;
            sec[ultimaPos] = 0;
            // Nota: Si el número apareció una sola vez, primeraPos y ultimaPos 
            // valen lo mismo. El código le va a asignar 0 a la misma posición 
            // dos veces, lo cual cumple perfectamente con la consigna.
        }
    }
    public boolean intercambiar(int p1, int p2){
        boolean intercambio = false;
        if(p1 >= 0 && p1 < cantElementos() && p2 >= 0 && p2 < cantElementos()){

            int aux = sec[p1];
            sec[p1] = sec[p2];
            sec[p2] = aux;

            intercambio = true;
        }
        return intercambio;
    }

    public boolean copy(SecuenciaEnteros a){
        boolean copia = false;
        if(a != null && a.cantElementos() == this.cantElementos()){
            for(int i = 0; i < cantElementos();i++){
                sec[i] = a.obtenerEntero(i);
            }
            copia =true;
        }
        return copia;
    }

    //Consultas
    public int cantElementos(){
        return sec.length;
    }
    public int obtenerEntero(int p){
        return sec[p];
    }
    public int total(){
        int aux = 0;
        for(int i = 0; i < cantElementos() ;i++){
            aux += sec[i];
        }
        return aux;
    }
    public boolean estaNum(int n){
        boolean esta = false;
        for(int i = 0; i < cantElementos() && esta == false ;i++){
            if(sec[i] == n)
                esta = true;
        }
        return esta;
    }
    public int cantidadMayores(int n){
        int sumatoria = 0;
        for(int i = 0; i < cantElementos();i++){
            if(sec[i] > n)
                sumatoria++;
        }
        return sumatoria; 
    }
    public boolean mitadMayores(int n){
        boolean aux = false;
        if(this.cantidadMayores(n) >= this.cantElementos() / 2){
            aux = true;
        }
        return aux;
    }
    public boolean equals(SecuenciaEnteros a){
        boolean iguales = false;
        if( a != null && a.cantElementos() == this.cantElementos()){
            iguales = true;

            for(int i = 0; i <cantElementos() && iguales ;i++){
                if(a.obtenerEntero(i) != this.sec[i]){
                    iguales = false;
                }
            }
        }
        return iguales;
    }
    public SecuenciaEnteros clone() {
        // 1. Creamos un nuevo objeto con la misma cantidad de elementos que el nuestro
        SecuenciaEnteros clon = new SecuenciaEnteros(this.cantElementos());
        
        // 2. Le pedimos a ese nuevo objeto que se copie nuestros datos.
        // Ojo acá: le mandamos "this" (nosotros mismos) como parámetro para que nos copie.
        clon.copy(this);
        
        // 3. Retornamos el nuevo objeto ya cargado con los datos idénticos
        return clon;
    }
}
