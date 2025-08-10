import java.time.LocalDateTime;

/**
 * Uma visita guiada a um lugar.
 *
 * @author POO
 * @version abril/2024
 */
public class GuidedTour extends Tour {
    private static int auto = 100;
    private String tag;
    private String what;
    private String where;
    private LocalDateTime schedule;

    public GuidedTour(String tag, LocalDateTime schedule, String what, String where) {
        super("Guided Tour " + auto++);
        this.tag = tag;
        this.what = what;
        this.where = (where != null) ? where : "Setúbal";
        this.schedule = schedule;
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getSchedule() {
        return this.schedule;
    }

    public void setSchedule(LocalDateTime newSchedule) {
        this.schedule = newSchedule;
    }

    // NIVEL 3
    @Override
    public String getWhat() {
        return this.what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    @Override
    public String getWhere() {
        return this.where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public String getWhen() {
        return this.schedule.toLocalDate() + " " + this.schedule.toLocalTime();
    }

    @Override
    public String toString() {
        return String.format(
                "What:\t  %s\n" + "Where: \t  %s\n" + "When: \t  %s\n" + "How long: %d minutes\n" + "How much: %,.2f€",
                getWhat(), getWhere(), getWhen(), getHowLong(), getHowMuch());
    }
}
