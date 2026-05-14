package sistemafacturacion.negocio;

public class Producto {
    private String codigo;
    private String nombre;
    private int stock;
    private double precio;

    public Producto(String codigo, String nombre, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void comprar(int cantidad){
        if(cantidad > 0)
            stock += cantidad;
    }
    public int venderInventario(int cantidad){
        if(cantidad > 0){
            if(cantidad <= stock){
                stock -= cantidad;
                return cantidad;
            }

        }
        return 0;

    }
    public double calcularVenta(int cantidad){
        if(cantidad > 0)
            return precio * cantidad;
        return 0;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}
