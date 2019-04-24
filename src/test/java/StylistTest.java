import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class StylistTest {

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
    public void save_savesIntoDatabase_true() {
        Stylist myStylist = new Stylist("Quen");
        myStylist.save();
        assertTrue(Stylist.all().get(0).equals(myStylist));
    }

    @Test
    public void equals_returnsTrueIfNamesAretheSame() {
        Stylist firstStylist = new Stylist("Quen");
        Stylist secondStylist = new Stylist("Ab");
        assertTrue(firstStylist.equals(secondStylist));
    }

    @Test
    public void stylist_instantiatesCorrectly_true() {
        Stylist testStylist = new Stylist("Queen");
        assertEquals(true, testStylist instanceof Stylist);
    }

    @Test
    public void Stylist_instantiatesWithName_String() {
        Stylist testStylist = new Stylist("Queen");
        assertEquals("Queen", testStylist.getName());
    }

    @Test
    public void all_returnsAllInstancesOfStylist_true() {
        Stylist firstStylist = new Stylist("Queen");
        firstStylist.save();
        Stylist secondStylist = new Stylist("Ab");
        secondStylist.save();
        assertEquals(true, Stylist.all().get(0).equals(firstStylist));
        assertEquals(true, Stylist.all().get(1).equals(secondStylist));

    }
    @Test
    public void save_assignsIdToObject() {
        Stylist myStylist = new Stylist("Quen");
        myStylist.save();
        Stylist savedStylist = Stylist.all().get(0);
        assertEquals(myStylist.getId(), savedStylist.getId());
    }

    @Test
    public void getId_stylistsInstantiateWithAnId_1() {
        Stylist testStylist = new Stylist("Quen");
        testStylist.save();
        assertTrue(testStylist.getId() > 0);
    }

    @Test
    public void find_returnsStylistWithSameId_secondStylist() {
        Stylist firstStylist = new Stylist("Quen");
        firstStylist.save();
        Stylist secondStylist = new Stylist("Quen");
        secondStylist.save();
        assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
    }

    @Test
    public void getTasks_retrievesALlClientsFromDatabase_clientsList() {
        Stylist myStylist = new Stylist("Quen");
        myStylist.save();
        Client firstClient = new Client("Quen", myStylist.getId());
        firstClient.save();
        Client secondClient = new Client("shiks", myStylist.getId());
        secondClient.save();
        Client[] clients = new Client[] { firstClient, secondClient };
        assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
    }
}

/*    @Test
    public void clear_emptiesAllStylistsFromList_0() {
        Stylist testStylist = new Stylist("Queen");
        Stylist.clear();
        assertEquals(Stylist.all().size(),0);
    }

    @Test
    public void getId_stylistInstantiatesWithAnId_1() {
        Stylist testStylist = new Stylist("Queen");
        assertEquals(1,testStylist.getId());
    }
    @Test
    public void find_returnsStylistWithSameId_secondCategory() {
        Stylist.clear();
        Stylist firstStylist = new Stylist("Queen");
        Stylist secondStylist = new Stylist("Alison");
        assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
    }

    @Test
    public void getClients_initiallyReturnsEmptyList_ArrayList() {
        Stylist.clear();
        Stylist testStylist = new Stylist("Queen");
        assertEquals(0, testStylist.getClients().size());*/
  /*  }*/
/*
    @Test
    public void addTask_addsClientToList_true() {
        Stylist testStylist = new Stylist("Queen");
        Client testClient = new Client("Mow the lawn");
        testStylist.addClient(testClient);
        assertTrue(testStylist.getClients().contains(testClient));
    }*/



