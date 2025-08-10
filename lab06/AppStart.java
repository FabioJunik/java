import java.time.LocalDateTime;

/**
 * Um programa que testa a utilização de visitas e concertos.
 *
 * @author POO
 * @version abril/2024
 */
public class AppStart {
    public static void main(String[] args) {
        GuidedTour gt100 = new GuidedTour("History", LocalDateTime.of(2024, 06, 07,
                10, 0), "Visit to Alcobaça Monastery", "Alcobaça");
        System.out.println(gt100);
        System.out.println();

        AudioTour at100 = new AudioTour("History", "Visit to Jerónimos Monastery");
        System.out.println(at100);
        System.out.println();

        Listings events = new Listings();
        events.add(gt100);
        events.add(at100);
        GuidedTour gt101 = new GuidedTour("Art", LocalDateTime.of(2024, 06, 04, 10,
                0), "Visit to Jerónimos Monastery", "Lisbon");
        events.add(gt101);
        AudioTour at101 = new AudioTour("History", "Visit to Belém Tower");
        events.add(at101);
        System.out.println("Number of listings: " + events.getNumberOfListings());
        System.out.println();
        System.out.println(events);
        System.out.println();
        events.show();
        System.out.println();

        System.out.println("Listings that contains the word: Monastery");
        for (Listable l : events.search("Monastery")) {
            System.out.println("\n" + l + "\n");
        }

        System.out.println("Listings in: Lisbon");
        for (Listable l2 : events.searchWhere("Lisbon")) {
            System.out.println("\n" + l2 + "\n");
        }

        System.out.println("Listings that are free");
        for (Listable l3 : events.searchFree()) {
            System.out.println("\n" + l3 + "\n");
        }

        System.out.println();
    }
}
