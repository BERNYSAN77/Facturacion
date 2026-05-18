package sistemafacturacion.util;

import sistemafacturacion.negocio.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaVenta {
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Factura> facturas;

    public SistemaVenta(){
        clientes = new ArrayList<Cliente>();
        productos = new ArrayList<Producto>();
        facturas = new ArrayList<Factura>();
    }
    public void cargarClientes(){
        clientes.add(new Cliente("1","juan","Quito","099856"));
        clientes.add(new Cliente("2","pedro","Sangolqui","099999"));
        clientes.add(new Cliente("3","maria","Machachi","098888"));
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void cargarProductos(){
        productos.add(new Producto("1","cartuchera",50,5.4));
        productos.add(new Producto("2","cartulina",200,0.15));
        productos.add(new Producto("3","esfero",50,1.85));
    }

    public void agregarCliente(String cedula, String nombre, String direccion, String telefono){
        Cliente c = buscarCliente(cedula);
        if(c == null){
            clientes.add(new Cliente(cedula,nombre,direccion,telefono));
        }else
            System.out.println("Cliente ya existe");
    }
    public void agregarProducto(String codigo, String nombre, int stock, double precio){
        Producto p = buscarProducto(codigo);
        if(p == null){
            productos.add(new Producto(codigo,nombre,stock,precio));
        }else
            System.out.println("Cliente ya existe");
    }
    public Cliente buscarCliente(String cedula){
        for(int i=0;i< clientes.size();i++){
            if(clientes.get(i).getCedula().equals(cedula)){
                return clientes.get(i);
            }
        }
        return null;
    }

    public Producto buscarProducto(String codigo){
        for(int i=0;i< productos.size();i++){
            if(productos.get(i).getCodigo().equals(codigo)){
                return productos.get(i);
            }
        }
        return null;
    }
    public Producto buscarProductoNombre(String nombre){
        for(int i=0;i< productos.size();i++){
            if(productos.get(i).getCodigo().equals(nombre)){
                return productos.get(i);
            }
        }
        return null;
    }
    public void agregarFactura(Factura f){
        facturas.add(f);
    }
    public Factura buscarFactura(int numFactura){
        for(Factura f:facturas){
            if(f.getNumFactura() == numFactura){
                return f;

            }
        }
        return null;
    }
    public List<Factura> buscarFacturaCliente(String cedula){
        List<Factura> lista = new ArrayList<Factura>();
        for(int i = 0; i < facturas.size();i++){
            if(facturas.get(i).getCliente().getCedula().equals(cedula)){
                lista.add(facturas.get(i));
            }
        }
        return lista;
    }

   /* public void agregarProductoFactura(Factura f,String codigo, String nombre, int stock, double precio){
        f.agregarProducto(new Producto(codigo,nombre,stock,precio));
    }*/

    public String mostrarClientes(){
        String listaCliente = "";
        for(Cliente c: clientes){
            listaCliente += c.toString();
            listaCliente += "\n";
        }
        return listaCliente;
    }
    public String mostrarProductos(){
        StringBuilder sb = new StringBuilder();
        for(Producto c: productos){
            sb.append(c);
            sb.append("\n");
        }
        return sb.toString();
    }
    public String mostrarColeccion(ArrayList lista){
        StringBuilder sb = new StringBuilder();
        for(Object c: lista){
            sb.append(c);
            sb.append("\n");
        }
        return sb.toString();
    }
}