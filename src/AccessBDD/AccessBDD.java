package AccessBDD; 

import player.Player;
import java.sql.*;
import java.util.*;


public class AccessBDD {
    private String url; 
    private String user; 
    private String password;
    
    
    public AccessBDD(){
        url = "jdbc:mysql://localhost:3306/" +
                "el_famoso_bdd?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        user = "root";
        password = "root";
    }
    
    //To get something from the BDD:
    public Vector<Player> request(String sqlRequest){
        //Driver Loading :
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Vector<Player> players = new Vector<Player>();

        //BDD connection :
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            
            // Request object creation :
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(sqlRequest);

            //Create the vector with the results :
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
            if ( connection != null )
                try {
                    //Close the connection :
                    connection.close();
                } catch ( SQLException ignore ) {
                    
                }
        }
        return players;
    }
    
    //To update something in the BDD :
    public void update(Vector<Player> players){
        for(Player p : players){
            //BDD connection :
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, user, password);
                
                //Request object creation :
                Statement statement = connection.createStatement();
                
                //Update the BDD :
                int statut = statement.executeUpdate("update PLAYER set POINTS='"
                        + Double.toString(p.getPoints()) + "' where FIRST_NAME = '"
                        + p.getFirstName() + "' && LAST_NAME = '" + p.getLastName()
                        + "'");

                            
            } catch ( SQLException e ) {
                e.printStackTrace(); 
            } finally {
                if ( connection != null )
                    try {
                        //Close the connection :
                        connection.close();
                    } catch ( SQLException ignore ) {
                        
                    }
            }
            
        }
    }
}
