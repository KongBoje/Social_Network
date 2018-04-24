/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author Micha
 */
public class Neo4jConnection {
    
    public static Driver driver;
    public static String url = "bolt://localhost:7687";
    public static String username = "neo4jj";
    public static String password = "class";
    
    public static Driver getConnection(){
        if (driver == null) {
            driver = GraphDatabase.driver(url, AuthTokens.basic(username, password));
        }
        return driver;
    }
    
    public static void closeNeoDriver() {
        driver.close();
        driver = null;
    }
    
//    public static void main(String[] args) {
//        Driver driver = GraphDatabase.driver( 
//                "bolt://localhost:7687", 
//                AuthTokens.basic( "neo4jj", "class" ) );
//        Session session = driver.session();
//
//        // Run a query matching all nodes
//        StatementResult result = session.run( 
//                "MATCH (s:Person)" +
//                "RETURN s.name AS name, s.job AS job");
//
//        while ( result.hasNext() ) {
//            Record record = result.next();
//            System.out.println( record.get("name").asString() + " -> " + 
//                                record.get("job").asString());
//        }
//        session.close();
//        driver.close();
//    }
}