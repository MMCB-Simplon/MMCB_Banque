package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.CompteCourantModel;

public class CompteCourantDAO extends DatabaseConnection {
    
    public ArrayList<CompteCourantModel>   readCourant () {
         
      ArrayList<CompteCourantModel> listcompte= new ArrayList<CompteCourantModel>();
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
    public static void main (String [] args) {
        CompteCourantDAO comptecourant= new CompteCourantDAO();
      
      //  comptecourant.readCourant();
        ArrayList<CompteCourantModel> listcomptecourant = new ArrayList<CompteCourantModel>();
        
        listcomptecourant=comptecourant.readCourant();

        for (CompteCourantModel compte : listcomptecourant) {

 System.out.println("Frais:"+compte.getFraisTransfert()+"[numerocompte]="+compte.getNumerocompte()+" [soldeminimum]:"+compte.getSoldeMinimum());
            
        }
        
    }
    
    
}