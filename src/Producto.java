public class Producto {
    public String nombre;
    public double precio;
    public double cantidadstock;
    private String identificador;

    // constructor
    public Producto(String nombre, double precio, double cantidadstock, String identificador){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadstock = cantidadstock;
        this.identificador = identificador;
    }

    // getter y setter
    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }
    public String getIdentificador(){
        return identificador;
    }
}

