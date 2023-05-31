import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsTestTest {
    Items_test item1,item2;
    Acc_Driver account;
    @Before
    public void setUp() throws Exception {
        item1=new Items_test("pen","it1",100,5);
        item2=new Items_test("checkbook","it2",1000,1);
        account=new Acc_Driver("12",200);
    }

    @Test
    public void TestBuy1() {
        item1.buy();
        int out=item1.getCount();
        int expected=4;
        assertEquals(expected,out);
    }
    @Test
    public void TestBuy2(){
        item2.buy();
        item2.buy();
        int out=item2.getCount();
        int expected=0;
        assertEquals(expected,out);

    }
    @Test
    public void TestBuyItem1(){
        String out= account.buyItem(item1);
        String  expected="Item bought";
        assertEquals(expected,out);

    }
    @Test
    public void TestBuyItem2(){
        String out= account.buyItem(item2);
        String  expected="Not Enough Balance";
        assertEquals(expected,out);

    }


}