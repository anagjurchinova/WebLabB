package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.wp.lab.service.SongService;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {
    String trackId;
    String title;
    String genre;
    int releaseYear;
    public List<Artist> performers;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>(performers);
    }
}
