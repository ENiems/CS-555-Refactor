import java.time.LocalDate;

public class Assignment {
	private String name;
	private String subject;
	private String type;
	private boolean completion;
	private LocalDate due;
	
	public Assignment(String assign, String subject, String type, int month, int day, int year) {
		this.name = assign;
		this.subject = subject;
		this.type = type;
		this.completion = false;
		this.due = LocalDate.of(year, month, day); 
	}
	
	public String getAssignment() {
		return name;
	}
	public void setTask(String input) {
		this.name = input;
	}
	public boolean getStatus() {
		return completion;
	}
	public void setStatus(boolean input) {
		completion = input;
	}
	public LocalDate getDue() {
		return due;
	}
	public void setDue(int month, int day, int year) {
		this.due = LocalDate.of(year, month, day); 
	}
	public String getSubject() {
		return subject;
	}
	public String getType() {
		return type;
	}
	
}
