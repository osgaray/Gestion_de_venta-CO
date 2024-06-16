import java.time.LocalDate;

public class Informe {
    public static double invTotal;
    public static LocalDate fecha = LocalDate.now();
    public static double ganancias;

    // generar un informe del estado de la caja
    public static void generarInformeCaja(){
        System.out.println("Informe de la caja al " + fecha);
    }
}
