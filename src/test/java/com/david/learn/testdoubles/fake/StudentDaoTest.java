package com.david.learn.testdoubles.fake;

import com.david.learn.pojos.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StudentDaoTest {

    private TesteableStudentDao dao;
    private Map<String, Integer> sqlCount = null;

    @Before
    public void setUp(){
        dao = new TesteableStudentDao();
        sqlCount = new HashMap<>();
    }

    @Test(expected = IllegalStateException.class)
    public void whenRowCountDoesNotMatchThenRollBackTransaction(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(null, "Gautam Kohli"));

        int[] expectUpdateFailsCount = {0};

        dao.valuesToReturn = expectUpdateFailsCount;
        dao.batchUpdate(students);
    }

    @Test
    public void whenNewStudentThenCreatesStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(null, "Gautam Kohli"));

        int[] expectUpdateSuccess = {1};
        dao.valuesToReturn = expectUpdateSuccess;
        dao.batchUpdate(students);

        int actualInsertCount = sqlCount.get("insert");
        int expectedInsertCount = 1;
        assertEquals(expectedInsertCount, actualInsertCount);
    }

    class TesteableStudentDao extends StudentDaoImpl {

        int[] valuesToReturn;

        public int[] update(String sql, List<Map<String, Object>> params) {

            Integer count = sqlCount.get(sql);
            if (count == null) {
                sqlCount.put(sql, params.size());
            } else {
                sqlCount.put(sql, count + params.size());
            }

            if (valuesToReturn != null) {
                return valuesToReturn;
            }

            return valuesToReturn;
        }
    }

}
