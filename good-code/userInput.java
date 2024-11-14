import java.util.Scanner;

public class userInput {
    public static void main(String[] args) {
        // Create an instance of homeworkSchedule to manage assignments
        homeworkSchedule hwSchedule = new homeworkSchedule();
        Scanner scanner = new Scanner(System.in);

        // Main program loop, providing options for the user to interact with the schedule
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
            
            // Get the user's choice and clear the line for any next input
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            // Perform action based on user choice
            switch (choice) {
                case 1: // Add a new homework assignment
                    hwSchedule.printFullList();
                    System.out.print("Enter assignment name: ");
                    String assignName = scanner.nextLine();
                    System.out.print("Enter month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.print("Enter day (1-31): ");
                    int day = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    hwSchedule.addAssignment(assignName, month, day, year);
                    break;

                case 2: // Add a new test
                    hwSchedule.printFullList();
                    System.out.print("Enter test name: ");
                    String testName = scanner.nextLine();
                    System.out.print("Enter month (1-12): ");
                    int testMonth = scanner.nextInt();
                    System.out.print("Enter day (1-31): ");
                    int testDay = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int testYear = scanner.nextInt();
                    scanner.nextLine();
                    hwSchedule.addTest(testName, testMonth, testDay, testYear);
                    break;

                case 3: // Mark an assignment as submitted
                    hwSchedule.printFullList();
                    System.out.print("Enter assignment number to mark as submitted: ");
                    int complNum = scanner.nextInt();
                    scanner.nextLine();
                    hwSchedule.completeAssignment(complNum);
                    break;

                case 4: // Delete an assignment
                    hwSchedule.printFullList();
                    System.out.print("Enter assignment number to delete: ");
                    int delNum = scanner.nextInt();
                    scanner.nextLine();
                    hwSchedule.deleteAssignment(delNum);
                    break;

                case 5: // Update the due date of an assignment
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

                case 6: // View upcoming assignments
                    hwSchedule.printUpcoming();
                    break;

                case 7: // View assignments due this week
                    hwSchedule.printThisWeek();
                    break;

                case 8: // View assignments due this month
                    hwSchedule.printThisMonth();
                    break;

                case 9: // View overdue assignments
                    hwSchedule.printOverdue();
                    break;

                case 10: // Exit the program
                    return;

                default: // Handle invalid inputs
                    System.out.println("Invalid action");
            }
        }
    }
}
