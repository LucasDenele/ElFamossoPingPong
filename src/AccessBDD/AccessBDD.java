package AccessBDD; 

import player.Player;
import java.sql.*;
import java.util.*;


public class AccessBDD {
    private String url; 
    private String user; 
    private String password;
    
    
    public AccessBDD(){
        url = "jdbc:mysql://localhost:3306/el_famoso_bdd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        user = "root";
        password = "root";
    }
    
    
    public Vector<Player> request(String sqlRequest){
        /* Chargement du driver */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Vector players = new Vector();

        /* Connexion à la base de donnees */   
        Connection connexion = null;  
        try {
            connexion = DriverManager.getConnection(url, user, password);
            
            /* Creation de l'objet gerant les requetes */
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(sqlRequest);

            /* Stockage des donnees recoltees */

            while(resultat.next()){
                Player newPlayer = new Player(resultat.getString(1),
                        resultat.getString(2),
                        resultat.getString(3),
                        resultat.getDouble(4),
                        resultat.getString(5),
                        resultat.getFloat(6),
                        resultat.getFloat(7));
                players.add(newPlayer);
            }



            
            
        } catch ( SQLException e ) {
            e.printStackTrace(); 
        } finally {
            if ( connexion != null )
                try {
                    /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                    
                }
        }
        return players;
    }
    
    
    public void update(Vector<Player> players){
        for(Player p : players){
            /* Connexion à la base de donnees */   
            Connection connexion = null;  
            try {
                connexion = DriverManager.getConnection(url, user, password);
                
                /* Creation de l'objet gerant les requetes */
                Statement statement = connexion.createStatement();
                
                /* Mise a jour de la base de donnée */ 
                int statut = statement.executeUpdate("update PLAYER set POINTS='"
                        + Double.toString(p.getPoints()) + "' where FIRST_NAME = '"
                        + p.getFirstName() + "' && LAST_NAME = '" + p.getLastName()
                        + "'");

                            
            } catch ( SQLException e ) {
                e.printStackTrace(); 
            } finally {
                if ( connexion != null )
                    try {
                        /* Fermeture de la connexion */
                        connexion.close();
                    } catch ( SQLException ignore ) {
                        
                    }
            }
            
        }
    }
}
