
public class Caja {
    private int dineroTotal;
    private int peso;
    private int cincoPeso;
    private int VeintePesos;
    private int CincuentaPeso;
    private int CienPeso;
    private int DoscientosPeso;
    private int QuinientoPesos;
    private int MilPesos;
    private int Dolares;

    public Caja(int dineroTotal, int peso, int cincoPeso, int VeintePesos, int cincuentaPeso, int CienPeso,
            int DoscientosPeso, int QuinientoPesos, int MilPesos, int Dolares) {
        this.dineroTotal = dineroTotal;
        this.peso = peso;
        this.cincoPeso = cincoPeso;
        this.VeintePesos = VeintePesos;
        this.CienPeso = CienPeso;
        this.DoscientosPeso = DoscientosPeso;
        this.QuinientoPesos = QuinientoPesos;
        this.MilPesos = MilPesos;
        this.Dolares = Dolares;
    }

    public int getDineroTotal() {
        return dineroTotal;
    }

    public void setDineroTotal(int dineroTotal) {
        this.dineroTotal = dineroTotal;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCincoPeso() {
        return cincoPeso;
    }

    public void setCincoPeso(int cincoPeso) {
        this.cincoPeso = cincoPeso;
    }

    public int getVeintePesos() {
        return VeintePesos;
    }

    public void setVeintePesos(int veintePesos) {
        VeintePesos = veintePesos;
    }

    public int getCincuentaPeso() {
        return CincuentaPeso;
    }

    public void setCincuentaPeso(int cincuentaPeso) {
        CincuentaPeso = cincuentaPeso;
    }

    public int getCienPeso() {
        return CienPeso;
    }

    public void setCienPeso(int cienPeso) {
        CienPeso = cienPeso;
    }

    public int getDoscientosPeso() {
        return DoscientosPeso;
    }

    public void setDoscientosPeso(int doscientosPeso) {
        DoscientosPeso = doscientosPeso;
    }

    public int getQuinientoPesos() {
        return QuinientoPesos;
    }

    public void setQuinientoPesos(int quinientoPesos) {
        QuinientoPesos = quinientoPesos;
    }

    public int getMilPesos() {
        return MilPesos;
    }

    public void setMilPesos(int milPesos) {
        MilPesos = milPesos;
    }

    public int getDolares() {
        return Dolares;
    }

    public void setDolares(int dolares) {
        Dolares = dolares;
    }


}
