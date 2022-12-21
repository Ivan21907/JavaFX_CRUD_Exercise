package com.example.demo.DAO;

import com.example.demo.Model.ModulProfessional;
import com.example.demo.Model.Professor;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ModulDAO
{
    //Funcions que s'han de implementar a la classe AlumneDAOInterficie

    void afegir(ModulProfessional mp);
    void eliminar(ModulProfessional mp) throws SQLException;
    void modificar(ModulProfessional mp) throws SQLException;
    void llistar(ObservableList<ModulProfessional> list) throws SQLException;
}
