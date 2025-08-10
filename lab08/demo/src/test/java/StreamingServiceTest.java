
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Account;
import com.example.StreamingService;

/**
 * The test class StreamingServiceTest.
 *
 * @author POO
 */
public class StreamingServiceTest {
  private StreamingService streamingService;
  private Account account1;
  private Account account2;
  private Account account3;
  private Account account4;
  private Account account5;

  /**
   * Default constructor for test class StreamingServiceTest
   */
  public StreamingServiceTest() {
  }

  /**
   * Sets up the test fixture.
   *
   * Called before every test case method.
   */
  @BeforeEach
  public void setUp() {
    streamingService = new StreamingService();
    account1 = new Account("José Manuel", true);
    account2 = new Account("Francisco Silva", false);
    account3 = new Account("Maria Clara", false);
    account4 = new Account("Clotilde Matias", true);
    account5 = new Account("Fernanda Costa", false);
  }

  /**
   * Tears down the test fixture.
   *
   * Called after every test case method.
   */
  @AfterEach
  public void tearDown() {
  }

  @Test
  public void testConstructor() {
    assertNotNull(streamingService.getActiveAccounts());
  }

  @Test
  void testAddAccount() {
    streamingService.addAccount(account1);
    assertEquals(streamingService.getActiveAccounts().get(0), account1);
  }

  @Test
  void testRemoveAccount() {
    streamingService.addAccount(account1);
    streamingService.addAccount(account2);
    streamingService.addAccount(account3);

    streamingService.removeAccount(account2);

    assertEquals(streamingService.getActiveAccounts().size(), 2);
    assertFalse(streamingService.getActiveAccounts().contains(account2));
  }

  @Test
  void testRemoveUnpaidAccounts() {
    streamingService.addAccount(account1);
    streamingService.addAccount(account2);
    streamingService.addAccount(account3);
    streamingService.addAccount(account4);
    streamingService.addAccount(account5);

    streamingService.removeUnpaidAccounts();

    assertEquals(streamingService.getActiveAccounts().size(), 2);
    assertFalse(streamingService.getActiveAccounts().contains(account2));
    assertFalse(streamingService.getActiveAccounts().contains(account3));
    assertFalse(streamingService.getActiveAccounts().contains(account5));
  }

  @Test
  void testSetAllAccountsAsUnpaid() {
    streamingService.addAccount(account1);
    streamingService.addAccount(account2);
    streamingService.addAccount(account3);
    streamingService.addAccount(account4);

    streamingService.setAllAccountsAsUnpaid();

    assertFalse(streamingService.getActiveAccounts().get(0).isPaid());
    assertFalse(streamingService.getActiveAccounts().get(1).isPaid());
    assertFalse(streamingService.getActiveAccounts().get(2).isPaid());
    assertFalse(streamingService.getActiveAccounts().get(3).isPaid());
  }

  @Test
  void testRemoveUnpaidAccountsRemoveIf() {
    streamingService.addAccount(account1);
    streamingService.addAccount(account2);
    streamingService.addAccount(account3);
    streamingService.addAccount(account4);
    streamingService.addAccount(account5);

    streamingService.removeUnpaidAccountsRemoveIf();

    assertEquals(streamingService.getActiveAccounts().size(), 2);
    assertFalse(streamingService.getActiveAccounts().contains(account2));
    assertFalse(streamingService.getActiveAccounts().contains(account3));
    assertFalse(streamingService.getActiveAccounts().contains(account5));
  }

  @Test
  void testGetListOfUnpaidAccounts() {
    streamingService.addAccount(account1);
    streamingService.addAccount(account2);
    streamingService.addAccount(account3);
    streamingService.addAccount(account4);
    streamingService.addAccount(account5);

    List<Account> unpaidAccounts = streamingService.getListOfUnpaidAccounts();

    assertEquals(unpaidAccounts.size(), 3);
    assertTrue(unpaidAccounts.contains(account2));
    assertTrue(unpaidAccounts.contains(account3));
    assertTrue(unpaidAccounts.contains(account5));
  }

  @Test
  void testCountUnpaidAccounts() {
    streamingService.addAccount(account1);
    streamingService.addAccount(account2);
    streamingService.addAccount(account3);
    streamingService.addAccount(account4);
    streamingService.addAccount(account5);

    assertEquals(streamingService.countUnpaidAccounts(), 3);
  }

  @Test
  void testToString() {
    streamingService.addAccount(account1);
    streamingService.addAccount(account2);
    streamingService.addAccount(account3);
    streamingService.addAccount(account4);
    streamingService.addAccount(account5);

    String expected = "Contas do serviço de streaming:\n\n" +
        "Nome                Pago\n" +
        "José Manuel true\n" +
        "Francisco Silva false\n" +
        "Maria Clara false\n" +
        "Clotilde Matias true\n" +
        "Fernanda Costa false\n";

    assertEquals(streamingService.toString(), expected);
  }
}
