public class MediaPlayer {
  private int volume;
  private boolean muted;

  MediaPlayer() {
    this.volume = 5;
    this.muted = false;
  }

  public void increaseVolume() {
    volume++;
  }

  public void decreaseVolume() {
    volume--;
  }

  public String whatsPlaying() {
    return "Nothing to play";
  }

  public String toString() {
    return "Volume: " + volume + "\n" + whatsPlaying();
  }
}
