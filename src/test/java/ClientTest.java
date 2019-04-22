import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Client myClient = new Client("Queen");
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Task_instantiatesWithDescription_String() {
    Client myClient = new Client("Queen");
    assertEquals("Queen", myClient.getName());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_true() {
    Client myClient = new Client("Queen");
    assertEquals(true, myClient.isAvailable());
  }

  @Test
  public void getClientSince_instantiatesWithCurrentTime_today() {
    Client myClient = new Client("Queen");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myClient.getClientSince().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Client firstClient = new Client("Queen");
    Client secondClient = new Client("Ab");
    assertEquals(true, Client.all().contains(firstClient));
    assertEquals(true, Client.all().contains(secondClient));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Client myClient = new Client("Queen");
    Client.clear();
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    Client.clear();
    Client myClient = new Client("Queen");
    assertEquals(1, myClient.getId());
  }

  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Client firstClient = new Client("Queen");
    Client secondClient = new Client("Ab");
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

}
