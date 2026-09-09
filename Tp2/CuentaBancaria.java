package Tp2;

class CuentaBancaria{
    //Atributos de clase, monto máximo para extraer en descubierto
    private static final int maxDescubierto = 1000;
    //Atributos de instancia
    private int codigo;
    private float saldo;
    // Constructores
    //El código se establece al crear la cuenta y no cambia
    public CuentaBancaria(int cod){
        codigo = cod; saldo = 0; }
    public CuentaBancaria(int cod, float sal){
        codigo = cod; saldo = sal; }

    // Comandos
    public void depositar(float mto){
    //Requiere mto > 0
        saldo = saldo + mto; }
    public void extraer(float mto){
    //Requiere mto > 0
        if (puedeExtraer(mto))
            saldo = saldo - mto; }
    // Consultas
    public int obtenerCodigo(){
        return codigo; }
    public float obtenerSaldo(){
        return saldo;}
    public String toString(){
        return codigo + " " + saldo;}
    public boolean puedeExtraer(float mto){
        //Requiere mto > 0
        boolean puede = false;
        if ((-1)*(saldo-mto)<=maxDescubierto)
            puede = true;
        return puede; 
    }
}
