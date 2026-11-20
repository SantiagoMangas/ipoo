public class Imagen extends MatrizGenerica{
    public Imagen(int n){
        super(n, n);
    }
    public boolean todosGrises(){
        boolean grises = true;
        for(int i =0; i < cantFilas() && grises; i++){
            for(int j = 0; j < cantColumnas() && grises; j++){
                Color pixel = (Color) obtener(i, j);
                if(pixel == null || !pixel.esGris()){
                    grises = false;
                }
            }
        }
        return grises;
    }
}