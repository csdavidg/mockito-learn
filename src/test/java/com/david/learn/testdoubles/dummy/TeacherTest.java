package com.david.learn.testdoubles.dummy;

import com.david.learn.pojos.Grades;
import com.david.learn.pojos.Marks;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeacherTest {

    @Test
    public void whenMarksAboveSeventyFivePercentReturnsVeryGood(){
        DummyStudent dummyStudent = new DummyStudent();

        Marks inEnglish = new Marks(dummyStudent, "English002", new BigDecimal("81.00"));
        Marks inMath = new Marks(dummyStudent, "Math005", new BigDecimal("97.00"));
        Marks inHistory = new Marks(dummyStudent, "History007", new BigDecimal("79.00"));

        List<Marks> marks = Arrays.asList(inEnglish, inMath, inHistory);

        Grades grade = new Teacher().generateGrade(marks);
        assertEquals(Grades.VERYGOOD, grade);

    }

}
