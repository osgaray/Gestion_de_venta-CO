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
    
    public void crearNuevoInventario(){
        // crear archivo csv
        try (FileWriter writer = new FileWriter(rutacsv);){
            // encabezado
            writer.write("CODIGO,CANTIDAD EN INVENTARIO,NOMBRE,COSTO UNITARIO,COSTO TOTAL,PRECIO UNITARIO,VENTAS");
        } catch (IOException IOEx) {
                System.out.println(IOEx);
        } 
    }

    public void eliminarInventario(){
        // metodo para eliminar el archivo usando rutacsv
    }

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
                    float cantidad = Float.parseFloat(campos[1]);
                    cantidad += producto.cantidadenInv;
                    campos[1] = String.valueOf(cantidad);
    
                    // Volver a la posición inicial de la línea y actualizarla en el archivo
                    raf.seek(posicionInicial);
                    raf.writeBytes(String.join(",", campos));
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
                    writer.write(producto.codigo + "," + producto.cantidadenInv + "," + producto.nombre + "," +
                            producto.getCostoUnitario() + "," + producto.getCostoTotal() + "," + producto.preciounitario + "," + producto.ventas);
                    System.out.println("Producto agregado exitosamente");
                } catch (IOException IOEx) {
                    System.out.println(IOEx);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void eliminarProducto(String idproducto){
     // metodo para elimnar un producto del inventario usando el identificador del producto
    List<String> ProDele = new ArrayList<>();
    String linea;
    
    try (BufferedReader br = new BufferedReader(new FileReader(rutacsv))) {
        while ((linea = br.readLine()) != null) {
            if (!linea.contains(idproducto)) {
                ProDele.add(linea);
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutacsv))) {
        for (String nuevaLinea : ProDele) {
            bw.write(nuevaLinea);
            bw.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error al escribir en el archivo: " + e.getMessage());
    }
}


    public void generarInforme(){
        // metodo para genera un informe del inventario
    }

    public void productosBajosStock(){
        // metodo para generar un informe de los productos con stock bajo
        // usar recursividad con el metodo generarInforme (si se puede, sino pues no)
    }
}
