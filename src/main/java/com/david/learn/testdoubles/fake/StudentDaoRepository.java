package com.david.learn.testdoubles.fake;

import com.david.learn.pojos.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDaoRepository implements StudentDao {

    public StudentDaoRepository() {
    }

    @Override
    public void batchUpdate(List<Student> students) {

        List<Student> insertList = new ArrayList<>();
        List<Student> updateList = new ArrayList<>();

        for (Student student : students) {
            if (student.getRoleNumber() == null) {
                insertList.add(student);
            } else {
                updateList.add(student);
            }
        }

        int rowsInserted = 0;
        int rowsUpdated = 0;
        if (!insertList.isEmpty()) {
            List<Map<String, Object>> paramList = new ArrayList<>();
            for (Student std : insertList) {
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("name", std.getName());
                paramList.add(param);
            }
            int[] rowCount = update("insert", paramList);
            rowsInserted = sum(rowCount);
        }

        if (!updateList.isEmpty()) {
            List<Map<String, Object>> paramList = new ArrayList<>();
            for (Student std : updateList) {
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("roleId", std.getRoleNumber());
                param.put("name", std.getName());
                paramList.add(param);
            }
            int[] rowCount = update("update", paramList);
            rowsUpdated = sum(rowCount);
        }

        if (students.size() != (rowsInserted + rowsUpdated)) {
            throw new IllegalStateException("Database update error, expected "
                    + students.size() + " updates but actual "
                    + (rowsInserted + rowsUpdated));
        }

    }

    int[] update(String sql, List<Map<String, Object>> params) {
        return new JdbcSupport().batchUpdate(sql, params);
    }

    private int sum(int[] rows) {
        if (rows != null) {
            return Arrays.stream(rows).sum();
        }
        return 0;
    }

}
