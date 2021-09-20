package websitescraper;

import java.util.Comparator;

/**
 *
 * @author Harald Purnell
 */
public class priceSorter implements Comparator<product> {
    
    /* Documentation for Comparator can be found at:
    https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html */
    
    @Override
    public int compare(product o1, product o2) {
        return o2.getFormattedPrice() - o1.getFormattedPrice();
    }
}
