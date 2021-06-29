import com.techelevator.Drink;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class testDrink {


    @Test
    public void testDrink_setup_message ()
    {
        //arrange
        Drink testMe = new Drink("37", "Pepsi Zero", BigDecimal.valueOf(5.00));

        String expectedItemText = testMe.getItemName() + " \t\n Price: $" + testMe.getItemPrice() + " \t Quantity " + testMe.getStock() +" remaining. ";
        String expectedMessage = "Glug, Glug, Yum!";

        //act
        String resultMessage = testMe.getItemMessage();
        //assert
        Assert.assertEquals(expectedMessage, resultMessage);
    }

    @Test
    public void testDrink_setup_text ()
    {
        //arrange
        Drink testMe = new Drink("37", "Pepsi Zero", BigDecimal.valueOf(3.98));

        String expectedItemText = testMe.getItemName() + " \t\n Price: $" + testMe.getItemPrice() + " \t Quantity " + testMe.getStock() +" remaining. ";

        //act
        String resultText = testMe.getItemText();
        //assert
        Assert.assertEquals(expectedItemText, resultText);
    }


    @Test
    public void testDrink_setup_Stock ()
    {
        //arrange
        Drink testMe = new Drink("37", "Pepsi Zero", BigDecimal.valueOf(3.98));

        int expectedStock = 5;

        //act
//        String resultText = testMe.getStock();
        //assert
        Assert.assertEquals(expectedStock, testMe.getStock());
    }
    
}
