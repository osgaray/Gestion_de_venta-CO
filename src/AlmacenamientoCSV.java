import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AlmacenamientoCSV {
    // ruta del archivo csv como atributo privado
    private String rutacsv;
    
    public void crearArchivoCSV(String nombrearchivo){
        // ruta del archivo csv
        rutacsv = "src\\"+nombrearchivo+".csv";

        // crear archivo csv
        try {
            File archivo = new File(rutacsv);
            // comprobar si el archivo existe
            if (!archivo.exists()) {
                // escribir el encabezado
                archivo.createNewFile();
                // escribir encabezado
                FileWriter fw = new FileWriter(rutacsv);
                fw.write("PRODUCTO,PRECIO,CANTIDAD EN STOCK,IDENTIFICADOR\n");
                System.out.println("Archivo creado exitosamente");
                fw.close();
            } else {
                System.out.println("El archivo ya existe");
            }
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
