import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory


class StudentTest {
    @Test
    fun testsetMarkValid(){
        val s = Student("1", "kenny", "CS", 0)
        s.mark = 0
        assertEquals(0, s.mark)

        s.mark = 1
        assertEquals(1, s.mark)

        s.mark = 100
        assertEquals(100, s.mark)
    }
    @Test
    fun testsetMarkInvalid(){
        val s = Student("1", "kenny", "CS", 50)
        s.mark = -1
        assertEquals(50, s.mark)

        s.mark = 101
        assertEquals(50, s.mark)
    }
    @Test
    fun testgetGradeReturnsCorrectGrade(){
        assertEquals("First",
            Student("s1", "kennyA", "CS", 100).getGrade()
        )

        assertEquals("2/1",
            Student("s2", "kennyB", "CS", 69).getGrade()
        )

        assertEquals("2/2",
            Student("s3", "kennyC", "CS", 59 ).getGrade()
        )
    }
    @TestFactory
    fun testGetGradeboundrires() =
        listOf(
            100 to "First", 70 to "First", 69 to "2/1", 60 to "2/1", 59 to "2/2",
            50 to "2/2", 49 to "Third", 40 to "Third", 39 to "Fail"
        ).map { (mark, expectedGrade) ->
            dynamicTest("Mark $mark should return grade for $expectedGrade") {
                val Student = Student("s$mark", "kenny", "CS", mark)
                assertEquals(expectedGrade, Student.getGrade())
            }
        }
}