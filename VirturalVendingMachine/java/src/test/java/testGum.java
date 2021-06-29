import com.techelevator.Gum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class testGum {

    @Test
    public void testGum_setup_message ()
    {
        //arrange
        Gum testMe = new Gum("37", "Juicyfruit", BigDecimal.valueOf(5.00));

        String expectedItemText = testMe.getItemName() + " \t\n Price: $" + testMe.getItemPrice() + " \t Quantity " + testMe.getStock() +" remaining. ";
        String expectedMessage = "Chew, Chew, Yum!";

        //act
        String resultMessage = testMe.getItemMessage();
        //assert
        Assert.assertEquals(expectedMessage, resultMessage);
    }

    @Test
    public void testGum_setup_text ()
    {
        //arrange
        Gum testMe = new Gum("37", "Juiclfrtui", BigDecimal.valueOf(3.98));

        String expectedItemText = testMe.getItemName() + " \t\n Price: $" + testMe.getItemPrice() + " \t Quantity " + testMe.getStock() +" remaining. ";

        //act
        String resultText = testMe.getItemText();
        //assert
        Assert.assertEquals(expectedItemText, resultText);
    }
    
}
