import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Inventario {
    // ruta del archivo csv como atributo privado
    private String rutacsv;
    
    public void crearInventario(String nombrearchivo){
        // ruta del archivo csv
        rutacsv = "src\\Datos\\"+nombrearchivo+".csv";

        // crear archivo csv
        try {
            FileWriter writer = new FileWriter(rutacsv);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("");
            // comprobar si el archivo existe
        } catch (IOException IOEx) {
                System.out.println(IOEx);
        } 
    }

    public void eliminarArchivoCSV(String nombrearchivo){
        // metodo para eliminar el archivo usando rutacsv
    }

    public void agregarProducto(Object producto){
        // metodo para agregar un producto al inventario
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
