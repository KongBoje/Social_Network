/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.socialnetwork;

import calculations.Calculate;
import connections.Neo4jConnection;
import java.util.ArrayList;
import java.util.HashMap;
import queries.Neo4JQueries;

/**
 *
 * @author Micha
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Neo4J queries");
        
        Neo4JQueries nq = new Neo4JQueries();
        Calculate calc = new Calculate();
        HashMap<Integer, ArrayList<Double>> neoMap = new HashMap<>();
        
        neoMap.put(1, new ArrayList<>());
        neoMap.put(2, new ArrayList<>());
        neoMap.put(3, new ArrayList<>());
        neoMap.put(4, new ArrayList<>());
        neoMap.put(5, new ArrayList<>());
        nq.get20RandomNodes().forEach((name) -> {
            nq.queryDepth1((String) name, neoMap);
            nq.queryDepth2((String) name, neoMap);
            nq.queryDepth3((String) name, neoMap);
            nq.queryDepth4((String) name, neoMap);
            nq.queryDepth5((String) name, neoMap);
        });
        
        System.out.println("Neo Depth 1");
        System.out.println("Average: " + calc.calcAverage(neoMap.get(1)));
        System.out.println("Median: " + calc.calcMedian(neoMap.get(1)));
        
        System.out.println("Neo Depth 2");
        System.out.println("Average: " + calc.calcAverage(neoMap.get(2)));
        System.out.println("Median: " + calc.calcMedian(neoMap.get(2)));
        
        System.out.println("Neo Depth 3");
        System.out.println("Average: " + calc.calcAverage(neoMap.get(3)));
        System.out.println("Median: " + calc.calcMedian(neoMap.get(3)));
        
        System.out.println("Neo Depth 4");
        System.out.println("Average: " + calc.calcAverage(neoMap.get(4)));
        System.out.println("Median: " + calc.calcMedian(neoMap.get(4)));
        
        System.out.println("Neo Depth 5");
        System.out.println("Average: " + calc.calcAverage(neoMap.get(5)));
        System.out.println("Median: " + calc.calcMedian(neoMap.get(5)));
        Neo4jConnection.closeNeoDriver();
    }
}
