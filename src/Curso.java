public class Curso {
    private String nombre;
    private String codigo;

    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    public void mostrarDetalles() {
        System.out.println("Nombre: " + getNombre() + ", ID: " + codigo);
    }
}
