import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class hwScheduleTest {

    @Test
    void testAddAssignment() {
        homeworkSchedule hwSchedule = new homeworkSchedule();
        hwSchedule.addAssignment("Homework 1", 11, 18, 2024); 
        assertEquals(1, hwSchedule.schedule.size());
        assertEquals("Homework 1", hwSchedule.schedule.get(0).getAssignment());
    }

    @Test
    void testAddTest() {
        homeworkSchedule hwSchedule = new homeworkSchedule();
        hwSchedule.addTest("Test 1", 11, 25, 2024);
        assertEquals(1, hwSchedule.schedule.size());
        assertEquals("Test 1", hwSchedule.schedule.get(0).getAssignment());
    }

    @Test
    void testCompleteAssignment() {
        homeworkSchedule hwSchedule = new homeworkSchedule();
        hwSchedule.addAssignment("Homework 1", 11, 18, 2024);
        hwSchedule.completeAssignment(1); 
        assertTrue(hwSchedule.schedule.get(0).getStatus());
    }

    @Test
    void testDeleteAssignment() {
        homeworkSchedule hwSchedule = new homeworkSchedule();
        hwSchedule.addAssignment("Homework 1", 11, 18, 2024);
        hwSchedule.deleteAssignment(1);
        assertEquals(0, hwSchedule.schedule.size());
    }
    
    @Test
    void testUpdateDate() {
        homeworkSchedule hwSchedule = new homeworkSchedule();
        hwSchedule.addAssignment("Homework 1", 11, 18, 2024);
        hwSchedule.updateDate(1, 11, 20, 2024);
        assertEquals(LocalDate.of(2024, 11, 20), hwSchedule.schedule.get(0).getDue());
    }

    @Test
    void testSortSchedule() {
        homeworkSchedule hwSchedule = new homeworkSchedule();
        hwSchedule.addAssignment("Homework 2", 11, 25, 2024);
        hwSchedule.addAssignment("Homework 1", 11, 18, 2024); 
        assertEquals("Homework 1", hwSchedule.schedule.get(0).getAssignment()); 
    }
}
