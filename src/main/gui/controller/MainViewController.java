package gui.controller;

import be.Playlist;
import be.Song;
import gui.model.PlaylistModel;
import gui.model.SongModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private PlaylistModel playlistModel;
    private SongModel songModel;
    private MediaPlayer mediaPlayer;
    private Media media;
    private int currentTable;
    private List<Song> allSongs;

    @FXML
    private TableView<Song> songsListView;

    @FXML
    private TableColumn<Song, String> songArtistColumn;

    @FXML
    private TableColumn<Song, String> songCategoryColumn;

    @FXML
    private TableColumn<Song, String> songTimeColumn;

    @FXML
    private TableView<Playlist> playlistListView;

    @FXML
    private TableColumn<Playlist, String> playlistNameColumn;

    @FXML
    private TableColumn<Playlist, Integer> playlistNSongsColumn;

    @FXML
    private TableColumn<Playlist, String> playlistTimeColumn;

    @FXML
    private Button addSongToPlaylist;

    @FXML
    private Label currentlyPlayingSongLabel;

    @FXML
    private Button deleteFromPlaylist;

    @FXML
    private Button deletePlaylistButton;

    @FXML
    private Button editPlaylistButton;

    @FXML
    private TextField filterTextField;

    @FXML
    private Button moveDownButton;

    @FXML
    private Button moveUpButton;

    @FXML
    private Button newPlaylistButton;

    @FXML
    private Button newSongButton;

    @FXML
    private Button nextSongButton;

    @FXML
    private Button playSongButton;

    @FXML
    private Button previousSongButton;

    @FXML
    private Button searchButton;
    /**
     * TIME FOR SONGS
     */

    @FXML
    private TableColumn<Song, String> songTitleColumn;

    @FXML
    private ListView<Song> songsOnPlaylistListView;

    @FXML
    private Slider volumeSlider;

    public MainViewController() {
        try {
            playlistModel = new PlaylistModel();
            songModel = new SongModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateSongTableView();
        updatePLaylistTableView();
    }

    public void updateSongTableView(){
        songsListView.getItems().clear();
        songsListView.refresh();
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        songArtistColumn.setCellValueFactory(new PropertyValueFactory<>("Artist"));
        songCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        songTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        songsListView.getItems().setAll(songModel.getSongs());
    }

    public void updatePLaylistTableView(){
        playlistListView.getItems().clear();
        playlistListView.refresh();
        playlistNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        playlistNSongsColumn.setCellValueFactory(new PropertyValueFactory<>("HowManySongs"));
        playlistTimeColumn.setCellValueFactory(new PropertyValueFactory<>("TotalReproductionTime"));
        playlistListView.getItems().setAll(playlistModel.getAllPlaylist());

    }

    public void initMediaPlayer() {
        media = new Media(new File(songModel.getFilePathOfCurrentPlayingSong()).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }
    //************************ TODO LATER
    public String filePathOfNextSongInPlaylist(){
        return null;
    }

    public String filePathOfNextSongInAllSongs(){
        return null;
    }

    public void playSongFromPlaylist(MouseEvent mouseEvent) {
        currentTable = 1;
    }

    public void playSongFromSongs(MouseEvent mouseEvent) {
        currentTable = 2;
    }

    @FXML
    void addSongToPlaylist(ActionEvent event) {
        playlistModel.addSongToPlaylist();
    }

    //*********************** END OF TODO LATER

    @FXML
    void deletePlaylist(ActionEvent event) {
        playlistModel.deletePlaylist();
    }

    @FXML
    void deleteSongFromPlaylist(ActionEvent event) {
        playlistModel.deleteSongFromPlaylist();
    }

    @FXML
    void handleVolume(MouseEvent event) {
        //TODO
    }

    @FXML
    void moveDownSongInPlaylist(ActionEvent event) {
        playlistModel.moveDownSongInPlaylist();
    }

    @FXML
    void moveUpSongInPlaylist(ActionEvent event) {
        playlistModel.moveUpSongInPlaylist();
    }

    @FXML
    void nextSong(ActionEvent event) {
        if (currentTable == 1) {

        }
    }

    @FXML
    void playSong(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    void previousSong(ActionEvent event) {
        //songModel.getPreviousSong();
    }

    @FXML
    void searchSong(ActionEvent event) {
        //TODO
    }

    @FXML
    void searchSongTextField(ActionEvent event) {
        //TODO
    }

    @FXML
    void updatePlaylistButton(ActionEvent event) {
        playlistModel.updatePlaylist();
    }

}
