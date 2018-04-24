/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import connections.Neo4jConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author Micha
 */
public class Neo4JQueries {
    
    public List get20RandomNodes() {
        List<String> names = new ArrayList<>();
        Driver driver = Neo4jConnection.getConnection();
        
        Session session = driver.session();
        String query = "MATCH (a) RETURN a, rand() as r ORDER BY r LIMIT 20;";
        
        StatementResult result = session.run(query);
        while (result.hasNext()) {
            Record record = result.next();
            names.add(record.get("name").asString());
        }
        session.close();
        Neo4jConnection.closeNeoDriver();
        
        return names;
    }
    
    public StatementResult queryDepth1(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Neo4jConnection.getConnection();
        
        Session session = driver.session();
        String query = "MATCH(:Person{name: '" + name + "'})-[:ENDORSES]->(other) return count(other)";
        
        double startTime = System.nanoTime();
        StatementResult result = session.run(query);
        double endTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(1);
        times.add(endTime / 1000000000.0);
        session.close();
        return result;
    }
    
    public StatementResult queryDepth2(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Neo4jConnection.getConnection();
        
        Session session = driver.session();
        String query = "MATCH(:Person{name: '" + name + "'})-[:ENDORSES*2]->(other) return count(other)";
        
        double startTime = System.nanoTime();
        StatementResult result = session.run(query);
        double endTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(2);
        times.add(endTime / 1000000000.0);
        session.close();
        return result;
    }
    
    public StatementResult queryDepth3(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Neo4jConnection.getConnection();
        
        Session session = driver.session();
        String query = "MATCH(:Person{name: '" + name + "'})-[:ENDORSES*3]->(other) return count(other)";
        
        double startTime = System.nanoTime();
        StatementResult result = session.run(query);
        double endTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(3);
        times.add(endTime / 1000000000.0);
        session.close();
        return result;
    }
    
    public StatementResult queryDepth4(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Neo4jConnection.getConnection();
        
        Session session = driver.session();
        String query = "MATCH(:Person{name: '" + name + "'})-[:ENDORSES*4]->(other) return count(other)";
        
        double startTime = System.nanoTime();
        StatementResult result = session.run(query);
        double endTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(4);
        times.add(endTime / 1000000000.0);
        session.close();
        return result;
    }
    
    public StatementResult queryDepth5(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Neo4jConnection.getConnection();
        
        Session session = driver.session();
        String query = "MATCH(:Person{name: '" + name + "'})-[:ENDORSES*5]->(other) return count(other)";
        
        double startTime = System.nanoTime();
        StatementResult result = session.run(query);
        double endTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(5);
        times.add(endTime / 1000000000.0);
        session.close();
        return result;
    }
}
