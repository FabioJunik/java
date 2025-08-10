import java.util.ArrayList;
import java.util.List;

/**
 * Main entry class
 *
 * @author POO
 * @version April '24
 */
public class AppStart {
    public static void main(String[] args) {
        StreamPlayer streamPlayer = new StreamPlayer();

        List<Podcast> podcasts = new ArrayList<>();
        podcasts.add(new Podcast("O Homem que Mordeu o Cão"));
        podcasts.add(new Podcast("O CEO é o limite"));
        podcasts.add(new Podcast("Portugalex"));

        streamPlayer.setPodcast(podcasts.get(0));
        System.out.println(streamPlayer.whatsPlaying());

        LiveRadioPlayer liveRadioPlayer = new LiveRadioPlayer();

        List<Station> stations = new ArrayList<>();
        stations.add(new Station(88.3, "KFM"));
        stations.add(new Station(93.2, "RFM"));
        stations.add(new Station(95.7, "Antena 1"));
        stations.add(new Station(97.4, "Rádio Comercial"));
        stations.add(new Station(101.9, "Orbital"));

        liveRadioPlayer.setStationList(stations);
        liveRadioPlayer.increaseVolume();
        liveRadioPlayer.increaseVolume();
        liveRadioPlayer.increaseVolume();

        liveRadioPlayer.nextStation();
        System.out.println(liveRadioPlayer.whatsPlaying());
        liveRadioPlayer.nextStation();
        System.out.println(liveRadioPlayer.whatsPlaying());

        List<MediaPlayer> mediaPlayers = new ArrayList<>();
        mediaPlayers.add(streamPlayer);
        mediaPlayers.add(liveRadioPlayer);

        for (MediaPlayer mediaPlayer : mediaPlayers) {
            System.out.println(mediaPlayer.whatsPlaying());
        }

    }
}
