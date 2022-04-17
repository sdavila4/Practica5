import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        byte b;
        int op;
        banco cuenta = new banco();
        Scanner c = new Scanner(System.in);
        do {
            System.out.println("Seleccione una opción: ");
            System.out.println("1 - Crear cuenta");
            System.out.println("2 - Acceder a cuenta existente");
            System.out.println("3 - Salir");
            op = c.nextInt();
            switch(op) {
                case 1: cuenta.setCuenta(c);
                break;
                case 2: b = cuenta.iniciarSesion(c);
                    if(b != -1)
                        cuenta.lista(b, c);
                    break;
                case 3: System.out.println("Salir");
                break;
            }
        }while(op != 3);
        c.close();
    }
}
