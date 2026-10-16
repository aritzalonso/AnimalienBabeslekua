// AnimaliaDAO.java
package org.example.dao;

import org.example.Animalia;
import org.example.Katua;
import org.example.Txakurra;
import org.example.Untxia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimaliaDAO {

    public ArrayList<Animalia> lortuGuztiak() {
        ArrayList<Animalia> zerrenda = new ArrayList<>();
        String sql = "SELECT * FROM animaliak";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                zerrenda.add(sortuAnimaliaResultSetetik(rs));
            }
        } catch (SQLException e) {
            System.out.println("Errorea animaliak irakurtzean: " + e.getMessage());
        }
        return zerrenda;
    }

    public Animalia bilatuIzenarekin(String izena) {
        String sql = "SELECT * FROM animaliak WHERE LOWER(izena) = LOWER(?)";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, izena);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return sortuAnimaliaResultSetetik(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Errorea animalia bilatzean: " + e.getMessage());
        }
        return null;
    }

    public boolean txertatu(Animalia animalia) {
        String sql = "INSERT INTO animaliak (izena, espeziea, adina, pisua, adoptatua) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, animalia.getIzena());
            pstmt.setString(2, animalia.getEspeziea());
            pstmt.setInt(3, animalia.getAdina());
            pstmt.setDouble(4, animalia.getPisua());
            pstmt.setBoolean(5, animalia.isAdoptatua());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Errorea animalia gehitzean: " + e.getMessage());
            return false;
        }
    }

    public boolean eguneratuAdopzioa(String izena, boolean adoptatua) {
        String sql = "UPDATE animaliak SET adoptatua = ? WHERE LOWER(izena) = LOWER(?)";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBoolean(1, adoptatua);
            pstmt.setString(2, izena);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Errorea adoptatzean: " + e.getMessage());
            return false;
        }
    }

    public boolean ezabatu(String izena) {
        String sql = "DELETE FROM animaliak WHERE LOWER(izena) = LOWER(?)";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, izena);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Errorea ezabatzean: " + e.getMessage());
            return false;
        }
    }

    private Animalia sortuAnimaliaResultSetetik(ResultSet rs) throws SQLException {
        String izena = rs.getString("izena");
        String espeziea = rs.getString("espeziea");
        int adina = rs.getInt("adina");
        double pisua = rs.getDouble("pisua");
        boolean adoptatua = rs.getBoolean("adoptatua");

        Animalia animalia = switch (espeziea) {
            case "Txakurra" -> new Txakurra(izena, adina, pisua);
            case "Katua" -> new Katua(izena, adina, pisua);
            default -> new Untxia(izena, adina, pisua);
        };
        animalia.setAdoptatua(adoptatua);
        return animalia;
    }
}