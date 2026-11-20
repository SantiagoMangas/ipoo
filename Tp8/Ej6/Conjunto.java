public class Conjunto{
    private Elemento[] ce;
    private int cantElementos;

    public Conjunto(int max){
        ce = new Elemento[max];
        cantElementos = 0;
    }

    public void insertar(Elemento e){
        if (!pertenece(e)) {
            ce[cantElementos] = e;
            cantElementos++;
        }
    }

    // Consultas
    public Elemento obtener(int pos) {
        Elemento res = null;
        if (pos >= 0 && pos < cantElementos) {
            res = ce[pos];
        }
        return res;
    }

    public boolean pertenece(Elemento e) {
        int i = 0;
        boolean encontre = false;
        while (i < cantElementos && !encontre) {
            if (ce[i].esEquivalente(e)) {
                encontre = true;
            } else {
                i++;
            }
        }
        return encontre;
    }
}