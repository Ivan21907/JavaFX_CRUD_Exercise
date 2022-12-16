package com.example.demo.Interficie;

import com.example.demo.Model.Professor;
import com.example.demo.DAO.ProfessorDAO;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.*;

public class ProfessorDAOInterficie implements ProfessorDAO
{

    Connection conn = null;

    public ProfessorDAOInterficie() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");;
    }
    //@Override
    public void afegir(Professor p)
    {
        try
        {
            //preparem la sentencia
            PreparedStatement pm = conn.prepareStatement("INSERT INTO professors (nom, cognom) VALUES (?, ?)");

            //omplim els camps de la sentencia
            pm.setString(1, p.getNom());
            pm.setString(2, p.getCognoms());

            //executem la sentencia
            pm.executeUpdate();

            //tanquem la connexio
            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void llistar(ObservableList<Professor> list) throws SQLException {

        String sql = "SELECT * FROM professors";

        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                list.add(new Professor(rs.getInt("idprofessors"), rs.getString("nom"), rs.getString("cognom")));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Funcio que elimina un professor de la base de dades
     * @throws SQLException
     */

    public void eliminar(Professor p) throws SQLException
    {
        try
        {
            PreparedStatement pm = conn.prepareStatement("DELETE FROM professors WHERE idprofessors = ?");

            pm.setInt(1, p.getId());

            pm.executeUpdate();

            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Funcio que modifica un professor de la base de dades a partir del seu id
     * @throws SQLException
     */

    public void modificar(Professor p) throws SQLException
    {
        try
        {
            PreparedStatement pm = conn.prepareStatement("UPDATE professors SET nom = ?, cognom = ? WHERE idprofessors = ?");

            pm.setString(1, p.getNom());
            pm.setString(2, p.getCognoms());
            pm.setInt(3, p.getId());


            pm.executeUpdate();

            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
