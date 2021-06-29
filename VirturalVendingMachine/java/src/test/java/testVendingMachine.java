import com.techelevator.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class testVendingMachine {

    @Test
    public void VM_feedMachineMoney_caseMoney ()
    {
        //arrange

        VendingMachine testVend = new VendingMachine();

        BigDecimal testExpected = new BigDecimal(1);

        testVend.feedMachineMoney(testExpected);

        BigDecimal testResult = testVend.getBalance();

        //assert
        Assert.assertEquals(   testExpected, testResult);
    }


    @Test
    public void VM_feedMachineMoney_caseTwo ()
    {
        //arrange

        VendingMachine testVend2 = new VendingMachine();

        BigDecimal testExpected = new BigDecimal(2);

        testVend2.feedMachineMoney(testExpected);

        BigDecimal testResult = testVend2.getBalance();

        //assert
        Assert.assertEquals(testExpected, testResult);
    }


    @Test
    public void VM_SubtractBalance_A ()
    {
        //arrange

        VendingMachine testVendA = new VendingMachine();

        BigDecimal testExpected = new BigDecimal(11);
        BigDecimal setup = new BigDecimal(17);

        testVendA.feedMachineMoney(setup);
        testVendA.subtractBalance(BigDecimal.valueOf(6));

        BigDecimal testResult = testVendA.getBalance();

        //assert
        Assert.assertEquals(testExpected, testResult);

    }


    @Test
    public void VM_Calculate_Change_case1 ()
    {
        //arrange

        VendingMachine testVend2 = new VendingMachine();

        BigDecimal testMoney = new BigDecimal("0.94");

        testVend2.feedMachineMoney(testMoney);

        int [] testResult = testVend2.calculateChange();
        int [] testExpected = new int[]{3,1,1,4};

        //assert
        Assert.assertArrayEquals(testExpected, testResult);
    }

    @Test
    public void VM_Calculate_Change_case2 ()
    {
        //arrange

        VendingMachine testVend2 = new VendingMachine();

        BigDecimal testMoney = new BigDecimal("4.00");

        testVend2.feedMachineMoney(testMoney);

        int [] testResult = testVend2.calculateChange();
        int [] testExpected = new int[]{16,0,0,0};

        //assert
        Assert.assertArrayEquals(testExpected, testResult);
    }

    @Test
    public void VM_Calculate_Change_case3 ()
    {
        //arrange

        VendingMachine testVend2 = new VendingMachine();

        BigDecimal testMoney = new BigDecimal("0.09");

        testVend2.feedMachineMoney(testMoney);

        int [] testResult = testVend2.calculateChange();
        int [] testExpected = new int[]{0,0,1,4};

        //assert
        Assert.assertArrayEquals(testExpected, testResult);
    }

    @Test
    public void VM_Calculate_Change_caseZero ()
    {
        //arrange

        VendingMachine testVend2 = new VendingMachine();

        BigDecimal testMoney = new BigDecimal("0.00");

        testVend2.feedMachineMoney(testMoney);

        int [] testResult = testVend2.calculateChange();
        int [] testExpected = new int[]{0,0,0,0};

        //assert
        Assert.assertArrayEquals(testExpected, testResult);
    }

}
