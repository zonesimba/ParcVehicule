
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Park pk=new Park();
        pk.nvVoiture(new Vehicule("Toyota", "Berline"));
        pk.nvVoiture(new Vehicule("Honda", "SUV"));
        pk.nvVoiture(new Vehicule("Ford", "Pickup"));
        Scanner Clavier = new Scanner(System.in);
        int s = 0;
        while(s!=1){

            System.out.print("COmmande :");
            String cmd = Clavier.nextLine();
            if(cmd.toUpperCase(Locale.ROOT).equals("nvoiture")){

                System.out.print("Nom du Vehicule");
                String nom=Clavier.nextLine();
                System.out.print("1:voiture,2.moto,3.Camion");
                int type = Clavier.nextInt();
                switch (type){
                    case 1:
                }
            }
        }
        pk.savelist("vehicle_list.txt");
    }
}
