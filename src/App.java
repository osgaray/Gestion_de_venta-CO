import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("\tGesti\u00F3n de inventario");
        System.out.println();
        Inventario inv = new Inventario();
        Informe info = new Informe();

        boolean continuar = true;
        do {
            try {
                // menu
                System.out.println("\tElige la opcion a realizar: ");
                System.out.println();
                System.out.println("|--------------------------------------------|");
                System.out.println("|\t1. Realizar una venta                |");
                System.out.println("|\t2. Abastecer inventario              |");
                System.out.println("|\t3. Generar informe                   |");
                System.out.println("|\t4. Eliminar productos                |");
                System.out.println("|\t5. Mostrar productos con bajo stock  |");
                System.out.println("|\t6. Salir                             |");
                System.out.println("|--------------------------------------------|");
                System.out.println();
                while (!input.hasNextInt()) {
                    System.out.println("Ingrese una opci\u00F3n:  ");
                    input.next();
                }

                int opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("\nDetalles del producto que se ha vendido: ");
                        System.out.println("Codigo del producto: ");
                        String codigo = input.nextLine();
                        System.out.println("Cantidad vendida: ");
                        double cantidad = input.nextDouble();
                        input.nextLine();
                        inv.disminuirProducto(codigo, cantidad);
                        break;
                    case 2:
                        System.out.println("\nDetalles del producto que se ha comprado: ");
                        System.out.println("Codigo del producto: ");
                        String cod = input.nextLine();
                        System.out.println("Cantidad de producto/s: ");
                        int cantPro = 0;
                        while (true) {
                            if (input.hasNextInt()) {
                                cantPro = input.nextInt();
                                input.nextLine();
                                if (cantPro >= 1) {
                                    break; // Salir del bucle si la cantidad es válida
                                } else {
                                    System.out.println("Ingrese una cantidad mayor que cero: ");
                                }
                            } else {
                                System.out.println("Ingrese una cantidad entera: ");
                                input.next(); // Descarta la entrada no válida
                            }
                        }
                        // verificar si el producto ya esta en el inventario
                        String linea;

                        // obtener todas las lineas del archivo MENOS el producto que se desea eliminar
                        try (BufferedReader br = new BufferedReader(new FileReader(inv.rutacsv))) {
                            // saltarse el encabezado
                            br.readLine();
                            boolean encontrado = false;
                            while ((linea = br.readLine()) != null && !encontrado) {
                                String[] productoexistente = linea.split(",");
                                if (productoexistente[0].equals(cod)) {
                                    encontrado = true;
                                    System.out.println("Nombre del producto: ");
                                    String nombre = input.nextLine();
                                    int costo = 0;
                                    int precio;
                                    do {
                                        System.out.println("El costo debe ser menor que el precio");
                                        System.out.println("Costo del producto: ");
                                        while (true) {
                                            if (input.hasNextInt()) {
                                                costo = input.nextInt();
                                                input.nextLine();
                                                if (costo >= 1) {
                                                    break; // Salir del bucle si la cantidad es válida
                                                } else {
                                                    System.out.println("Ingrese una cantidad mayor que cero: ");
                                                }
                                            } else {
                                                System.out.println("Ingrese una cantidad entera: ");
                                                input.next(); // Descarta la entrada no válida
                                            }
                                        }

                                        System.out.println("Precio del producto: ");
                                        while (true) {
                                            if (input.hasNextInt()) {
                                                precio = input.nextInt();
                                                input.nextLine();
                                                if (precio >= 1) {
                                                    break; // Salir del bucle si la cantidad es válida
                                                } else {
                                                    System.out.println("Ingrese una cantidad mayor que cero: ");
                                                }
                                            } else {
                                                System.out.println("Ingrese una cantidad entera: ");
                                                input.next(); // Descarta la entrada no válida
                                            }
                                        }
                                    } while (costo >= precio);
                                    double ventas = Double.parseDouble(productoexistente[6]);
                                    Producto pro_agregar = new Producto(cod, cantPro, nombre, costo, costo * cantPro,
                                            precio, ventas);
                                    inv.agregarProducto(pro_agregar);
                                } else {
                                    double costo = Double.parseDouble(productoexistente[3]);
                                    double precio = Double.parseDouble(productoexistente[5]);
                                    Producto pro_agregar = new Producto(cod, cantPro, productoexistente[2], costo,
                                            costo * cantPro, precio, 0);
                                    inv.agregarProducto(pro_agregar);
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo: " + e.getMessage());
                        }

                        break;
                    case 3:
                        System.out.println("Generación de informe: ");
                        info.generarInforme();
                        break;
                    case 4:
                        System.out.println("\nIngrese el código del producto a eliminar: ");
                        String codigoEliminar = input.nextLine();
                        inv.eliminarProducto(codigoEliminar);
                        break;
                    case 5:
                        System.out.println("Productos con bajo stock: ");
                        inv.productosBajosStock();
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        System.out.println("Ultimo uso registrado: " + LocalDate.now() + " a las " + LocalTime.now());
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } while (continuar);
    }
}