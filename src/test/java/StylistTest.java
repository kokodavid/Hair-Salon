import org.junit.*;
import static org.junit.Assert.*;


public class StylistTest {

    @Test
    public void stylist_instantiatesCorrectly_true() {
        Stylist testStylist = new Stylist("Queen");
        assertEquals(true,testStylist instanceof Stylist);
    }

    @Test
    public void Stylist_instantiatesWithName_String() {
        Stylist testStylist = new Stylist("Queen");
        assertEquals("Queen", testStylist.getName() );
    }

    @Test
    public void all_returnsAllInstancesOfStylist_true() {
        Stylist firstStylist = new Stylist("Queen");
        Stylist secondStylist = new Stylist("Ab");
        assertEquals(true,Stylist.all().contains(firstStylist));
        assertEquals(true,Stylist.all().contains(secondStylist));

    }

    @Test
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



}
