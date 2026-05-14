package sistemafacturacion.interfaz;

import sistemafacturacion.negocio.Cliente;
import sistemafacturacion.negocio.Factura;
import sistemafacturacion.negocio.Producto;
import sistemafacturacion.util.SistemaVenta;

import java.util.Scanner;

public class MainFacturacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaVenta sv = new SistemaVenta();
        sv.cargarClientes();
        sv.cargarProductos();
        int op;
        do{
            menu();
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 3:{
                    System.out.println(sv.mostrarClientes());
                }break;
                case 4:{
                    System.out.println(sv.mostrarProductos());
                }break;
                case 6:{
                    String cedula;
                    System.out.print("Ingrese la cedula del cliente: ");
                    cedula = sc.nextLine();
                    int continuar = 1;
                    Cliente c = sv.buscarCliente(cedula);
                    if(c != null){
                        Factura f = new Factura(c);
                        sv.agregarFactura(f);
                        while(continuar == 1){
                            System.out.println("Ingrese codigo producto a facturar");
                            String codigo = sc.nextLine();
                            Producto p = sv.buscarProducto(codigo);//inventario
                            if(p != null){
                                System.out.println("Ingrese la cantidad: ");
                                int cantidad = Integer.parseInt(sc.nextLine());
                                int venta = p.venderInventario(cantidad);
                                if(venta > 0){
                                    f.agregarProducto(new Producto(p.getCodigo(),p.getNombre(),cantidad,p.getPrecio()));//producto de mi factura
                                }else{
                                    System.out.println("no hay suficiente stock");
                                }
                            }else{
                                System.out.println("No existe ese producto");
                            }
                            System.out.printf("1 para continuar, cualquier nùmero para salir");
                            continuar = Integer.parseInt(sc.nextLine());
                        }
                        f.calcularTotal();
                    }else{
                        System.out.println("Cliente no registrado");
                    }
                }
            }

        }while(op != 7);

    }
    public static void menu(){
        System.out.println("***********Papelerìa Mi Vecina**********");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Agregar producto");
        System.out.println("3. Mostrar clientes");
        System.out.println("4. Mostrar productos");
        System.out.println("5. Buscar productos");
        System.out.println("6. Facturar");
        System.out.println("7. Buscar factura");
        System.out.println("8. Salir");
        System.out.print("Ingrese una opción: ");
    }
}
