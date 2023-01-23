package DAOImplements;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.CompteCourantModel;

/*
 * Classe nous permettant de récupérer les informations des comptes courant en ce servant du modèle CompteCourantModel
 */
public class CompteCourantDAO extends DatabaseConnection {
    
    public List <CompteCourantModel>   readCourant () {
         
      List <CompteCourantModel> listcompte= new ArrayList<CompteCourantModel>();
        Connection con = this.BDDconnection();
        try {
            

            java.sql.Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM comptecourant");

            while (res.next()) {
                System.out.println("bien executé");
                CompteCourantModel compte=  new CompteCourantModel();
                compte.setNumerocompte(res.getInt(1));
         listcompte.add(compte);
             //   System.out.println(res.getInt(1) + "  " + res.getString(2));

            }
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    return  listcompte;
    }
   
    
}