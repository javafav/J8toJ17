package debugging.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("John Doe", 20);
    }

    @Test
    void testStudentInitialization() {
        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
        assertTrue(student.getGrades().isEmpty());
    }

    @Test
    void testAddGrade() {
        student.addGrade(85);
        student.addGrade(90);
        List<Integer> grades = student.getGrades();
        assertEquals(2, grades.size());
        assertEquals(85, grades.get(0));
        assertEquals(90, grades.get(1));
    }

    @Test
    void testAddInvalidGrade() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> student.addGrade(150));
        assertEquals("Grade must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void testAverageGradeCalculation() {
        student.addGrade(70);
        student.addGrade(80);
        student.addGrade(90);
        assertEquals(80.0, student.getAverageGrade(), 0.001);
    }

    @Test
    void testAverageGradeWithNoGrades() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, student::getAverageGrade);
        assertEquals("No grades available.", exception.getMessage());
    }

    @Test
    void testStudentPassStatus() {
        student.addGrade(40);
        student.addGrade(60);
        student.addGrade(50);
        assertTrue(student.hasPassed());
    }

    @Test
    void testStudentFailStatus() {
        student.addGrade(30);
        student.addGrade(40);
        assertFalse(student.hasPassed());
    }

    @Test
    void testInvalidAge() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Student("Alice", 150));
        assertEquals("Age must be between 5 and 100.", exception.getMessage());
    }
}
