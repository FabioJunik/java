import java.util.List;

/**
 *
 * @author POO
 * @version março/2024
 */

public interface Searchable {

    List<Listable> search(String searchText);

    List<Listable> searchWhere(String where);

    List<Listable> searchFree();

}
