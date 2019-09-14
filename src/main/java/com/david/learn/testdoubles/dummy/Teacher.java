package com.david.learn.testdoubles.dummy;

import com.david.learn.pojos.Grades;
import com.david.learn.pojos.Marks;

import java.math.BigDecimal;
import java.util.List;

public class Teacher {

    public Grades generateGrade(List<Marks> marksList) {
        BigDecimal aggregate = BigDecimal.ZERO;

        for (Marks mark : marksList) {
            aggregate = aggregate.add(mark.getMarks());
        }

        BigDecimal percentage = calculatePercent(aggregate, marksList.size());

        if (percentage.compareTo(new BigDecimal("90.00")) > 0) {
            return Grades.EXCELENT;
        }

        if (percentage.compareTo(new BigDecimal("75.00")) > 0) {
            return Grades.VERYGOOD;
        }

        if (percentage.compareTo(new BigDecimal("60.00")) > 0) {
            return Grades.GOOD;
        }

        if (percentage.compareTo(new BigDecimal("40.00")) > 0) {
            return Grades.AVERAGE;
        }

        return Grades.GOOD;
    }

    private BigDecimal calculatePercent(BigDecimal aggregate, int numberOfSubjects) {
        return new BigDecimal(aggregate.doubleValue() / numberOfSubjects);
    }

}
