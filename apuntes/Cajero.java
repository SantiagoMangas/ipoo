public class Cajero {
    public static void main(String[] args) {
        CtaCteBancaria cb;
        cb = new CtaCteBancaria(111);
        System.out.println(cb.toString());
        CtaCteBancaria cb1 = new CtaCteBancaria(112, 500);
        int cod = cb.mayorSaldo(cb1);
        System.out.println(cod);
        CtaCteBancaria c=cb.ctaMayorSaldo(cb1);
    }
}
