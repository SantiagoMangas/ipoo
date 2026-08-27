public class TestUnaCuenta {
    public static void main (String a[]){
        CtaCteBancaria cb = new CtaCteBancaria(111,250);
        cb.depositar(1000);
        System.out.println(cb.obtenerCodigo()+" "+cb.obtenerSaldo());
    }
}
