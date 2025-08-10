public interface Listable {

    public static final int STANDARD_HOW_LONG = 60;
    public static final double STANDARD_HOW_MUCH = 20.0;

    String getWhat();

    String getWhere();

    String getWhen();

    int getHowLong();

    double getHowMuch();

    boolean isFree();

}
