
/**
 * Uma visita a um lugar usando um guia audio .
 *
 * @author POO
 * @version abril/2024
 */
public class AudioTour extends Tour {
    private static int auto = 100;
    private static final String WHERE = "Setúbal";
    private String tag;
    private String what;

    public AudioTour(String tag, String what) {
        super("Audio Tour " + auto++);
        this.what = what;
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        return this.WHERE;
    }

    @Override
    public String getWhen() {
        return "Everyday, between 8:00 and 20:00";
    }

    @Override
    public String toString() {
        return String.format(
                "What:\t  %s\n" + "Where:\t  %s\n" + "When:\t  %s\n" + "How long: %d minutes\n" + "How much: %,.2f€",
                getWhat(), getWhere(), getWhen(), getHowLong(), getHowMuch());
    }

}
