package websitescraper;

/**
 *
 * @author Harald Purnell
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
    
    /* 
    Removes all characters from the price value except the relevant integer value as
    the priceSorter class doesn't allow for Float, String or Double input.
    */
    public int getFormattedPrice()
    {
       String subString = productPrice.substring(0, 10);

       // Remove all characters but numbers and spaces 
       String modifiedString = subString.replaceAll("[^0-9.]+", " ");

       // Removes unessential spaces
       String removedSpacing = modifiedString.replace(" ", "");

       int i = 0;
       String stringPrice = "";

       // Remove numbers after dot and the dot itself 
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
       return formattedPrice;
    } 
}
