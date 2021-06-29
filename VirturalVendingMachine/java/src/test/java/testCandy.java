import com.techelevator.Candy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class testCandy {

    @Test
    public void testCandy_setup_message ()
    {
        //arrange
        Candy testMe = new Candy("1A", "Rolo", BigDecimal.valueOf(3.95));

        String expectedItemText = testMe.getItemName() + " \t\n Price: $" + testMe.getItemPrice() + " \t Quantity " + testMe.getStock() +" remaining. ";
        String expectedMessage = "Munch, Munch, Yum!";

        //act
        String resultMessage = testMe.getItemMessage();
        String resultText = testMe.getItemText();
        //assert
        Assert.assertEquals(expectedMessage, resultMessage);
        Assert.assertEquals(expectedItemText, resultText);
    }
}
