import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class WalletTest {

    @Test
    public void testGetOwner() {
        Wallet wallet = new Wallet("rasyid");
        Assertions.assertEquals("rasyid", wallet.getOwner());
    }

    @Test
    public void testSetOwner() {
        Wallet wallet = new Wallet("rasyid");
        wallet.setOwner("rasyidk");
        Assertions.assertEquals("rasyidk", wallet.getOwner());
    }

    @Test
    public void testAddAndGetCards() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addCard("Credit Card");
        wallet.addCard("ATM");
        Assertions.assertEquals(2, wallet.getCards().size());
        Assertions.assertTrue(wallet.getCards().contains("Credit Card"));
        Assertions.assertTrue(wallet.getCards().contains("ATM"));
    }

    @Test
    public void testTakeCard() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addCard("Credit Card");
        wallet.addCard("ATM");
        wallet.takeCard("Credit Card");
        Assertions.assertEquals(1, wallet.getCards().size());
        Assertions.assertFalse(wallet.getCards().contains("Credit Card"));
    }

    @Test
    public void testAddAndGetMoneys() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        HashMap<Integer, Integer> expectedMoneys = new HashMap<>();
        expectedMoneys.put(1000, 0);
        expectedMoneys.put(2000, 0);
        expectedMoneys.put(3000, 0);
        expectedMoneys.put(5000, 1);
        expectedMoneys.put(10000, 1);
        expectedMoneys.put(20000, 0);
        expectedMoneys.put(50000, 0);
        expectedMoneys.put(100000, 0);
        Assertions.assertEquals(expectedMoneys, wallet.getMoneys());
    }

    @Test
    public void testAddAndGetCoins() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addCoin(500);
        wallet.addCoin(1000);
        HashMap<Integer, Integer> expectedCoins = new HashMap<>();
        expectedCoins.put(100, 0);
        expectedCoins.put(200, 0);
        expectedCoins.put(500, 1);
        expectedCoins.put(1000, 1);
        Assertions.assertEquals(expectedCoins, wallet.getCoins());
    }

    @Test
    void testTakeCoins() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addCoin(500);
        wallet.takeCoins(500);
        Assertions.assertEquals(0, wallet.getCoins().get(500));
    }

    @Test
    void testTakeMoneys() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addMoney(3000);
        wallet.takeMoneys(3000);
        Assertions.assertEquals(0, wallet.getMoneys().get(3000));
    }
    @Test
    public void testCalculateCoins() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addCoin(500);
        wallet.addCoin(1000);
        Assertions.assertEquals(1500, wallet.calculateCoins());
    }

    @Test
    public void testCalculateMoneys() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addMoney(10000);
        wallet.addMoney(20000);
        Assertions.assertEquals(30000, wallet.calculateMoneys());
    }

    @Test
    public void testGetMoneyAvailable() {
        Wallet wallet = new Wallet("rasyid");
        wallet.addMoney(10000);
        wallet.addCoin(500);
        Assertions.assertEquals(10500, wallet.getMoneyAvailable());
    }
}
