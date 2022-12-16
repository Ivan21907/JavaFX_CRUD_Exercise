package com.example.demo.DAO;

import com.example.demo.Model.Alumne;
import com.example.demo.Model.ModulProfessional;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

public interface AlumneDAO
{
    void afegir(Alumne alumne) throws SQLException;
    void eliminar(Alumne alumne) throws SQLException;
    void modificar(Alumne alumne) throws SQLException;
    void llistar(ObservableList<Alumne> list) throws SQLException;

}
