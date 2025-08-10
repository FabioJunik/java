import java.util.ArrayList;
import java.util.List;

/**
 * Uma lista de eventos (visitas e concertos).
 *
 * @author POO
 * @version abril/2024
 */
public class Listings extends ArrayList<Listable> implements Searchable {
  public Listings() {
  }

  public int getNumberOfListings() {
    return size();
  }

  public void show() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    String str = "";
    for (Listable l : this) {
      str += "\n" + l.toString() + "\n";
    }
    return str;
  }

  @Override
  public List<Listable> searchFree() {
    List<Listable> correspondencies = new ArrayList<>();
    for (Listable l : this) {
      if (l.isFree()) {
        correspondencies.add(l);
      }
    }
    return correspondencies;
  }

  @Override
  public List<Listable> search(String searchText) {
    List<Listable> correspondencies = new ArrayList<>();
    for (Listable l : this) {
      if (l.toString().contains(searchText)) {
        correspondencies.add(l);
      }
    }
    return correspondencies;
  }

  @Override
  public List<Listable> searchWhere(String text) {
    List<Listable> correspondencies = new ArrayList<>();
    for (Listable l : this) {
      if (l.getWhere().equalsIgnoreCase(text)) {
        correspondencies.add(l);
      }
    }
    return correspondencies;
  }
}
