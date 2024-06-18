public class Producto {
    public String codigo;
    public double cantidadenInv;
    public String nombre;
    private double costoUnitario;
    private double costoTotal;
    public double preciounitario;
    public double ventas = 0;

    // constructor
    public Producto(String codigo, double cantidadenInv, String nombre, double costoUnitario,double preciounitario, double ventas) {
        this.codigo = codigo;
        this.cantidadenInv = cantidadenInv;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.preciounitario = preciounitario;
        this.ventas = ventas;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    
}

