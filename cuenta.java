public class cuenta {
    private String N;
    private double D;
    private short pin;

    public cuenta(String N, double D, short pin) {
        this.N = N;
        this.D = D;
        this.pin = pin;
    }
    public void setN(String N) {
        this.N = N;
    }
    public void setD(double D) {
        this.D = D;
    }
    public void setPin(short pin) {
        this.pin = pin;
    }
    public String getN() {
        return N;
    }
    public double getD() {
        return D;
    }
    public short getPin() {
        return pin;
    }
    public void setDeposito(double deposito) {
        if(deposito > 0)
            D += deposito;
        else System.out.println("No valido.");
    }
    public void setRetiro(double retiro) {
        if(retiro <= D)
            D -= retiro;
        else System.out.println("No valido.");
    }
}
