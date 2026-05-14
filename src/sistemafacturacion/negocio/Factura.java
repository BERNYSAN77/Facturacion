package sistemafacturacion.negocio;
import java.time.LocalDate;

public class Factura {
    // atributos de clase
    private static final double IVA = 0.15;
    private static int totalFacturas = 0;
    private static final int MAX = 20;

    //atributos de instancia
    private int numFactura;
    private LocalDate fecha;
    private Cliente cliente;
    private double total;
    private Producto productos[];
    private int numProductos;
    private double subTotal;
    private double iva;

    public Factura(Cliente cliente){
        numFactura = ++totalFacturas;
        this.cliente = cliente;
        total = 0;
        fecha = LocalDate.now();
        productos = new Producto[MAX];
        numProductos = 0;
    }

    public static int getTotalFacturas() {
        return totalFacturas;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto){
        if(numProductos < MAX )
            productos[numProductos++] = producto;
    }

    public Producto buscarProducto(String nombre){
        for(int i = 0; i < numProductos; i++){
            if(productos[i].getNombre().equals(nombre))
                return productos[i];
        }
        return null;
    }
    private void calcularSubTotal(){
        subTotal = 0;
        for(int i = 0; i < numProductos; i++){
            subTotal += productos[i].calcularVenta(productos[i].getStock());
        }

    }
    private void calcularIva(){
        iva = subTotal*IVA;
    }
    public void calcularTotal(){
        calcularSubTotal();
        calcularIva();
        total = subTotal + iva;
    }
}
