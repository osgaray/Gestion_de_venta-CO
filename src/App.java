public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("GESTIÓN DE INVENTARIO");
        AlmacenamientoCSV csvfile = new AlmacenamientoCSV();

        csvfile.crearArchivoCSV("Almacenamiento");
    }
}
