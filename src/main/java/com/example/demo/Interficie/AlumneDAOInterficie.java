package com.example.demo.Interficie;

import com.example.demo.DAO.AlumneDAO;
import com.example.demo.Model.Alumne;
import com.example.demo.Model.ModulProfessional;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AlumneDAOInterficie implements AlumneDAO
{
    //obtenim la connexió a la base de dades
    Connection conn = null;

    public AlumneDAOInterficie() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Connexio", "postgres", "ivan2001");
    }

    /**
     * Funcio que afegirà un alumne a la base de dades
     * @param alumne alumne que s'afegirà a la base de dades
     * @throws SQLException
     */
    @Override
    public void afegir(Alumne alumne) throws SQLException
    {
        PreparedStatement pm = conn.prepareStatement("INSERT INTO alumnes (nom, cognoms, datanaixement, curs, NomProgenitor) " +
                "VALUES (?, ?, ?, ?::\"curs\", ?)");

        //omplim els camps de la sentencia
        pm.setString(1, alumne.getNom());
        pm.setString(2, alumne.getCognoms());
        pm.setDate(3, alumne.getData_naixement());
        pm.setString(4, alumne.getCurs());
        pm.setArray(5, conn.createArrayOf("text", alumne.getNom_Projenitors()));

        //executem la sentencia
        pm.executeUpdate();

        //tanquem la connexio
        pm.close();


    }

    /**
     * Funcio que esborrarà un alumne de la base de dades
     * @param alumne alumne que s'esborrarà de la base de dades
     * @throws SQLException
     */
    @Override
    public void eliminar(Alumne alumne) throws SQLException
    {
        //preparem la sentencia
        PreparedStatement pm = conn.prepareStatement("DELETE FROM alumnes WHERE id = ?");

        //omplim els camps de la sentencia
        pm.setInt(1, alumne.getId());

        //executem la sentencia
        pm.executeUpdate();

        //tanquem la connexio
        pm.close();

    }

    /**
     * Funcio que modificarà un alumne de la base de dades
     * @param alumne alumne que s'actualitzarà a la base de dades
     * @throws SQLException
     */
    @Override
    public void modificar(Alumne alumne) throws SQLException
    {
        //preparem la sentencia
        PreparedStatement pm = conn.prepareStatement("UPDATE alumnes SET nom = ?, cognoms = ?, datanaixement = ?, curs = ?::\"curs\", NomProgenitor = ? WHERE id = ?");

        //omplim els camps de la sentencia
        pm.setString(1, alumne.getNom());
        pm.setString(2, alumne.getCognoms());
        pm.setDate(3, alumne.getData_naixement());
        pm.setString(4, alumne.getCurs());
        pm.setArray(5, conn.createArrayOf("text", alumne.getNom_Projenitors()));
        pm.setInt(6, alumne.getId());

        //executem la sentencia
        pm.executeUpdate();

        //tanquem la connexio
        pm.close();

    }

    /**
     * Funcio que retornarà tots els alumnes de la base de dades
     * @param list llista on es guardaran els alumnes
     * @throws SQLException
     */
    @Override
    public void llistar(ObservableList<Alumne> list) throws SQLException
    {
        String sql = "SELECT * FROM alumnes";

        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                Alumne alumne = new Alumne();
                alumne.setId(rs.getInt("id"));
                alumne.setNom(rs.getString("nom"));
                alumne.setCognoms(rs.getString("cognoms"));
                alumne.setData_naixement(rs.getDate("datanaixement"));
                alumne.setCurs(rs.getString("curs"));
                alumne.setNom_Projenitors((String[]) rs.getArray("nomProgenitor").getArray());

                list.add(alumne);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
