import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Informe {
    public String rutacsv = "src\\\\Datos\\\\Inventario.csv";
    public static LocalDate fecha = LocalDate.now();

    public void generarInforme() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutacsv))) {
            String[] encabezado = br.readLine().split(",");
            List<String[]> datos = new ArrayList<>();

            // Leer y almacenar los datos del archivo CSV (excluyendo el encabezado)
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea.split(","));
            }

            // Ordenar los datos por cantidad en inventario de mayor a menor
            Collections.sort(datos, Comparator.comparing((String[] fila) -> Double.parseDouble(fila[1]), Comparator.reverseOrder()));

            // Calcular la longitud máxima de cada columna, incluyendo el encabezado
            int[] longitudesColumnas = new int[encabezado.length];
            for (String[] fila : datos) {
                for (int i = 0; i < fila.length; i++) {
                    longitudesColumnas[i] = Math.max(longitudesColumnas[i], Math.max(fila[i].length(), encabezado[i].length()));
                }
            }

            // Mostrar el encabezado
            StringBuilder lineaFormateada = new StringBuilder();
            for (int i = 0; i < encabezado.length; i++) {
                lineaFormateada.append(String.format("%-" + longitudesColumnas[i] + "s     ", encabezado[i]));
            }
            System.out.println(lineaFormateada.toString().trim());

            // Mostrar los datos en formato de tabla
            for (String[] fila : datos) {
                lineaFormateada = new StringBuilder();
                for (int i = 0; i < fila.length; i++) {
                    lineaFormateada.append(String.format("%-" + longitudesColumnas[i] + "s     ", fila[i]));
                }
                System.out.println(lineaFormateada.toString().trim());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        System.out.println("\n\tInforme realizado el: "+fecha);
    }
}
