package io.wisoft.jdbc;

import io.wisoft.jdbc.quiz.PostgresqlAccess;

import java.sql.*;

public class StudentDeleteService {

    public void deleteStudentNo(String studentNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = PostgresqlAccess.getConnection();
            conn.setAutoCommit(false);

            String query = "DELETE FROM STUDENT WHERE NO=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, studentNo);

            int retValue = pstmt.executeUpdate();
            conn.commit();
            System.out.println(retValue + "건의 사항이 처리되었습니다.");
        } catch (SQLException sqex) {
            printSQLException(sqex);
        } finally {
            if (pstmt != null) {try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
        }
    }

    public void deleteStudentNoMultiBatch(Student[] students) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = PostgresqlAccess.getConnection();
            conn.setAutoCommit(false);

            String query = "DELETE FROM STUDENT WHERE NO=?";
            pstmt = conn.prepareStatement(query);

            for (int i=0; i<students.length; i++) {
                pstmt.setString(1, students[i].getNo());
                pstmt.addBatch();
                pstmt.clearParameters();
            }

            int[] retValue = pstmt.executeBatch();
            conn.commit();
            System.out.println(retValue.length + "건의 사항이 처리되었습니다.");

        } catch(SQLException sqex) {
            printSQLException(sqex);
        } finally {
            if (pstmt != null) { try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
        }
    }


    private void printSQLException(final SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
    }

}
