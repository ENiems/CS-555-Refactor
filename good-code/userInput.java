import java.util.Scanner;

public class userInput {
    public static void main(String[] args) {
        homeworkSchedule hwSchedule = new homeworkSchedule();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add upcoming assignment");
            System.out.println("2. Add upcoming test");
            System.out.println("3. Mark assignment as submitted");
            System.out.println("4. Delete assignment");
            System.out.println("5. Update assignment due date");
            System.out.println("6. View upcoming schedule");
            System.out.println("7. View this week");
            System.out.println("8. View this month");
            System.out.println("9. View overdue assignments");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice) {
            case 1:
            	hwSchedule.printFullList();
                System.out.print("Enter assignment name: ");
                String assignName = scanner.nextLine();
                System.out.print("Enter subject: ");
                String subject = scanner.nextLine();
                System.out.print("Enter month (1-12): ");
                int month = scanner.nextInt();
                System.out.print("Enter day (1-31): ");
                int day = scanner.nextInt();
                System.out.print("Enter year: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                hwSchedule.addAssignment(assignName, subject, month, day, year);
                break;
            case 2:
            	hwSchedule.printFullList();
                System.out.print("Enter test name: ");
                String testName = scanner.nextLine();
                System.out.print("Enter subject: ");
                String testSubject = scanner.nextLine();
                System.out.print("Enter month (1-12): ");
                int testMonth = scanner.nextInt();
                System.out.print("Enter day (1-31): ");
                int testDay = scanner.nextInt();
                System.out.print("Enter year: ");
                int testYear = scanner.nextInt();
                scanner.nextLine();
                hwSchedule.addTest(testName, testSubject, testMonth, testDay, testYear);
                break;
            case 3:
            	hwSchedule.printFullList();
                System.out.print("Enter assignment number to mark as submitted: ");
                int complNum = scanner.nextInt();
                scanner.nextLine();
                hwSchedule.completeAssignment(complNum);
                break;
            case 4:
            	hwSchedule.printFullList();
                System.out.print("Enter assignment number to delete: ");
                int delNum = scanner.nextInt();
                scanner.nextLine();
                hwSchedule.deleteAssignment(delNum);
                break;
            case 5:
            	hwSchedule.printFullList();
            	System.out.print("Enter assignment number to update: ");
            	int updateNum = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new month (1-12): ");
                int newMonth = scanner.nextInt();
                System.out.print("Enter new day (1-31): ");
                int newDay = scanner.nextInt();
                System.out.print("Enter new year: ");
                int newYear = scanner.nextInt();
                scanner.nextLine();
                hwSchedule.updateDate(updateNum, newMonth, newDay, newYear);
                break;
            case 6:
                hwSchedule.printUpcoming();
                break;
            case 7:
                hwSchedule.printThisWeek();
                break;
            case 8:
                hwSchedule.printThisMonth();
                break;
            case 9:
                hwSchedule.printOverdue();
                break;
            case 10:
            	return;
            default:
            	System.out.println("Invalid action");
            }
        }
    }
}
