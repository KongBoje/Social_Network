/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

import java.util.List;

/**
 *
 * @author Micha
 */
public class Calculate {
    public double calcAverage(List<Double> list) {
        Double timeSum = 0.0;
        for (Double doub : list) {
            timeSum += doub;
        }
        return timeSum/20;
    }
    
    public double calcMedian(List<Double> list) {
        int mid = list.size()/2;
        mid = mid % 2 == 0? mid - 1 : mid;
        return list.get(mid);
    }
}
