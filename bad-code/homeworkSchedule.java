import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class homeworkSchedule {
    List<Assignment> schedule;
    public homeworkSchedule() { this.schedule = new ArrayList<>(); }

    public void addAssignment (String a, String b, int c, int d, int e) { 
        schedule.add(new Assignment(a, b, "homework", c, d, e));
        sortSchedule();
    }

    public void addTest (String a, String b, int c, int d, int e) { 
        schedule.add(new Assignment(a, b, "test", c, d, e));
        sortSchedule();
    }

    public void completeAssignment(int a) {
        if(a >= 1 && a <= schedule.size()) schedule.get((a - 1)).setStatus(true);
        else System.out.println("Invalid task number");
    }

    public void deleteAssignment(int a) {
        if(a >= 1 && a <= schedule.size()) schedule.remove((a - 1)); 
        else System.out.println("Invalid task number");
    }
    
    public void updateDate(int a, int b, int c, int d) {
        if(a >= 1 && a <= schedule.size()) schedule.get((a - 1)).setDue(b,c,d); 
        else System.out.println("Invalid task number");
    }

    public void printFullList() {
        for(int i=0;i<schedule.size();i++) {
            Assignment curr = schedule.get(i);
            System.out.print((i+1) + " - " + curr.getAssignment());
            if(curr.getStatus()) System.out.println(" - Submitted");
            else System.out.println(" - Not Submitted");
        }
    }

    public void printUpcoming() {
        LocalDate now = LocalDate.now(); 
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue(); 
            if (due.isAfter(now) || due.isEqual(now)) { 
                System.out.print(curr.getDue() + " - " + curr.getAssignment());
                if (curr.getStatus()) System.out.println(" - Submitted");
                else System.out.println(" - Not Submitted");
            }
        }
    }	

    public void printThisWeek() {
        LocalDate today = LocalDate.now();
        LocalDate start = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate end = start.plusDays(6);
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue();
            if ((due.isAfter(start) || due.isEqual(start)) && (due.isBefore(end) || due.isEqual(end))) {
                System.out.print(curr.getDue() + " - " + curr.getAssignment());
                if (curr.getStatus()) System.out.println(" - Submitted");
                else System.out.println(" - Not Submitted");
            }
        }
    }

    public void printThisMonth() {
        LocalDate today = LocalDate.now();
        LocalDate start = today.with(TemporalAdjusters.firstDayOfMonth()); 
        LocalDate end = today.with(TemporalAdjusters.lastDayOfMonth()); 
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue();
            if ((due.isAfter(start) || due.isEqual(start)) && (due.isBefore(end) || due.isEqual(end))) {
                System.out.print(curr.getDue() + " - " + curr.getAssignment());
                if (curr.getStatus()) System.out.println(" - Submitted");
                else System.out.println(" - Not Submitted");
            }
        }
    }

    public void printOverdue() {
        LocalDate now = LocalDate.now(); 
        for (int i = 0; i < schedule.size(); i++) {
            Assignment curr = schedule.get(i);
            LocalDate due = curr.getDue(); 
            if (due.isBefore(now) && !curr.getStatus()) { 
                System.out.print(curr.getDue() + " - " + curr.getAssignment());
            }
        }
    }	

    private void sortSchedule() {
        Collections.sort(schedule, Comparator.comparing(Assignment::getDue));
    }
}
