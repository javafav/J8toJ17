package jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

public class MusicCallableStatement {

    private static final int ARTIST_COLUMN = 0;
    private static final int ALBUM_COLUMN = 1;
    private static final int SONG_COLUMN = 3;


    public static void main(String[] args) {
        Map<String, Map<String, String>> albums = null;
        try(var lines = Files.lines(Path.of("files/NewAlbums.csv"))) {
            albums = lines.map(s -> s.split(","))
                    .collect(Collectors.groupingBy(s -> s[ARTIST_COLUMN],
                            Collectors.groupingBy(s -> s[ALBUM_COLUMN],
                                    Collectors.mapping(s -> s[SONG_COLUMN],
                                            Collectors.joining(
                                                    "\",\"",
                                                    "[\"",
                                                    "\"]"
                                            )))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        albums.forEach((artist, artistAlbums) -> {
            artistAlbums.forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });
        });
    }
}
