package bank;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {
    private Bank bank;
    private Client client;

    @Before
    public void setUp() throws Exception {
        bank = new Bank("ING", 10);
        client = new Client("Pesho");
//     bank.addClient(client);
    }

    @Test(expected = NullPointerException.class)
    public void testTestSetNameWithInvalidData() throws NullPointerException {
        Bank bank1 = new Bank("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTestSetCapacityWithInvalidData() throws IllegalArgumentException {
        Bank bank1 = new Bank("Rabo", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClientNoCapacity() throws IllegalArgumentException {
        Bank bank1 = new Bank("Rabo", 1);
        Client client1 = new Client("Gosho");
        bank1.addClient(client);
        bank1.addClient(client1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientWhenClientDoesntExist() throws IllegalArgumentException {
        bank.addClient(client);
        bank.removeClient("Gosho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalClientDoesntExist() throws IllegalArgumentException {
        bank.addClient(client);
        bank.loanWithdrawal("Gosho");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("ING", this.bank.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(10, this.bank.getCapacity());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, this.bank.getCount());
        bank.addClient(client);
        Assert.assertEquals(1, this.bank.getCount());
    }

    @Test
    public void testAddClient() {
        Assert.assertEquals(0, this.bank.getCount());
        bank.addClient(client);
        Assert.assertEquals(1, this.bank.getCount());
    }

    @Test
    public void testRemoveClient() {
        Assert.assertEquals(0, this.bank.getCount());
        bank.addClient(client);
        Assert.assertEquals(1, this.bank.getCount());
        bank.removeClient("Pesho");
        Assert.assertEquals(0, this.bank.getCount());

    }

    @Test
    public void testLoanWithdrawal() {
        bank.addClient(client);
        bank.loanWithdrawal("Pesho");
        Assert.assertFalse(client.isApprovedForLoan());
    }

    @Test
    public void testStatistics() {
        bank.addClient(client);
        Assert.assertEquals("The client Pesho is at the ING bank!", this.bank.statistics());
    }
}
