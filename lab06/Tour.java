
/**
 * Uma visita a um lugar
 *
 * @author POO
 * @version abril/2024
 */
public abstract class Tour implements Listable {
    public final String ID;

    public Tour(String id) {
        this.ID = id;
    }

    public abstract String getTag();

    @Override
    public int getHowLong() {
        return STANDARD_HOW_LONG;
    }

    @Override
    public double getHowMuch() {
        return STANDARD_HOW_MUCH;
    }

    @Override
    public boolean isFree() {
        return false;
    }

}
