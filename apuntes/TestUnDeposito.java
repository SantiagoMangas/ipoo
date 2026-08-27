public class TestUnDeposito {
    public static void main(String[] a) {
        CtaCteBancaria c1,c2,c3;
        float m=1000;
        c1 = new CtaCteBancaria(111,250);
        c2 = new CtaCteBancaria(112,500);
        c3 = c2;
        c2.depositar(m);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}
