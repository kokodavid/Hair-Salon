import java.util.List;
import java.util.ArrayList;


public class Stylist {

    private String mName;
    private static List<Stylist> instances = new ArrayList<Stylist>();
    private int mId;

    public Stylist(String name) {
        mName = name;
        instances.add(this);
        mId = instances.size();
    }

    public String getName() {
        return mName;
    }

    public static void clear() {
        instances.clear();
    }

    public static List<Stylist> all() {
        return instances;
    }
    public int getId() {
        return mId;
    }

    public static Stylist find(int id) {
        return instances.get(id - 1);
    }
}
