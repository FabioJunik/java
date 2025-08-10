public class StreamPlayer extends MediaPlayer {
  private Podcast podcast;

  StreamPlayer() {
    super();
    this.podcast = null;
  }

  public void setPodcast(Podcast podcast) {
    this.podcast = podcast;
  }

  public Podcast getPodcast() {
    return this.podcast;
  }

  public String whatsPlaying() {
    return "Stream Player: O Homem que Mordeu o Cão";
  }
}
