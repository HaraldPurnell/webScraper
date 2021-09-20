/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitescraper;

import java.util.Comparator;

/**
 *
 * @author Uglybear
 */
public class priceSorter implements Comparator<product> {

    @Override
    public int compare(product o1, product o2) {
        return o2.getFormattedPrice() - o1.getFormattedPrice();
    }
}
