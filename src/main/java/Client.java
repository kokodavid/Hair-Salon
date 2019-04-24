import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
    private String name;
    /*  private boolean mAvailable;
      private LocalDateTime mClientSince;*/
    /*  private static List<Client> instances = new ArrayList<Client>();*/
    private int id;
    private int stylistid;

    public Client(String name,int stylistid) {
        this.name = name;
        this.stylistid = stylistid;
        /*instances.add(this);*/
        /* mId = instances.size();*/
    }

    public String getName() {
        return name;
    }

    public int getStylistid() {
        return stylistid;
    }

    public static List<Client> all() {
        String sql = "SELECT id, name,stylistid FROM clients";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Client.class);
        }
    }

    @Override
    public boolean equals(Object otherClient) {
        if (!(otherClient instanceof Client)) {
            return false;
        } else {
            Client newClient = (Client) otherClient;
            return
                    this.getId() == newClient.getId();

            /*return this.getName().equals(newClient.getName()) &&
                    this.getId() == newClient.getId() &&
                    this.getStylistId() == newClient.getStylistId();*/
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO clients (name, stylistid) VALUES (:name ,:stylistid)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("stylistid", this.stylistid)
                    .executeUpdate()
                    .getKey();

        }
    }

/*
  public boolean isAvailable() {
    return mAvailable;
  }

  public LocalDateTime getClientSince() {
    return mClientSince;
  }

  public static List<Client> all() {
   return instances;
 }

  public static void clear() {
    instances.clear();
  }*/

    public int getId() {
        return id;
    }

    public static Client find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM clients where id=:id";
            Client client = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Client.class);
            return client;

        }

    }
}
