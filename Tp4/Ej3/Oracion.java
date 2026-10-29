public class Oracion {
    //Atributos de instancia
    private char [] s;
    //Constructor
    public Oracion(String str){
        s = new char[str.length()];
        // 1. Le damos al arreglo el mismo tamaño que el String
        for(int i = 0; i < str.length() ;i++){
            s[i] = str.charAt(i);
        }
        // 2. Copiamos cada carácter del String a nuestro arreglo
    }
    //Comandos
    public void reducirBlancos() {
        int posEscritura = 0;

        for (int i = 0; i < longitud(); i++) {
            // Guardamos si es letra actual, O si es el primer espacio después
            //  de una letra
            if (this.esLetra(i) || (i > 0 && this.esLetra(i - 1))) {
                s[posEscritura] = s[i];
                posEscritura++;
            }
        }

        // Rellenamos el final con los blancos que sobraron para mantener la longitud
        while (posEscritura < longitud()) {
            s[posEscritura] = ' ';
            posEscritura++;
        }
    }
    public void establecerLetra(int pos, char l){
        s[pos] = l;
    }
    //Consultas
    public char obtenerLetra(int pos){
        return s[pos];
    }

    public boolean esLetra(int pos){
        boolean letra = false;
        if(pos < this.longitud() && pos>=0){
            if(s[pos] != ' '){
                letra = true;
            }
        }
        return letra;
    }

    public boolean esPrimeraPalabra(int pos){
        boolean esPrimera = false;
        if(esLetra(pos)){
            if(pos == 0 || s[pos-1] == ' '){
                esPrimera = true;
            }
        }
        return esPrimera;
    }

    public int longitud() {
        return s.length;
    }

    public int contarPalabras(){
        int contador = 0;
        for(int i = 0; i < longitud() ; i++){
            if (esPrimeraPalabra(i)) {
                contador++;        
            }
        }
        return contador;
    }

    public int masLarga(){
        int maxima = 0;
        int actual = 0;
        
        for (int i = 0; i < longitud(); i++) {
            if (esLetra(i)) {
                actual++;
                if (actual > maxima) {
                    maxima = actual;
                }
            } else {
                actual = 0; 
            }
        }
        return maxima;
    }

    private boolean esVocal(char c){
        return c == 'a' || c=='A' || c=='e' || c=='E'|| c=='i'|| c=='I'|| c=='o'|| c=='O'|| c=='u'|| c=='U';
    }

    public boolean hayNVocales(int n){
        int contador = 0;
        for(int i = 0; i < longitud() && contador <= n; i++){
            if(esVocal(s[i])){
                contador++;
            }
        }
        return contador == n;
    }
    public boolean dosVocalesConsecutivas(){
        boolean hay = false;
        for(int i = 0; i < longitud()-1 && !hay; i++){
            if(esVocal(s[i]) && esVocal(s[i+1])){
                hay = true;
            }
        }
        return hay;
    }
    public SecuenciaEnteros histograma() {
        // Creamos la secuencia con 26 casilleros (asumiendo alfabeto inglés A-Z)
        SecuenciaEnteros hist = new SecuenciaEnteros(26);
        
        for (int i = 0; i < longitud(); i++) {
            if (esLetra(i)) {
                // Convertimos la letra (ej: 'C') en una posición del 0 al 25
                // Como el contrato dice que siempre son MAYÚSCULAS, 
                // esto funciona perfecto.
                int posEnAlfabeto = s[i] - 'A'; 
                
                // Leemos cuántas veces apareció esa letra hasta ahora
                int cantidadActual = hist.obtenerEntero(posEnAlfabeto);
                
                // Le sumamos 1 y lo guardamos
                hist.establecerEntero(posEnAlfabeto, cantidadActual + 1);
            }
        }
        
        return hist;
    }
}
