

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 *
 * @author POO
 * 
 */
public class ListOfElementsTest {

    @Test
    public void testAdd() {
        ListOfElements<Task> list = new ListOfElements<>("Header");
        Task t1 = new Task("Study for POO T2", 3, LocalDate.of(2025,6,26));
        Task t2 = new Task("Do POO project phase 2", 2, LocalDate.of(2025,6,16));
        Task t3 = new Task("Do POO project phase 1", 1, LocalDate.of(2024,5,5));
        Task t4 = new Task("Study for POO test", 2, LocalDate.of(2024, 6, 4));

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        assertEquals(4, list.size());
    }
}
