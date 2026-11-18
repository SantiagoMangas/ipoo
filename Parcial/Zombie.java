public class Zombie extends Personaje{
    private int velocidad;
    private boolean casco;

    public Zombie(int s, int f, int vel, boolean c){
        super(s,f);
        casco = c;
        velocidad = vel;
    }

    public int obtenerVelocidad(){
        return velocidad;
    }

    public boolean tieneCasco(){
        return casco;
    }

    public boolean equals(Personaje p){
        boolean eq = false;
        if(p != null){
            if(p == this){
                eq = true;
            } else {
                if(getClass() == p.getClass()){
                    Zombie z = (Zombie) p;
                    eq = super.equals(p) &&
                        velocidad == z.obtenerVelocidad() &&
                        casco == z.tieneCasco();
                }
            }
        }
        return eq;
    }

    //comandos
    public void recibirAtaque(int d){
        if(tieneCasco()){
            super.recibirAtaque(d/2);
        } else{
            super.recibirAtaque(d);
        }

        if(salud < 0){
            salud = 0;
        }
    }

    public void atacar(Personaje p){
        if(casco && velocidad > 2){
            p.recibirAtaque(fuerza*2);
        }else{
            super.atacar(p);
        }
    }
}
