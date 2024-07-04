import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    // ruta del archivo csv como atributo privado
    public String rutacsv = "src\\\\Datos\\\\Inventario.csv";    

    // metodo para agregar producto al inventario
    public void agregarProducto(Producto producto) {
        try {
            // Abrir el archivo CSV en modo de solo lectura
            RandomAccessFile raf = new RandomAccessFile(rutacsv, "rw");
    
            String linea;
            long posicionInicial = 0;
            boolean encontrado = false;
    
            // Iterar sobre cada línea del archivo CSV
            while ((linea = raf.readLine()) != null) {
                String[] campos = linea.split(",");
    
                // Verificar si el código del producto coincide con el código del producto a agregar
                if (campos[0].equals(producto.codigo)) {
                    encontrado = true;
    
                    // Incrementar la cantidad del producto existente
                    double cantidad = Float.parseFloat(campos[1]);
                    cantidad += producto.cantidadenInv;
                    campos[1] = String.valueOf(cantidad);
    
                    // Volver a la posición inicial de la línea y actualizarla en el archivo
                    raf.seek(posicionInicial);
                    raf.writeBytes(String.join(",", campos));
                    System.out.println("Producto agregado");
                    break;
                }
    
                // Guardar la posición inicial de la línea actual
                posicionInicial = raf.getFilePointer();
            }
    
            // Cerrar el archivo RandomAccessFile
            raf.close();
    
            // Si no se encontró el producto, agregar una nueva línea al archivo CSV
            if (!encontrado) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutacsv, true))) {
                    writer.newLine();
                    writer.write(producto.codigo + "," + producto.cantidadenInv + "," + producto.nombre + "," +producto.getCostoUnitario() + "," + producto.getCostoTotal() + "," + producto.preciounitario + "," + producto.ventas);
                    System.out.println("Producto agregado exitosamente");
                } catch (IOException IOEx) {
                    System.out.println(IOEx);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // metodo para disminuir la cantidad de productos en el inventario
    public void disminuirProducto(String idproducto, double cantidad){
        try {
            // Abrir el archivo CSV en modo de solo lectura
            RandomAccessFile raf = new RandomAccessFile(rutacsv, "rw");
    
            String linea;
            long posicionInicial = 0;
            boolean encontrado = false;
    
            // Iterar sobre cada línea del archivo CSV
            while ((linea = raf.readLine()) != null) {
                String[] campos = linea.split(",");
    
                // Verificar si el código del producto coincide con el código del producto a agregar
                if (campos[0].equals(idproducto)) {
                    encontrado = true;
    
                    // Incrementar la cantidad de ventas y disminuir la cantidad de productos
                    double ventas = Float.parseFloat(campos[6]);
                    double cantidadProductos = Float.parseFloat(campos[1]);
                    ventas =+ cantidad;
                    cantidadProductos = cantidadProductos - cantidad;
                    campos[6] = String.valueOf(ventas);
                    campos[1] = String.valueOf(cantidadProductos);
                    // actualizar costo total
                    double costo = Float.parseFloat(campos[3]);
                    double costototal = Float.parseFloat(campos[4]);
                    costototal = costo * cantidadProductos;
                    campos[4] = String.valueOf(costototal);
    
                    // Volver a la posición inicial de la línea y actualizarla en el archivo
                    raf.seek(posicionInicial);
                    raf.writeBytes(String.join(",", campos));
                    System.out.println("Venta agregada");
                    break;
                }
    
                // Guardar la posición inicial de la línea actual
                posicionInicial = raf.getFilePointer();
            }
    
            // Cerrar el archivo RandomAccessFile
            raf.close();
    
            // Si no se encontró el producto, agregar una nueva línea al archivo CSV
            if (!encontrado) {
                System.out.println("El producto no esta en el inventario");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // metodo para elimnar un producto del inventario usando el identificador del producto
    public void eliminarProducto(String idproducto){
        List<String> ProDele = new ArrayList<>();
        String linea;
        boolean encontrado = false;
        
        // obtener todas las lineas del archivo MENOS el producto que se desea eliminar
        try (BufferedReader br = new BufferedReader(new FileReader(rutacsv))) {
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(idproducto)) {
                    ProDele.add(linea);
                }else{
                    encontrado=true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // escribir todas las lineas del archivo sin el producto a eliminar
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutacsv))) {
            for (String nuevaLinea : ProDele) {
                bw.write(nuevaLinea);
                // si el producto a escribir no es el ultimo, agregar un salto de linea
                if (ProDele.get(ProDele.size()-1)!=nuevaLinea){
                    bw.newLine();
                }

            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        if (encontrado){
            System.out.println("\nProducto eliminado exitosamente\n");
        }else{
            System.out.println("\nEl producto no existe\n");
        }
    }
    // imprimir los productos con bajas en stock
    public void productosBajosStock(){
        String producto;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutacsv))) {
            br.readLine();
            while ((producto = br.readLine()) != null) {
                String[] listTemp = producto.split(",");
                double cantidad= Double.parseDouble(listTemp[1]);
                if (cantidad<5) {
                    System.out.println("El producto con el codigo "+listTemp[0]+" tiene un stock bajo de: "+listTemp[01]);
                    
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }        
    }
}
