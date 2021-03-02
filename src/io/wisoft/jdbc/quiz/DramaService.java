package io.wisoft.jdbc.quiz;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DramaService {

    public void dramaFindCodeAndName() {
        String query = "SELECT DRM_CODE, DRM_NAME FROM DRAMA WHERE DRM_PRD='HNU-E'";

        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<Drama> dramaList = new ArrayList<>();

            while (rs.next()) {
                dramaList.add(new Drama(rs.getString(1), rs.getString(2)));
            }
            printDrama(dramaList);

        } catch(SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void dramaProductFindKBCAndSBC() {
        String query = "SELECT * FROM DRAMA WHERE DRM_BRD in ('SBC', 'KBC')";

        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<Drama> dramaList = new ArrayList<>();

            while (rs.next()) {
                dramaList.add(new Drama(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

            printDramaAll(dramaList);
        } catch (SQLException sqex) {
            printSQLException(sqex);
        }

    }

    public void dramaFindName() {
        String query = "SELECT DRM_NAME FROM DRAMA WHERE DRM_OPDATE IS NULL";
        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            List<Drama> dramaList = new ArrayList<>();

            while (rs.next()) {
                dramaList.add(new Drama(rs.getString(1)));
                System.out.println(rs.getString(1));
            }

        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void dramaFindProduct() {
        String query = "select distinct drm_prd from drama";

        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<Drama> dramaList = new ArrayList<>();

            while (rs.next()){
                dramaList.add(new Drama(rs.getString(1)));
                System.out.println("[제작사] " + rs.getString(1));
            }

        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void dramaUpdateOpdate() {
        String query = "UPDATE DRAMA SET DRM_OPDATE = ? WHERE DRM_OPDATE IS NULL";

        try (Connection conn = PostgresqlAccess.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, Date.valueOf("2013-05-01"));
            int retValue = pstmt.executeUpdate();
            System.out.println(retValue + "건의 사항이 처리되었습니다.");
        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    private void printSQLException(final SQLException e) {
        System.out.format("SQLException: %s, SQLException: %s", e.getMessage(), e.getSQLState());
    }

    private void printDramaAll(final List<Drama> dramaList) {
        for (Drama drama : dramaList) {
            System.out.println(drama);
        }
    }

    private void printDrama(final List<Drama> dramaList) {
        for (Drama drama : dramaList) {
            System.out.print("[코드] " + drama.getCode() + "\t" );
            System.out.println(" [이름] " + drama.getName());
        }
    }

}
