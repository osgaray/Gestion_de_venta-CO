import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public void agregarProducto(Producto producto){
        // metodo para agregar un producto al inventario
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutacsv, true));){
            writer.newLine();
            writer.write(producto.codigo+","+producto.cantidadenInv+","+producto.nombre+","+producto.getCostoUnitario()+","+producto.getCostoTotal()+","+producto.preciounitario+","+producto.ventas);
            System.out.println("Producto agregado exitosamente");
        } catch (IOException IOEx) {
            System.out.println(IOEx);
        }
        
    }

    public void eliminarProducto(String idproducto){
        // metodo para elimnar un producto del inventario usando el identificador del producto
    }

    public void generarInforme(){
        // metodo para genera un informe del inventario
    }

    public void productosBajosStock(){
        // metodo para generar un informe de los productos con stock bajo
        // usar recursividad con el metodo generarInforme (si se puede, sino pues no)
    }
}
