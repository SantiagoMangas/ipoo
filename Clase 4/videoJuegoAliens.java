class videoJuegoAliens {
    public static void main (String a[]){
        NaveEspacial n1,n2,n3;
        Alien a1,a2,a3;
        n1 = new NaveEspacial("V", 550);
        n2 = new NaveEspacial('V', 550);
        n3 = n2;
        a1 = new Alien(n1, 3, 2);
        a2 = new Alien(n2, 2, 3);
        a3 = a1.clone();
        a4 = a1;

        System.out.println(a1==a2);
        System.out.println(a1==a3);
        System.out.println(a1==a4);
        a4.copy(a2);
        a1.recibeHerida();
        System.out.println(a1==a2);
        System.out.println(a1==a3);
        System.out.println(a1==a4);
    }
}
