import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import org.sql2o.*;

public class ClientTest {
  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "david", "5738");
  }

    @After
    public void tearDown() {
        try (Connection con = DB.sql2o.open()) {
            String deleteClientsQuery = "DELETE FROM clients *;";
            String deleteStylistsQuery = "DELETE FROM stylists *;";
            con.createQuery(deleteClientsQuery).executeUpdate();
            con.createQuery(deleteStylistsQuery).executeUpdate();


        }
    }

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Queen",1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithName_String() {
    Client myClient = new Client("Queen",1);
    assertEquals("Queen", myClient.getName());
  }

    @Test
    public void save_savesStylistIdIntoDB_true() {
        Stylist myStylist = new Stylist("Quen");
        myStylist.save();
        Client myClient = new Client("Quen", myStylist.getId());
        myClient.save();
        Client savedClient = Client.find(myClient.getId());
        assertEquals(savedClient.getStylistid(), myStylist.getId());
    }

 /* @Test
  public void isCompleted_isFalseAfterInstantiation_true() {
    Client myClient = new Client("Queen");
    assertEquals(true, myClient.isAvailable());
  }

  @Test
  public void getClientSince_instantiatesWithCurrentTime_today() {
    Client myClient = new Client("Queen");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myClient.getClientSince().getDayOfWeek());
  }*/

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Queen",1);
    firstClient.save();
    Client secondClient = new Client("Ab",1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

 /* @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Client myClient = new Client("Queen");
    Client.clear();
    assertEquals(Client.all().size(), 0);
  }
*/
  @Test
  public void getId_clientInstantiateWithAnID_1() {
    Client myClient = new Client("Queen",1);
    myClient.save();
    assertTrue(myClient.getId() > 0);
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Queen",1);
    firstClient.save();
    Client secondClient = new Client("Ab",1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }


  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Client firstClient = new Client("Quuen",1);
    Client secondClient = new Client("aa",1);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Client myClient = new Client("Quen",1);
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Quen",1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }



}

