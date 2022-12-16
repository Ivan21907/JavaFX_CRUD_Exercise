package com.example.demo.DAO;

import com.example.demo.Model.Professor;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public interface ProfessorDAO
{
    void afegir(Professor p);
    void eliminar(Professor p) throws SQLException;
    void modificar(Professor p) throws SQLException;
    void llistar(ObservableList<Professor> list) throws SQLException;

}
