package com.david.learn.testdoubles.fake;

import com.david.learn.pojos.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDaoImpl implements StudentDao {

    public StudentDaoImpl() {
    }

    @Override
    public void batchUpdate(List<Student> students) {
        List<Student> insertList = students.stream()
                .filter(s -> s.getRoleNumber() == null)
                .collect(Collectors.toList());

        List<Student> updateList = students.stream()
                .filter(s -> s.getRoleNumber() != null)
                .collect(Collectors.toList());

        int rowsInserted = 0;
        int rowsUpdated = 0;

        if (!insertList.isEmpty()) {
            List<Map<String, Object>> paramList = new ArrayList<>();

            for (Student std : insertList) {
                Map<String, Object> param = new HashMap<>();
                param.put("name", std.getName());
                paramList.add(param);
            }

            int[] rowCount = this.update("insert", paramList);
            rowsInserted = this.sum(rowCount);
        }

        if (!updateList.isEmpty()) {

            List<Map<String, Object>> paramList = new ArrayList<>();

            for (Student std : updateList) {
                Map<String, Object> param = new HashMap<>();
                param.put("roleId", std.getRoleNumber());
                param.put("name", std.getName());
                paramList.add(param);
            }

            int[] rowCount = this.update("update", paramList);
            rowsUpdated = this.sum(rowCount);
        }

        if (students.size() != (rowsInserted + rowsUpdated)) {
            throw new IllegalStateException("Error the amount of data is inconsistent");
        }

    }

    public int[] update(String sql, List<Map<String, Object>> params) {
        return new JdbcSupport().batchUpdate(sql, params);
    }

    private int sum(int[] rows) {
        if(rows != null){
            return Arrays.stream(rows).sum();
        }
        return 0;
    }

}
