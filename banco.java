import java.util.Scanner;

public class banco {
    private String N;
    private double D;
    private short pin;
    private static byte i = 0;
    private cuenta[] usuario = new cuenta[10];

    public void setCuenta(Scanner c) {
        c.nextLine();
        System.out.println("Ingrese su nombre: ");
        N = c.nextLine();
        do {
            System.out.println("Cantidad de dinero para abrir su cuenta: ");
            D = c.nextDouble();
        }while(D <= 0);
        do {
            System.out.println("Ingrese un PIN de 4 digitos: ");
            pin = c.nextShort();
        }while(pin < 1000 || pin > 9999);
        usuario[i++] = new cuenta(N, D, pin);
    }
    public byte iniciarSesion(Scanner c) {
        if(i == 0) {
            System.out.println("No hay cuentas existentes.");
            return -1;
        }
        boolean cuentaE = false;
        byte a = -1;
        c.nextLine();
        System.out.println("Ingrese su PIN: ");
        pin = c.nextShort();
        while(!cuentaE && ++a != i) {
            if(pin == usuario[a].getPin())
                cuentaE = true;
        }
        if( cuentaE && N.equals(usuario[a].getN()) )
            return a;
        else System.out.println("Intente nuevamente.");
        return -1;
    }
    public void lista(byte b, Scanner c) {
        int op;
        do {
            System.out.println("Cuenta:" + usuario[b].getN());
            System.out.println("1 - Depósito de dinero");
            System.out.println("2 - Retiro de dinero");
            System.out.println("3 - Estado de la cuenta");
            System.out.println("4 - Cerrar sesión");
            op = c.nextInt();
            switch(op) {
                case 1: System.out.println("Ingrese la cantidad a depositar: ");
                    D = c.nextDouble();
                    usuario[b].setDeposito(D);
                    break;
                case 2: System.out.println("Ingrese la cantidad a retirar: ");
                    D = c.nextDouble();
                    usuario[b].setRetiro(D);
                    break;

                case 3: getCuenta(b);
            }
        }while(op != 4);
    }
    private void getCuenta(byte b) {
        System.out.println("Nombre: " + usuario[b].getN());
        System.out.println("Saldo: $" + usuario[b].getD());
        System.out.println("PIN: " + usuario[b].getPin());
    }
}


