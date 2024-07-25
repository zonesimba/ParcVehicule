
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Park pk=new Park();
        Scanner Clavier = new Scanner(System.in);
        int s = 0;
        while(s!=1){

            System.out.print("Commande :");
            String cmd = Clavier.nextLine();
            if(cmd.toLowerCase(Locale.ROOT).equals("nvoiture")){

                System.out.print("Nom du Vehicule");
                String nom=Clavier.nextLine();
                System.out.print("1:voiture,2.moto,3.Camion");
                int type = Clavier.nextInt();
                switch (type){
                    case 1 -> pk.nvVoiture(new Voiture(nom));
                    case 2 -> pk.nvVoiture(new Moto(nom));
                    case 3 -> pk.nvVoiture(new Camion(nom));
                }
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("rmvoiture")){

                System.out.print("ID du Vehicule");
                int id = Clavier.nextInt();
                pk.rmVoiture(id);
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("lkvoiture")){

                System.out.print("Mark du Vehicule");
                String nom = Clavier.nextLine();
                pk.lookVehicule(nom);
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("lkvoiturep")){

                System.out.print("Lettre du Vehicule");
                String nom = Clavier.nextLine();
                pk.lookVehiculeParL(nom.charAt(0));
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("mdvoiture")){

                System.out.print("ID du Vehicule");
                int id = Clavier.nextInt();
                System.out.print("Nouvelle Mark du Vehicule");
                String nom = Clavier.nextLine();
                System.out.print("1:voiture,2.moto,3.Camion");
                int type = Clavier.nextInt();
                switch (type){
                    case 1 -> pk.modifVehicule(id,nom,"voiture");
                    case 2 -> pk.modifVehicule(id,nom,"moto");
                    case 3 -> pk.modifVehicule(id,nom,"camion");
                }
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("list")){

                pk.printl();
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("listtype")){

                System.out.print("1:voiture,2.moto,3.Camion");
                int type = Clavier.nextInt();
                switch (type){
                    case 1 -> pk.listeVehiculeType("voiture");
                    case 2 -> pk.listeVehiculeType("moto");
                    case 3 -> pk.listeVehiculeType("camion");
                }
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("listnbr")){

                pk.nbrVehicule();
            }
            else if(cmd.toLowerCase(Locale.ROOT).equals("listnbrtype")){

                System.out.print("1:voiture,2.moto,3.Camion");
                int type = Clavier.nextInt();
                switch (type){
                    case 1 -> pk.nbrVehiculeType("voiture");
                    case 2 -> pk.nbrVehiculeType("moto");
                    case 3 -> pk.nbrVehiculeType("camion");
                }
            }
        }

    }
}
