package dal.interfaces;

import be.Song;

import java.sql.SQLException;
import java.util.List;

public interface ISongRepository {

    Song addSong(Song song) throws SQLException;

    void deleteSong(Song song);

    void updateSong(Song song) throws SQLException;

    Song getSong(int id) throws SQLException;

    List<Song> getAllSongs();

}
