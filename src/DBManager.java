import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBManager {

    public static Map<Integer,Vehicule> RQ(DatabaseConnection instance, String rq){

        Map<Integer,Vehicule> tab = new HashMap<>();
        try{

            Connection con = instance.getConnection();
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(rq);
            while(result.next()){

                Vehicule v = new Vehicule(result.getString("type"),result.getString("mark"));
                switch (result.getString("type")){

                    case "voiture" -> v = new Voiture(result.getString("mark"));
                    case "moto" -> v = new Moto(result.getString("mark"));
                    case "camion" -> v = new Camion(result.getString("mark"));
                }

               tab.put(result.getInt("id"),v);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return tab;
    }
    public  static boolean RQt(DatabaseConnection instance,String rq){

        boolean result = false;
        try{

            Connection con = instance.getConnection();
            Statement st = con.createStatement();
            result = st.execute(rq);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }
    public static  int RQc(DatabaseConnection instance,String rq){

        int nbr = 0;
        try{

            Connection con = instance.getConnection();
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(rq);
            nbr = result.getInt("COUNT(*)");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return nbr;
    }
}
