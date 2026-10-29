public class MedicionServicios {
    // <<Atributos de instancia>>
    private int gas;
    private int agua;
    private int electricidad;

    // <<Constructor>>
    public MedicionServicios(int g, int a, int e) {
        gas = g;
        agua = a;
        electricidad = e;
    }

    // <<Comandos>>
    public void establecerGas(int g) {
        gas = g;
    }

    public void establecerAgua(int a) {
        agua = a;
    }

    public void establecerElectricidad(int e) {
        electricidad = e;
    }

    // <<Consultas>>
    public int obtenerGas() {
        return gas;
    }

    // Nota: Mantengo el nombre "obtenerAgual" tal cual figura en el diagrama UML (es un error de tipeo de la cátedra)
    public int obtenerAgual() {
        return agua;
    }

    public int obtenerElectricidad() {
        return electricidad;
    }

    public float costoServicios() {
        // Multiplico por f para asegurar que Java lo trate como float y no como double
        return (float) (gas * 1.5f + agua * 0.5f + electricidad * 2.0f);
    }
}