public class Producto {
    public String codigo;
    public double cantidadenInv;
    public String nombre;
    public double costoUnitario;
    public double costoTotal;
    public double preciototal;
    public double ventas;

    // constructor
    public Producto(String codigo, double cantidadenInv, String nombre, double costoUnitario, double costoTotal,double preciototal, double ventas) {
        this.codigo = codigo;
        this.cantidadenInv = cantidadenInv;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
        this.preciototal = preciototal;
        this.ventas = ventas;
    }

    
    
}

