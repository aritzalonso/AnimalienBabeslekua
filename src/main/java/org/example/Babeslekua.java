// Babeslekua.java
package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Babeslekua {

    public Babeslekua() {

    }
    private ArrayList<Animalia> lortuAnimaliaGuztiakDBtik() {
        ArrayList<Animalia> zerrenda = new ArrayList<>();
        String sql = "SELECT * FROM animaliak";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Animalia a = sortuAnimaliaResultSetetik(rs);
                zerrenda.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Errorea animaliak irakurtzean: " + e.getMessage());
        }
        return zerrenda;
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

    public void gehituAnimalia(Animalia animalia) {
        String sql = "INSERT INTO animaliak (izena, espeziea, adina, pisua, adoptatua) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, animalia.getIzena());
            pstmt.setString(2, animalia.getEspeziea());
            pstmt.setInt(3, animalia.getAdina());
            pstmt.setDouble(4, animalia.getPisua());
            pstmt.setBoolean(5, animalia.isAdoptatua());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errorea animalia gehitzean: " + e.getMessage());
        }
    }

    public Animalia bilatuAnimalia(String izena) {
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

    public boolean adoptatuAnimalia(String izena) {
        Animalia a = bilatuAnimalia(izena);
        if (a != null && !a.isAdoptatua()) {
            String sql = "UPDATE animaliak SET adoptatua = true WHERE LOWER(izena) = LOWER(?)";
            try (Connection conn = Konexioa.lortuKonexioa();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, izena);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("Errorea adoptatzean: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean ezabatuAnimalia(String izena) {
        String sql = "DELETE FROM animaliak WHERE LOWER(izena) = LOWER(?)";

        try (Connection conn = Konexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, izena);
            int ezabatuak = pstmt.executeUpdate();
            return ezabatuak > 0; // Errenkadaren bat ezabatu bada, true itzuliko du
        } catch (SQLException e) {
            System.out.println("Errorea ezabatzean: " + e.getMessage());
            return false;
        }
    }

    public String erakutsiAnimaliak() {
        ArrayList<Animalia> animaliak = lortuAnimaliaGuztiakDBtik();
        if (animaliak.isEmpty()) {
            return "Ez dago animaliarik babeslekuan.";
        }
        StringBuilder sb = new StringBuilder();
        for (Animalia a : animaliak) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    public String eginSoinuak() {
        ArrayList<Animalia> animaliak = lortuAnimaliaGuztiakDBtik();
        if (animaliak.isEmpty()) {
            return "Ez dago animaliarik babeslekuan.";
        }
        StringBuilder sb = new StringBuilder();
        for (Animalia a : animaliak) {
            sb.append(a.eginSoinua()).append("\n");
        }
        return sb.toString();
    }
}