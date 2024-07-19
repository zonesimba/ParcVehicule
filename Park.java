
import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Park {

    private Map<Integer,Vehicule> stock = new HashMap<>();
    private int key = 0;

    public void nvVoiture(Vehicule v){

        this.stock.put(this.key,v);
        this.key = this.key+1;
    }
    public void rmVoiture(int ID){

        boolean exist = this.stock.containsKey(ID);
        if(exist == true){

            this.stock.remove(ID);
        }
    }

    public void modifVehicule(int ID,String mark,String type){

        boolean exist = this.stock.containsKey(ID);
        if(exist){

            this.stock.get(ID).setMark(mark);
            this.stock.get(ID).setType(type);
        }
    }

    public void printl(){

        System.out.println("==============");
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            System.out.println(v.getKey().toString()+",ID"+v.getValue());
        }
        System.out.println("==============");

    }

    public void lookVehicule(String mark){

        boolean trouver = false;
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getMark().equals(mark)){

                System.out.println(v.getValue().toString());
                trouver = true;
                break;
            }
        }
        if(trouver == false){

            System.out.println("Aucun Vehicule ne correspond a votre Recherche");
        }
    }

    public  void lookVehiculeParL(char l){

        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getMark().charAt(0) == l){

                System.out.println(v.getValue().toString());
            }
        }
    }
    public void nbrVehicule(){

        System.out.println("Il y'a "+this.key+" vehicule(s) en stock");
    }
    public void nbrVehiculeType(String type){

        int nombre = 0;
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getType().equals(type)){
                nombre = nombre+1;
            }
        }
        System.out.println("il y'a "+nombre+" vehicule(s) de Type "+type);
    }
    public void listeVehiculeType(String type){

        System.out.println(type.toUpperCase(Locale.ROOT));
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getType().equals(type)){

                System.out.println(v.getValue().toString());
            }
        }
    }

    public void savelist(String filepath) {
        try {
            FileWriter Write = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(Write);

            for (Map.Entry<Integer, Vehicule> entry : this.stock.entrySet()){
                int id  = entry.getKey();
                Vehicule vehicle = entry.getValue();
                String line = id + "," + vehicle.getMark() + "," + vehicle.getType();

                bw.write(line);
                bw.newLine();
            }
            bw.close();
            Write.close();

            System.out.println("liste enregistre dans le fichier" + filepath);
        } catch (IOException e) {
            System.out.println("erreur lors de l'enregistrement du vehicule" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public void loadlistVehicle(String filepath){
        try{
            FileReader fr  = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String mark = parts[1];
                String type = parts[2];
                Vehicule vehicle = new Vehicule(mark, type);
                this.stock.put(id, vehicle);
                this.key = Math.max(this.key, id + 1);

            }
            br.close();
            fr.close();
            System.out.println("Liste des véhicules chargée depuis le fichier " + filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement de la liste des véhicules : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
