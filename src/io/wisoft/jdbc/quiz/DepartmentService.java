package io.wisoft.jdbc.quiz;

import java.sql.*;
import java.util.*;

public class DepartmentService {

    public void departmentFindAll() {
        String query = "SELECT * FROM DEPARTMENT";

        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            List<Department> departments = new ArrayList<>();

            while (rs.next()) {
                departments.add(new Department(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

            printDepartment(departments);

        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    private void printSQLException(final SQLException e) {
        System.out.format("SQLException: %s, SQLException: %s", e.getMessage(), e.getSQLState());
    }

    private void printDepartment(final List<Department> departments) {
        for (Department department : departments) {
            System.out.print(department); //toString 생략
        }
    }

}
