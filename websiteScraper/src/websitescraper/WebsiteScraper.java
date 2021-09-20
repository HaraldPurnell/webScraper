package websitescraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Harald Purnell
 */
public class WebsiteScraper {
    
    static ArrayList<product> arrayProducts = new ArrayList<>(); 
    static ArrayList<product> array = new ArrayList<>();
    Elements pageElements; 
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Document page = fetchWebsite("https://videx.comesconnected.com/");
        arrayProducts = getProducts(page);
        
        // Print array (Asc order) to console (Standard without sort)
        System.out.println("ARRAY (ASCEN ORDER): \n");
        printArray(arrayProducts);

        // Sort in desc order
        Collections.sort(arrayProducts, new priceSorter()); 

        // Print array (Asc order) to console
        System.out.println("\nSORTED ARRAY (DESC ORDER): \n");
        printArray(arrayProducts);
    }

    public static ArrayList<product> getProducts(Document websiteContent) throws IOException 
    {
        // Get all avaliable product packages from website
        Elements pageElements = websiteContent.select("div.package-features");

        // Iterate through pageElements to find relevant data
        pageElements.forEach((e) -> {
            array.add(new product(e.select("div.package-name").text(), e.select("div.package-data").text(), e.select("div.package-price").text(), "0"));
        });   
        
        return array;
    }
    
    public static Document fetchWebsite(String websiteURL) throws IOException
    {
        return Jsoup.connect(websiteURL).get();
    }

    public static void printArray(ArrayList<product> array)
    {
        for (int i = 0; i < array.size(); i++)
        {
            array.get(i).displayObjectContent();
        }
    }
    
    public static ArrayList<product> getArray()
    {
        return arrayProducts;
    }
}
