
import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Park {

    private int key = 0;

    public void nvVoiture(Vehicule v){

        String type = v.getType();
        String makr = v.getType();
        boolean r = DBManager.RQt(DatabaseConnection.getInstance(),"INSERT INTO listvehicule(id,type,mark)VALUES(NULL,'"+type+"','"+makr+"')");
        if(r) System.out.println("Insertion Faite");
        else System.out.println("Insertion pas Faite");
    }
    public void rmVoiture(int ID){

        boolean r = DBManager.RQt(DatabaseConnection.getInstance(),"DELETE FROM listevehicule WHERE id="+ID+"");
        if(r) System.out.println("Suppression Faite");
        else System.out.println("Suppresion no faite");
    }

    public void modifVehicule(int ID,String mark,String type){

        boolean r = DBManager.RQt(DatabaseConnection.getInstance(),"UPDATE listevehicule SET type='"+type+"',mark='"+mark+"' WHERE id="+ID+"");
        if(r) System.out.println("Modification Faite");
        else System.out.println("Modification non faite");
    }

    public void printl(){

        System.out.println("==============");
        System.out.println(" ID  :  TYPE  :  MARK  ");
        Map<Integer,Vehicule> r = DBManager.RQ(DatabaseConnection.getInstance(),"SELECT * FROM listevehicule");
        for(Map.Entry<Integer,Vehicule> v:r.entrySet()){

            System.out.println(v.getKey()+" : "+v.getValue().toString());
        }
    }

    public void lookVehicule(String mark){

        Map<Integer,Vehicule> r = DBManager.RQ(DatabaseConnection.getInstance(),"SELECT * FROM listevehicule WHERE mark LIKE '%"+mark+"%'");
        if(r.isEmpty()) System.out.println("Aucun vehicule ne correpsond");
        else{

            for(Map.Entry<Integer,Vehicule> v:r.entrySet()){

                System.out.println(v.getKey()+" : "+v.getValue().toString());
            }
        }

    }

    public  void lookVehiculeParL(char l){

        Map<Integer,Vehicule> r = DBManager.RQ(DatabaseConnection.getInstance(),"SELECT * FROM listevehicule WHERE mark LIKE '%"+l+"%'");
        if(r.isEmpty()) System.out.println("Aucun vehicule ne correpsond");
        else{

            for(Map.Entry<Integer,Vehicule> v:r.entrySet()){

                System.out.println(v.getKey()+" : "+v.getValue().toString());
            }
        }
    }
    public void nbrVehicule(){

        int r = DBManager.RQc(DatabaseConnection.getInstance(),"SELECT COUNT(*) FROM listevehicule");
        System.out.println("Nombre de vehicule  = "+r);
    }
    public void nbrVehiculeType(String type){

        int r = DBManager.RQc(DatabaseConnection.getInstance(),"SELECT COUNT(*) FROM listevehicule WHERE type='"+type+"'");
        System.out.println("Nombre de vehicule de type "+type+" = "+r);
    }
    public void listeVehiculeType(String type){

        System.out.println("==============");
        System.out.println(" ID  :  TYPE  :  MARK  ");
        Map<Integer,Vehicule> r = DBManager.RQ(DatabaseConnection.getInstance(),"SELECT * FROM listevehicule WHERE type='"+type+"'");
        for(Map.Entry<Integer,Vehicule> v:r.entrySet()){

            System.out.println(v.getKey()+" : "+v.getValue().toString());
        }
        System.out.println("==============");

    }

}
