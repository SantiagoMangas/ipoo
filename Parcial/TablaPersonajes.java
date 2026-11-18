public class TablaPersonajes {
    private Personaje [] t;

    public TablaPersonajes(int max){
        t = new Personaje[max];
    }

    public boolean agregarPersonaje(Personaje p){
        boolean agregado = false;
        if(p != null){
            for(int i = 0; i <t.length && !agregado; i++){
                if(t[i] == null){
                    t[i] = p;
                    agregado = true;
                }
            }
        }
        return agregado;
    }

    public void eliminarMasDebil(){
        posMenor = -1;
        menorFuerza = -1;
        
        for(int i = 0; i < t.length; i++){
            if(t[i] != null && (t[i].obtenerFuerza() < menorFuerza || menorFuerza == -1)){
                menorFuerza = t[i].obtenerFuerza();
                posMenor = i;
            }
        }

        if(posMenor > -1){
            t[posMenor] = null;
        }
    }

    public Personaje obtenerPersonaje(int pos){
        Personaje rta = null;
        if(pos>=0 && pos<t.length){
            t[pos] = rta;
        }
        return rta;
    }
}
