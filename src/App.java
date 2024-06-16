public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("GESTIÓN DE INVENTARIO");
        Inventario csvfile = new Inventario();

        csvfile.crearInventario("Almacenamiento");
    }
}
