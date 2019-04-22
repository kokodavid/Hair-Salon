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

    }


}
