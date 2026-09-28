package septiembre;
class NotasParcial {
    private int[] notas;
	/*private int[][] notas2;

	notas2 = new int[3][6];

    notas2[0][3] = 10;
	notas2[2][2] = 100;
	int cantF = notas2.length;
	int cantC = notas2[0].length;*/

    public NotasParcial(int cant){
        notas = new int[cant];
    }
    
    public void establecerNota(int n, int i){
        // Corregido: n <= 100 y validación del índice i
        if (n >= 0 && n <= 100 && i >= 0 && i < notas.length){
            notas[i] = n;
        }
    }
    
    public int obtenerNota(int i){
        if (i >= 0 && i < notas.length) {
            return notas[i];
        }
        return -1;
    }
    
    public int cantNotas(){
        return notas.length;
    }
    
    public int cantAprobados(){
        int cont = 0; // Corregido: Inicializado en 0
        for(int i = 0; i < notas.length; i++){
            if(notas[i] >= 60){
                cont++;
            }
        }
        return cont;
    }

    public float promedGeneral(){
        if (cantNotas() == 0) return 0; // Evita división por cero
        
        int suma = 0;
        for(int i = 0; i < notas.length; i++){
            suma += notas[i];
        }
        return suma / cantNotas(); 
    }

    public float promedAprobados(){
        int suma = 0;
        int aprobados = 0;
        
        for(int i = 0; i < notas.length; i++){
            if (notas[i] >= 60){
                suma += notas[i];
                aprobados++;
            }
        }
            
        if (aprobados > 0){ 
            return suma / aprobados; // Corregido: suma / aprobados
        } else {
            return 0;
        }
    }
}