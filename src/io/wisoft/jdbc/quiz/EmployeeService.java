package io.wisoft.jdbc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public void employeeFindAll() {
        String query = "SELECT EMP_CODE, EMP_NAME, EMP_MGT, EMP_SAL FROM EMPLOYEE";

        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<Employee> employees = new ArrayList<>();

            while (rs.next()) {
                employees.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }

            printEmployeeAll(employees);

        } catch(SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void employeeFindName() {
        String query = "SELECT e1.emp_name, e2.emp_name \n" +
                "  from employee e1 left outer join employee e2 \n" +
                "on e1.emp_mgt = e2.emp_code;";
        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<Employee> employees = new ArrayList<>();

            while (rs.next()) {
                employees.add(new Employee(rs.getString(1), rs.getString(2)));
            }

            printEmployee(employees);

        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void employeeFindSalary() {
        String query = "SELECT SUM(EMP_SAL), AVG(EMP_SAL) FROM EMPLOYEE";

        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EmployeeTotalAvgSalary employeeTotalAvgSalary = new EmployeeTotalAvgSalary(rs.getInt(1), rs.getInt(2));
                System.out.print("[총합] " + employeeTotalAvgSalary.getTotal() + "\t");
                System.out.println("[평균] " + employeeTotalAvgSalary.getAverage());
            }

        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void employeeFindSalaryAll() {
        String query = "SELECT EMP_NAME, EMP_SAL FROM EMPLOYEE ORDER BY EMP_SAL DESC, EMP_NAME ASC";

        try (Connection conn = PostgresqlAccess.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {
            List<Employee> employees = new ArrayList<>();

            while (rs.next()) {
                employees.add(new Employee(rs.getString(1), rs.getInt(2)));
                System.out.print("[이름] " + rs.getString(1));
                System.out.println(" [급여] " + rs.getInt(2));
            }
        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void employeeFindAboveAvgSal() {
        String query = "SELECT EMP_NAME, EMP_SAL FROM EMPLOYEE WHERE EMP_SAL > (SELECT AVG(EMP_SAL) FROM EMPLOYEE)";

        try (Connection conn = PostgresqlAccess.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {
            List<Employee> employees = new ArrayList<>();

            while (rs.next()) {
                employees.add(new Employee(rs.getString(1), rs.getInt(2)));
                System.out.print("[이름] " + rs.getString(1));
                System.out.println(" [급여] " + rs.getInt(2));
            }
        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void employeeInsertData() {
        String query = "insert into employee (emp_code, emp_name, emp_mgt, emp_sal) values (?, ?, ?, ?)";

        try (Connection conn = PostgresqlAccess.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "E903");
            pstmt.setString(2, "손진현");
            pstmt.setString(3, "E901");
            pstmt.setInt(4, 4000);

            int retValue = pstmt.executeUpdate();
            System.out.println(retValue + "건의 사항이 처리되었습니다.");
        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

//    public void employeeUpdateData() {
//        String query = "update employee set emp_rcode = 'R003', emp_sal = emp_sal + (emp_sal*0.2) where emp_name = '김수현'";
//
//        try (Connection conn = PostgresqlAccess.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement(query)) {
//            pstmt.setString(1, "R003");
//            pstmt.setInt(2,emp_sal + (emp_sal*0.2));
//            pstmt.setString(3, "김수현");
//        } catch (SQLException sqex) {
//            printSQLException(sqex);
//        }
//    }

    public void employeeDeleteData() {
        String query = "DELETE FROM EMPLOYEE WHERE EMP_NAME = ?";

        try (Connection conn = PostgresqlAccess.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "손진현");
            int retValue = pstmt.executeUpdate();
            System.out.println(retValue + "건의 사항이 처리되었습니다.");
        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void employeeFindSal() {
        String query = "SELECT EMP_RCODE, AVG(EMP_SAL) AVG_VALUE, MIN(EMP_SAL) MIN_VALUE, MAX(EMP_SAL) MAX_VALUE FROM EMPLOYEE WHERE EMP_SAL >= 5000 GROUP BY EMP_RCODE";

        try (Connection conn = PostgresqlAccess.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {

            List<EmployeeSalary> employeeSalaries = new ArrayList<>();

            while (rs.next()) {
                employeeSalaries.add(new EmployeeSalary(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }

            printEmployeeSalary(employeeSalaries);

        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    private void printSQLException(final SQLException e) {
        System.out.format("SQLExcepztion: %s, SQLException: %s", e.getMessage(), e.getSQLState());
    }

    private void printEmployee(final List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.print("[사원] " + employee.getName());
            System.out.println(" [직속] " + employee.getManager());
        }
    }

    private void printEmployeeSalary(final List<EmployeeSalary> employeeSalaries) {
        for (EmployeeSalary employeeSalary : employeeSalaries) {
            System.out.print("[직급코드] " + employeeSalary.getRcode());
            System.out.print(" [평균급여] " + employeeSalary.getAvgSal());
            System.out.print(" [최소급여] " + employeeSalary.getMinSal());
            System.out.println(" [최대급여] " + employeeSalary.getMaxSal());
        }
    }

    private void printEmployeeAll(final List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.print(employee);
        }
    }

}
