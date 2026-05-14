package sistemafacturacion.utilitario;

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

    public void agregarCliente(String cedula, String nombre, String direccion, String telefono){
        Cliente c = buscarCliente(cedula);
        if(c == null){
            clientes.add(new Cliente(cedula,nombre,direccion,telefono));
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
    public void agregarFactura(Cliente cliente){
        facturas.add(new Factura(cliente));
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
}
