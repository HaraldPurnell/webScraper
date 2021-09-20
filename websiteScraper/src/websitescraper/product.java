/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitescraper;

/**
 *
 * @author Uglybear
 */
public class product {
    
    String productName, productDescription, 
            productPrice, productDiscount;
    
    // Constructor
    product(String prodName, String prodDescr, String prodPrice, String prodDiscount)  
    {  
        productName = prodName;
        productDescription = prodDescr;
        productPrice = prodPrice;
        productDiscount = prodDiscount;    
    }  

    public void displayObjectContent()
    {
        System.out.println("Product Name: " + productName);
        System.out.println("Product Description: " + productDescription);
        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Discount: " + productDiscount);
    }

    public int getPrice()
    {
        return Integer.parseInt(productPrice);
    }
    
    /* Remove currency symbol and other text from 
    price and convert price from string to integer */
    public int getFormattedPrice()
    {
       String subString = productPrice.substring(0, 10);

       // Remove all characters but numbers and spaces 
       String modifiedString = subString.replaceAll("[^0-9.]+", " ");

       // Removes unessecaary spaces
       String removedSpacing = modifiedString.replace(" ", "");

       int i = 0;
       String stringPrice = "";

       // Remove numbers after dot and the dot
       while (i < removedSpacing.length())
       {
           if (Character.toString(removedSpacing.charAt(i)).equals("."))
           {
               break;
           }
           else
           {
               stringPrice = stringPrice + Character.toString(removedSpacing.charAt(i));
               i++;
           }
       }

       int formattedPrice = Integer.parseInt(stringPrice);
       //int formattedPrice = stringPrice;
       return formattedPrice;
    }

    
    
}
