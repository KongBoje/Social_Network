/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Micha
 */
public class SQLConnection {
    
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/socialnetwork";
        String user = "root";
        String password = "root123";

        String query = "SELECT * FROM socialnetwork.persons";

        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {                
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally { 
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }
}
