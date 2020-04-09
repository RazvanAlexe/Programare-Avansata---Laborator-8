package ro.uaic.info.lab8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlbumController {
    private Database database;

    public AlbumController(Database database) {
        this.database = database;
    }

    public void Create(String name, String country) {
        try {
            int id = 0;
            Statement stmt = database.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM albums");
            while(rs.next()){
                id = rs.getInt(1);
            }
            id = id + 1;
            stmt.executeUpdate("INERT INTO artists VALUES (" + id + ", '" + name + "', '" + country + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void findByName(String name) {
        try {
            Statement stmt = database.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM albums WHERE name = " + name);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
