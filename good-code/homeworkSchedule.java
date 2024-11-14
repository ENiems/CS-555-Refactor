import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class homeworkSchedule {
    // List to store assignments in the schedule
    List<Assignment> schedule;

    // Constructor that initializes the schedule list
    public homeworkSchedule() {
        this.schedule = new ArrayList<>();
    }

    // Adds a homework assignment to the schedule and sorts by due date
    public void addAssignment(String assignment, int month, int date, int year) {
        schedule.add(new Assignment(assignment, "homework", month, date, year));
        sortSchedule();
    }

    // Adds a test assignment to the schedule and sorts by due date
    public void addTest(String assignment, int month, int date, int year) {
        schedule.add(new Assignment(assignment, "test", month, date, year));
        sortSchedule();
    }

    // Marks an assignment as completed based on its number in the list
    public void completeAssignment(int assignmentNum) {
        if (assignmentNum >= 1 && assignmentNum <= schedule.size()) 
            schedule.get(assignmentNum - 1).setStatus(true);
        else 
            System.out.println("Invalid task number");
    }

    // Removes an assignment from the schedule based on its number in the list
    public void deleteAssignment(int assignmentNum) {
        if (assignmentNum >= 1 && assignmentNum <= schedule.size()) 
            schedule.remove(assignmentNum - 1);
        else 
            System.out.println("Invalid task number");
    }
    
    // Updates the due date of a specific assignment in the list
    public void updateDate(int assignmentNum, int month, int date, int year) {
        if (assignmentNum >= 1 && assignmentNum <= schedule.size()) 
            schedule.get(assignmentNum - 1).setDue(month, date, year);
        else 
            System.out.println("Invalid task number");
    }

    // Prints a full list of assignments with their submission status
    public void printFullList() {
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            System.out.print((i + 1) + " - " + curr.getAssignment());
            if (curr.getStatus()) 
                System.out.println(" - Submitted");
            else 
                System.out.println(" - Not Submitted");
        }
    }

    // Prints only upcoming assignments, including today's, with their status
    public void printUpcoming() {
        LocalDate now = LocalDate.now();
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue();
            if (due.isAfter(now) || due.isEqual(now)) { 
                System.out.print(curr.getDue() + " - " + curr.getAssignment());
                if (curr.getStatus()) 
                    System.out.println(" - Submitted");
                else 
                    System.out.println(" - Not Submitted");
            }
        }
    }

    // Prints assignments due this week, from Sunday to Saturday, with their status
    public void printThisWeek() {
        LocalDate today = LocalDate.now();
        LocalDate start = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate end = start.plusDays(6);
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue();
            if ((due.isAfter(start) || due.isEqual(start)) && (due.isBefore(end) || due.isEqual(end))) {
                System.out.print(curr.getDue() + " - " + curr.getAssignment());
                if (curr.getStatus()) 
                    System.out.println(" - Submitted");
                else 
                    System.out.println(" - Not Submitted");
            }
        }
    }

    // Prints assignments due this month, with their status
    public void printThisMonth() {
        LocalDate today = LocalDate.now();
        LocalDate start = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate end = today.with(TemporalAdjusters.lastDayOfMonth());
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue();
            if ((due.isAfter(start) || due.isEqual(start)) && (due.isBefore(end) || due.isEqual(end))) {
                System.out.print(curr.getDue() + " - " + curr.getAssignment());
                if (curr.getStatus()) 
                    System.out.println(" - Submitted");
                else 
                    System.out.println(" - Not Submitted");
            }
        }
    }

    // Prints overdue assignments that have not been completed
    public void printOverdue() {
        LocalDate now = LocalDate.now();
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue();
            if (due.isBefore(now) && !curr.getStatus()) { 
                System.out.println(curr.getDue() + " - " + curr.getAssignment());
            }
        }
    }

    // Sorts the assignments in the schedule by their due date
    private void sortSchedule() {
        Collections.sort(schedule, Comparator.comparing(Assignment::getDue));
    }
}
