import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

public class App {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("-- GESTIÓN DE INVENTARIO Y CAJA --");
        Inventario inv = new Inventario();

        boolean continuar = true;
        do {
            try {

                System.out.println("Elige la opcion a realizar: ");
                System.out.println("1. Realizar una venta");
                System.out.println("2. Realizar una compra");
                System.out.println("3. Generar informe");
                System.out.println("4. Eliminar productos");
                System.out.println("5. Mostrar productos con bajo stock");
                System.out.println("6. Salir");
                int opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1:
                        inv.productosBajosStock();
                        break;
                    case 2:
                        System.out.println("\nDetalles del producto que se ha comprado: ");
                        System.out.println("Codigo del producto: ");
                        String cod = input.nextLine();
                        System.out.println("Cantidad de producto/s: ");
                        double cantPro = input.nextDouble();
                        input.nextLine();
                        System.out.println("Nombre del producto: ");
                        String nombre = input.nextLine();
                        double costo;
                        double precio;
                        do {
                            System.out.println("El costo debe ser menor que el precio");
                            System.out.println("Costo del producto: ");
                            costo = input.nextDouble();
                            input.nextLine();
                            System.out.println("Precio del producto: ");
                            precio = input.nextDouble();
                            input.nextLine();
                        } while (costo>=precio);
                        Producto pro_agregar = new Producto(cod,cantPro,nombre,costo,costo*cantPro,precio,0);
                        inv.agregarProducto(pro_agregar);
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        System.out.println("\nIngrese el código del producto a eliminar: ");
                        String codigoEliminar = input.nextLine();
                        inv.eliminarProducto(codigoEliminar);
                        System.out.println("Producto eliminado exitosamente.");
                        break;
                    case 5:
                        System.out.println("Productos con bajo stock: ");
                        inv.productosBajosStock();
                    case 6:
                        System.out.println("Saliendo...");
                        System.out.println("Ultimo uso registrado: " + LocalDate.now()+" a las "+LocalTime.now());
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");;
                        break;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
            
        } while (continuar);
    }
}
