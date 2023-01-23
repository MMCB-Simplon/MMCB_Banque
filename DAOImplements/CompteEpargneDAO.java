package DAOImplements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.CompteEpargneModel;

/*
 * Classe nous permettant de récupérer les informations des comptes épargnes en ce servant du modèle CompteEpargneModel
 */

public class CompteEpargneDAO extends DatabaseConnection {

    public List <CompteEpargneModel>   readCourant () {
         
      List <CompteEpargneModel> listcompte= new ArrayList<CompteEpargneModel>();
        Connection con = this.BDDconnection();
        try {
            

            java.sql.Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM compteepargne");

            while (res.next()) {
                System.out.println("bien executé");
                CompteEpargneModel compte=  new CompteEpargneModel();
                compte.setNumerocompte(res.getInt(1));
         listcompte.add(compte);

            }
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    return  listcompte;
    }
}
