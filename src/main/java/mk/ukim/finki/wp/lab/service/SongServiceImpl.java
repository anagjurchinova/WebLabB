package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void addArtistToSong(Artist artist, Song song) {
        songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) throws Exception {
        Optional<Song> song = songRepository.findByTrackId(trackId);
        if(song.isPresent()){
            return song.get();
        }
        throw new Exception("Song not found.");
    }
}
