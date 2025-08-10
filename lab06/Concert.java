import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Um concerto listável.
 *
 * @author POO
 * @version abril/2024
 */
public class Concert implements Listable {

  private static final String WHAT = "Music at José Afonso Square";
  private static final String WHERE = "Setúbal";
  private static final double HOW_MUCH = 0.0;
  private static final boolean FREE = true;
  private String who;
  private LocalDateTime schedule;

  public Concert(String who, LocalDateTime schedule) {
    this.who = (who != null) ? who : "-";
    this.schedule = schedule;
  }

  public Concert() {
    this("-", LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 0)));
  }

  public String getWho() {
    return this.who;
  }

  public void setWho(String who) {
    this.who = who;
  }

  public LocalDateTime getSchedule() {
    return this.schedule;
  }

  public void setSchedule(LocalDateTime schedule) {
    this.schedule = schedule;
  }

  @Override
  public String getWhat() {
    return this.WHAT;
  }

  @Override
  public String getWhere() {
    return this.WHERE;
  }

  @Override
  public String getWhen() {
    return this.schedule.toLocalDate() + " " + this.schedule.toLocalTime();
  }

  @Override
  public int getHowLong() {
    return this.STANDARD_HOW_LONG;
  }

  @Override
  public double getHowMuch() {
    return this.HOW_MUCH;
  }

  @Override
  public boolean isFree() {
    return this.FREE;
  }

  @Override
  public String toString() {
    return String.format(
        "Who:\t  %s\nWhat:\t  %s\n" + "Where:\t  %s\n" + "When:\t  %s\n" + "How long: %d minutes\n"
            + "How much: %,.2f€",
        this.who, getWhat(), getWhere(), getWhen(), getHowLong(), getHowMuch());
  }
}