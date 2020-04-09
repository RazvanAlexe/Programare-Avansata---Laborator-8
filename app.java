package ro.uaic.info.lab8;

public class app {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        AlbumController AbC = new AlbumController(database);
        ArtistController AtC = new ArtistController(database);
        database.closeConnection();
    }

}
