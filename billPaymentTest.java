import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class billPaymentTest {
    Acc_Driver account1;
    @Before
    public void setUp() throws Exception {
        account1=new Acc_Driver("12",1000);
        account1.addBill("water bill",100);
        account1.addBill("Gas bill",5000);
    }

    @Test
    public void payBillTest1() {
        String out =account1.payBill("water bill");
        String expected="Successful transaction";
        assertEquals(expected,out);
    }

    @Test
    public void payBillTest2(){
        String out=account1.payBill("Gas bill");
        String expected="Not Enough Balance";
        assertEquals(expected,out);
    }
    @Test
    public void payBillTest3(){
        String out=account1.payBill("Electric bill");
        String expected="Bill not found";
        assertEquals(expected,out);
    }
}