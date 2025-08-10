import java.util.List;

public class LiveRadioPlayer extends MediaPlayer {
  private List<Station> stationList;
  private Station currentStation;

  LiveRadioPlayer() {
    super();
    this.stationList = null;
    this.currentStation = null;
  }

  public void setStationList(List<Station> stationList) {
    this.stationList = stationList;
  }

  public List<Station> getStationList() {
    return this.stationList;
  }

  public void setCurrentStation(Station currentStation) {
    this.currentStation = currentStation;
  }

  public Station getCurrentStation() {
    return this.currentStation;
  }

  public String whatsPlaying() {
    return "Live Radio Player: " + currentStation.getFrequency() + ": " + currentStation.getName();
  }

  public void nextStation() {
    if (stationList != null && !stationList.isEmpty()) {
      int currentIndex = stationList.indexOf(currentStation);
      boolean isLastStation = currentIndex == stationList.size() - 1;
      currentStation = isLastStation ? stationList.get(0) : stationList.get(currentIndex + 1);
    }
  }

  public void previousStation() {
    if (stationList != null && !stationList.isEmpty()) {
      int currentIndex = stationList.indexOf(currentStation);
      boolean isFirstStation = currentIndex == 0;
      currentStation = isFirstStation ? stationList.get(stationList.size() - 1) : stationList.get(currentIndex - 1);
    }
  }
}
