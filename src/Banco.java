import java.util.Scanner;

class Banco {
    int i, exist, pin2, num, f=0;
    float cant;
    private final int[] pin = new int[50];
    private final float[] saldo = new float[50];
    private final String[] nombre = new String[50];

    public void inicializar(){
        for(i = 0; i < 50; i++){
            pin[i]=0;
            saldo[i]=0;
            nombre[i]="";
        }
    }

    public void setPin(int pin, int c){
        this.pin[c] = pin;
    }

    public int getPin(int c){
        //pin[c]= pin[c]+1;
        return pin[c];
    }

    public void setSaldo(float saldo,int c) {
        this.saldo[c] = saldo;
    }

    public float getSaldo(int c){
        return saldo[c];
    }

    public void setNombre(String nombre,int c){
        this.nombre[c] = nombre;
    }

    public String getNombre(int c){
        return nombre[c];
    }

    public int buscarU(String user){
        exist=0;
        i=0;

        do{

            if(nombre[i].equals(user) ) exist=1;
            //System.out.println("\n"+exist+nombre[i]+user);

            i++;
        }while(exist==0 && i<50);

        if(exist==1) return(i-1);
        else return(-1);
    }

    public int confirmarPin(int i){
        Scanner scan= new Scanner(System.in);
        System.out.println("\nIngrese el PIN: ");
        pin2 = scan.nextInt();
        //System.out.println("\n"+i+pin[i]+pin2);
        if(pin[i]==pin2) return(1);
        else return(0);
    }


    public void dinero(int i){
        Scanner scan= new Scanner(System.in);
        do{
            f=0;
            System.out.println("""

                    Seleccione una opcion:
                    1.Depositar
                    2.Retirar
                    3.Consultar saldo
                    4.Salir
                    Ingrese un numero:""");
            num = scan.nextInt();

            switch (num) {//switch case para el menu
                case 1 -> {
                    System.out.println("\nIngrese la cantidad a depositar: ");
                    cant = scan.nextFloat();
                    saldo[i] = saldo[i] + cant;
                    System.out.println("\nSaldo actual: " + saldo[i]);
                }
                case 2 -> {
                    System.out.println("\nIngrese la cantidad a retirar: ");
                    cant = scan.nextFloat();
                    if (cant > saldo[i]) System.out.println("\nNo es posible retirar esa cantidad.");
                    else saldo[i] = saldo[i] - cant;
                    System.out.println("\nSaldo actual: " + saldo[i]);
                }
                case 3 -> System.out.println("\nSaldo actual: " + saldo[i]);
                case 4 -> f = 1;
                default -> System.out.println("\n--Ingresa una de las opciones--\n");
            }
        }while(f==0);
    }
}



