package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    static public List<Song> songs = new ArrayList<>(5);
    private final ArtistRepository artistRepository;
    public SongRepository(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }
    @PostConstruct
    public void init(){
        List<Artist> allArtists = artistRepository.findAll();
        songs.add(new Song("01", "Silent Echoes", "Rock", 2015, List.of(allArtists.get(0))));
        songs.add(new Song("02", "Whispered Dreams", "Jazz", 2018, List.of(allArtists.get(1))));
        songs.add(new Song("03", "Rhythmic Waves", "Pop", 2020, List.of(allArtists.get(2))));
        songs.add(new Song("04", "Melody of Rain", "Classical", 2022, List.of(allArtists.get(3))));
        songs.add(new Song("05", "Soul Voyage", "Soul", 2017, List.of(allArtists.get(4))));

    }

    public List<Song> findAll(){
        return songs;
    }

    public Optional<Song> findByTrackId(String trackId){
        return songs
                .stream()
                .filter(s -> s.getTrackId().equals(trackId))
                .findFirst();
    }

    public void addArtistToSong(Artist artist, Song song){
        System.out.println("Performers before adding: " + song.performers);
        System.out.println("Artist: " + artist.getFirstName() + " song: " + song.getTitle());
        song.performers.add(artist);
        System.out.println("Performers after adding: " + song.performers);
    }
}
