import java.util.Scanner;

public class App {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("-- GESTIÓN DE INVENTARIO Y CAJA --");
        Inventario inv = new Inventario();

        Informe info = new Informe();
        Producto prod = new Producto("001",10, "Pan", 0.5, 1, 2);

        inv.agregarProducto(prod);

        boolean continuar = true;
        do {
            try {
                System.out.println("Elige la opcion a realizar: ");
                System.out.println("1. Realizar una venta");
                System.out.println("2. Realizar una compra");
                System.out.println("3. Generar informe");
                System.out.println("4. Salir");
                int opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1:

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
                        Producto pro_agregar = new Producto(cod,cantPro,nombre,0,0,0);
                        break;
                    case 3:
                        info.generarInforme();
                        break;
                    case 4:
                        
                        break;
                
                    default:
                        break;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
            
        } while (continuar);
    }
}
