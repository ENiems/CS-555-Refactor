import java.time.LocalDate;

public class Assignment {
    // Private member variable to store the name of the assignment
    private String name;
    
    // Final member variable to store the type of assignment (cannot be changed once set)
    private final String type;
    
    // Boolean to track the completion status of the assignment (true if completed, false if not)
    private boolean completion;
    
    // Stores the due date of the assignment as a LocalDate object
    private LocalDate due;

    // Constructor to initialize assignment details including name, type, and due date
    public Assignment(String assign, String type, int month, int day, int year) {
        this.name = assign;
        this.type = type;
        this.completion = false; // Sets default completion status to false
        this.due = LocalDate.of(year, month, day); // Initializes due date
    }

    // Getter for the assignment name
    public String getAssignment() {
        return name;
    }

    // Setter to update the assignment name
    public void setTask(String input) {
        this.name = input;
    }

    // Getter for the assignment completion status
    public boolean getStatus() {
        return completion;
    }

    // Setter to update the completion status of the assignment
    public void setStatus(boolean input) {
        completion = input;
    }

    // Getter for the due date of the assignment
    public LocalDate getDue() {
        return due;
    }

    // Setter to update the due date of the assignment
    public void setDue(int month, int day, int year) {
        this.due = LocalDate.of(year, month, day);
    }

    // Getter for the assignment type (cannot be changed after initialization)
    public String getType() {
        return type;
    }
}
