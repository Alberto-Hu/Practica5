import java.util.*;

class Main {
    public static void main(String[] args){
        int f=0,num, c=0, i, confirm;
        String user;

        Cuenta client = new Cuenta();
        client.inicializar();

        Scanner sc= new Scanner(System.in);

        do{
            System.out.print(
                    """
                            ---Bienvenido al banco---
                            Seleccione una opcion:
                            1.Crear cuenta nueva
                            2.Usar cuenta existente
                            3.Salir

                            Ingresa numero:\s""");
            num = sc.nextInt();

            switch(num){
                case 1: if(c<50){
                    client.setNombre(client.msgNombre(),c);

                    client.setPin(client.msgPin(),c);

                    client.setSaldo(client.msgSaldo(),c);

                    c++;
                }
                else System.out.println("\nSe sobrepaso el limite de usuarios");
                    break;
                case 2: user = client.usuario();
                    i = client.buscarU(user);
                    if(i!=-1){
                        confirm = client.confirmarPin(i);
                        if(confirm==1) {
                            client.dinero(i);
                        }
                        else System.out.println("\nPIN incorrecto");
                    }
                    else System.out.println("\nNo se encontro el usuario.");

                    break;
                case 3: f=1;
                    break;
                default: System.out.println("\n--Ingresa una de las opciones--\n");
            }
        }while(f==0);

    }
}

class Cuenta extends Banco{

    public int msgPin(){
        Scanner scan= new Scanner(System.in);
        System.out.println("\nIngrese su PIN que se usara para entrar a la cuenta: ");
        return( scan.nextInt() );
    }

    public float msgSaldo(){
        Scanner scan= new Scanner(System.in);
        System.out.println("\nIngrese el Deposito que desee: ");
        return( scan.nextFloat() );
    }

    public String msgNombre(){
        Scanner scan= new Scanner(System.in);
        System.out.println("\nIngrese su nombre: ");
        return( scan.nextLine() );
    }

    public String usuario(){
        Scanner scan= new Scanner(System.in);
        System.out.println("\nIngrese el nombre al que esta registrada la cuenta: ");
        return( scan.nextLine() );
    }
}
