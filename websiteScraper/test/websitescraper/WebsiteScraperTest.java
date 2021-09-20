/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitescraper;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Uglybear
 */
public class WebsiteScraperTest {

    
    
    /**
     * Test of fetchWebsite method, of class WebsiteScraper.
     * @throws java.lang.Exception
     * 
     * Checks if text content gathered from fetchWebsite is the same as expected
     * (JavaScript seems to be disabled in your browser.
     * For the best experience on our site, be sure to turn on Javascript in your browser.)
     */
    
    //   
    @Test
    public void testFetchWebsite() throws Exception {
        String websiteURL = "https://videx.comesconnected.com/";
        
        // Get first line from website URL
        Document expecPage = Jsoup.connect(websiteURL).get();
        Element expecElement = expecPage.select("div").first();
        
        Document actualPage = WebsiteScraper.fetchWebsite(websiteURL);
        Element actualElement = actualPage.select("div").first();
        
        // Convert to string for checking
        String expectedOutput = expecElement.text();
        String actualOutput = actualElement.text();

        // Check if actual == expected
        assertTrue(actualOutput.equals(expectedOutput));
    }

    /**
     * Test of getProducts method, of class WebsiteScraper.Checks if produced array is of expected length (6)
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProducts() throws Exception {

        String websiteURL = "https://videx.comesconnected.com/";
        Document page = WebsiteScraper.fetchWebsite(websiteURL);

        ArrayList<product> testArray;
        
        testArray = WebsiteScraper.getProducts(page);
        
        product actualAnswer = testArray.get(0);

        int expectedPrice = 6;
        int actualPrice = actualAnswer.getFormattedPrice();
        
        // Check if actual == expected
        assertTrue(actualPrice == expectedPrice);
    }
    
}
