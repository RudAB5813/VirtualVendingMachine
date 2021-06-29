import com.techelevator.Candy;
import com.techelevator.Chip;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class testChip {

    @Test
    public void testChip_setup_message ()
    {
        //arrange
        Chip testMe = new Chip("37", "Pringles", BigDecimal.valueOf(1.98));

        String expectedItemText = testMe.getItemName() + " \t\n Price: $" + testMe.getItemPrice() + " \t Quantity " + testMe.getStock() +" remaining. ";
        String expectedMessage = "Crunch Crunch, Yum!";

        //act
        String resultMessage = testMe.getItemMessage();
        //assert
        Assert.assertEquals(expectedMessage, resultMessage);
    }

    @Test
    public void testChip_setup_text ()
    {
        //arrange
        Chip testMe = new Chip("37", "Pringles", BigDecimal.valueOf(1.98));

        String expectedItemText = testMe.getItemName() + " \t\n Price: $" + testMe.getItemPrice() + " \t Quantity " + testMe.getStock() +" remaining. ";

        //act
        String resultText = testMe.getItemText();
        //assert
        Assert.assertEquals(expectedItemText, resultText);
    }
}
