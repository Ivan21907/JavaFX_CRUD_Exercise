package com.example.demo.Interficie;

import com.example.demo.DAO.ModulDAO;
import com.example.demo.Model.ModulProfessional;
import com.example.demo.Model.Professor;
import javafx.collections.ObservableList;

import java.sql.*;

public class ModulDAOInterficie implements ModulDAO
{

    //obtenim la connexió a la base de dades
    Connection conn = null;

    public ModulDAOInterficie() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");;
    }

    /**
     * Funcio que afegirà un modul a la base de dades
     * @param mp modul que s'afegirà a la base de dades
     */
    @Override
    public void afegir(ModulProfessional mp)
    {
        try
        {
            //preparem la sentencia
            PreparedStatement pm = conn.prepareStatement("INSERT INTO mòdul_professional (nom, id_professor) VALUES (?, ?)");

            //omplim els camps de la sentencia
            pm.setString(1, mp.getNomModul());
            pm.setInt(2, mp.getId_professor());

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

    /**
     * Funcio que esborrarà un modul de la base de dades
     * @param mp modul que s'esborrarà de la base de dades
     * @throws SQLException
     */
    @Override
    public void eliminar(ModulProfessional mp) throws SQLException
    {
        try
        {
            //preparem la sentencia
            PreparedStatement pm = conn.prepareStatement("DELETE FROM mòdul_professional WHERE idmòdul_Professional = ?");

            //omplim els camps de la sentencia
            pm.setInt(1, mp.getIdModul());

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

    /**
     * Funcio que actualitzarà un modul de la base de dades
     * @param mp modul que s'actualitzarà de la base de dades
     * @throws SQLException
     */
    @Override
    public void modificar(ModulProfessional mp) throws SQLException {
        try
        {
            //preparem la sentencia
            PreparedStatement pm = conn.prepareStatement("UPDATE mòdul_professional SET nom = ?, id_professor = ? WHERE idmòdul_Professional = ?");

            //omplim els camps de la sentencia
            pm.setString(1, mp.getNomModul());
            pm.setInt(2, mp.getId_professor());
            pm.setInt(3, mp.getIdModul());

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

    /**
     * Funcio que retornarà tots els mòduls de la base de dades
     * @param list llista on es guardaran els mòduls
     * @throws SQLException
     */
    @Override
    public void llistar(ObservableList<ModulProfessional> list) throws SQLException {

        String sql = "SELECT mp.idmòdul_Professional, mp.nom, p.nom AS nomProfessor, p.cognom AS cognomProfessor FROM mòdul_professional mp INNER JOIN professors p ON mp.id_professor = p.idprofessors";

        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                list.add(new ModulProfessional(rs.getInt("idmòdul_professional"), rs.getString("nom"), rs.getString("nomProfessor"), rs.getString("cognomProfessor")));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
