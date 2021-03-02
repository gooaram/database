package io.wisoft.jdbc;

import io.wisoft.jdbc.quiz.PostgresqlAccess;

import java.sql.*;

public class StudentUpdateService {

    public void updateStudentBirthday(String no, String birthday) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = PostgresqlAccess.getConnection();
            conn.setAutoCommit(false);

            String query = "UPDATE STUDENT SET BIRTHDAY = ? WHERE NO = ?";
            pstmt = conn.prepareStatement(query);

            pstmt.setDate(1, Date.valueOf(birthday));
            pstmt.setString(2, no);

            int retValue = pstmt.executeUpdate();
            conn.commit();

            System.out.println(retValue + "건의 사항이 처리되었습니다.");
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        } finally {
            if (pstmt != null) { try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
        }
    }


    public void updateStudentBirthdayMultiBatch(Student[] students) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = PostgresqlAccess.getConnection();
            conn.setAutoCommit(false);

            String query = "UPDATE STUDENT SET BIRTHDAY = ? WHERE NO = ?";
            pstmt = conn.prepareStatement(query);

            for (int i=0; i<students.length; i++) {
                if (students[i].getBirthday() == null) {
                    pstmt.setNull(1, Types.DATE);
                } else {
                    pstmt.setDate(1, Date.valueOf(students[i].getBirthday()));
                }
                pstmt.setString(2, students[i].getNo());
                pstmt.addBatch();
                pstmt.clearParameters();

            }
            int[] retValue = pstmt.executeBatch();
            conn.commit();
            System.out.println(retValue.length + "건의 사항이 처리되었습니다.");

        } catch (SQLException sqex) {
            printSQLException(sqex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void printSQLException(final SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
    }
}
