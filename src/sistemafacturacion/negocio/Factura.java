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
       // numFactura = ++totalFacturas;
        setNumFactura(++totalFacturas);
        this.cliente = cliente;
        total = 0;
        fecha = LocalDate.now();
        productos = new Producto[MAX];
        numProductos = 0;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getIva() {
        return iva;
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

    private void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }



    public void agregarProducto(Producto producto){
        if(numProductos < MAX )
            productos[numProductos++] = producto;
        else{
            System.out.println("Ya no se pueden agregar más productos");
        }
    }

    public Producto buscarProducto(String nombre){
        for(int i = 0; i < numProductos; i++){
            if(productos[i].getNombre().equalsIgnoreCase(nombre))
                return productos[i];
        }
        return null;
    }
    public Producto buscarProductoCodigo(String codigo){
        for(int i = 0; i < numProductos; i++){
            if(productos[i].getCodigo().equals(codigo))
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
    @Override
    public String toString(){
       String sb = "";
       sb = "Factura: "+numFactura+"\nFecha: "+fecha.toString()+"\nCedula: "+cliente.getCedula()+
               "\nNombre: "+cliente.getNombre()+"\n";
       sb += "Codigo\tNombre\tCantidad\tPrecioU\tPrecioT\n";
       for(int i = 0; i < numProductos;i++){
           sb += productos[i].getCodigo()+"\t"+productos[i].getNombre()+"\t"+
                   productos[i].getStock()+"\t"+productos[i].getPrecio()+"\t"+
                   productos[i].calcularVenta(productos[i].getStock())+"\n";
        }

       sb += "Subtotal: "+subTotal+"\nIVA: "+iva+"\nTotal: "+total;
        return sb;
    }
}
