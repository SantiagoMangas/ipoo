class CtaCteBancaria{
    private static final int maxDescubierto = 100;
    private int codigo;
    private float saldo;
    public CtaCteBancaria(int c){
        codigo = c;
        saldo = 0;
    }
    public CtaCteBancaria(int c, float s){
        codigo = c;
        saldo = s;
    }
    public void depositar(float mto){
        saldo = saldo + mto;
    }
    public boolean extraer(float mto){
        boolean puede = true;
        if (saldo + maxDescubierto >= mto)
            saldo = saldo - mto;
        else
            puede = false;
        return puede;
    }
    public int obtenerCodigo(){
        return codigo;
    }
    public float obtenerSaldo(){
        return saldo;
    }
    public String toString(){
        return codigo + " " + saldo;
    }
    public int mayorSaldo(CtaCteBancaria cta){
        int c = 0;
        if (saldo > cta.obtenerSaldo())
            c = codigo;
        else 
            c = cta.obtenerCodigo();
        return c;
    }
    public CtaCteBancaria ctaMayorSaldo(CtaCteBancaria cta){
        CtaCteBancaria aux = null;
        if (saldo < cta.obtenerSaldo())
            aux = cta;
        else
            aux = this;
        return aux;
    }
}