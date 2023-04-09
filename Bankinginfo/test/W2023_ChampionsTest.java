import org.junit.Test;

import static org.junit.Assert.*;

public class W2023_ChampionsTest {

    @Test
    public void checkingwithdraw() throws DailyLimitException {
        Checking_W2023_Champions c = new Checking_W2023_Champions("er3434353",2300,"2/14/2023","Adany",12);
        assertEquals("Success! your new balance is 2000.0",c.withdraw(300));
    }

    @Test
    public void savingwithdraw() throws DailyLimitException {
        Savings_W2023_Champions c = new Savings_W2023_Champions("er3434353",2300,"2/14/2023","Adany",12);
        assertEquals("Success! your new balance is 2000.0",c.withdraw(300));
    }

    @Test
    public void checkingdeposit() {
        Checking_W2023_Champions c = new Checking_W2023_Champions("er3434353",2300,"2/14/2023","Adany",12);
        assertEquals("Success! your new balance is 2500.0",c.deposit(200));
    }
    @Test
    public void savingdeposit() {
        Savings_W2023_Champions c = new Savings_W2023_Champions("er3434353",2300,"2/14/2023","Adany",12);
        assertEquals("Success! your new balance is 2500.0",c.deposit(200));
    }
    @Test
    public void withdrawExcessAmount() throws DailyLimitException {
        Checking_W2023_Champions c = new Checking_W2023_Champions("er3434353",2300,"2/14/2023","Adany",12);
        assertEquals("Insufficient funds.",c.withdraw(5300));
    }

    @Test
    public void getAccountNo() {
        Account_W2023_Champions a = new Account_W2023_Champions("er3434353",2300,"2/14/2023","Adany");
        assertEquals("er3434353",a.getAccountNo());
    }

    @Test
    public void getBalance() {
        Account_W2023_Champions a = new Account_W2023_Champions("er3434353",2300,"2/14/2023","Adany");
        assertEquals(2300.0,a.getBalance(),0.01);
    }

    @Test
    public void getDateCreated() {
        Account_W2023_Champions a = new Account_W2023_Champions("er3434353",2300,"2/14/2023","Adany");
        assertEquals("2/14/2023",a.getDateCreated());
    }

    @Test
    public void getOwnerName() {
        Account_W2023_Champions a = new Account_W2023_Champions("er3434353", 2300, "2/14/2023", "Adany");
        assertEquals("Adany", a.getOwnerName());
    }


}

