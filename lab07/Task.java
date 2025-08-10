import java.time.LocalDate;

public class Task implements Orderable {
  private String description;
  private int priority;
  private LocalDate date;

  public Task(String description, int priority, LocalDate date) {
    this.description = description;
    this.priority = priority;
    this.date = date;
  }

  public int getPriority() {
    return this.priority;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public String getDescription() {
    return this.description;
  }

  public String getHeader() {
    return "\"\\n" + //
        " |--------------------------------------------------------|\"\r\n" + //
        "+ \"\\n" + //
        " | Priority | Task name                      | Due date   |\"\r\n" + //
        "+ \"\\n" + //
        " |----------|--------------------------------|------------|\"";
  }

  // Implemente o método toString. Utilize o método format da classe String para
  // alinhar os valores dos atributos com o header fornecido.

  public String toString() {
    return String.format("| %8d | %-30s | %s |", this.priority, this.description, this.date);
  }

  public boolean equals(Task task) {
    return this.description.equals(task.description) && this.date.equals(task.date);
  }
}
