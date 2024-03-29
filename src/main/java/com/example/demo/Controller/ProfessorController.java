package com.example.demo.Controller;

import com.example.demo.DAO.ProfessorDAO;
import com.example.demo.Interficie.ProfessorDAOInterficie;
import com.example.demo.Model.Professor;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ProfessorController
{

    //objecte que s'utilitzarà per accedir a les funcions que s'han implementat a la classe ProfessorDAO
    private static ProfessorDAO professorDAO;

    //diguem que l'objecte ProfessorDAO és igual a l'objecte ProfessorDAOInterficie amb el codi de les funcions implementades
    static {
        try {
            professorDAO = new ProfessorDAOInterficie();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //elements xml que s'utilitzaran per l'interfície
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private TextField cognoms;
    @FXML
    private Button enrrere;
    
    @FXML
    private Label lavel;

    //elements de la taula per mostrar les dades de les Bases de dades a la interfície
    @FXML
    private TableView<Professor> table;

    @FXML
    private TableColumn<Professor, Integer> table_id;
    @FXML
    private TableColumn<Professor, String> table_nom;
    @FXML
    private TableColumn<Professor, String> table_cognoms;

    /**
     * Funcio que s'executa que li cliquem al boto de afegir professors
     * @param ae
     */
    @FXML
    public void afegir(ActionEvent ae){

        Professor prof = new Professor();
        prof.setNom(nom.getText());
        prof.setCognoms(cognoms.getText());


        try {
            professorDAO.afegir(prof);
            lavel.setText("Professor afegit");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Funcio que s'executa que li cliquem al boto de eliminar professors
     * @param ae
     */
    @FXML
    public void eliminar(ActionEvent ae)
    {
        Professor prof = new Professor();
        prof.setId(Integer.parseInt(id.getText()));

        try {
            professorDAO.eliminar(prof);
            lavel.setText("Professor eliminat");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //elements de la taula per mostrar les dades de les Bases de dades a la interfície
    ObservableList<Professor> listM = FXCollections.observableArrayList();

    /**
     * Funcio que s'executa que li cliquem al boto de mostrar professors
     */
    @FXML
    public void llistar()
    {
        try
        {

            listM.clear();
            table_id.setCellValueFactory(new PropertyValueFactory<Professor, Integer>("id"));
            table_nom.setCellValueFactory(new PropertyValueFactory<Professor, String>("nom"));
            table_cognoms.setCellValueFactory(new PropertyValueFactory<Professor, String>("cognoms"));

            professorDAO.llistar(listM);

            table.setItems(listM);


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * Funcio que s'executa que li cliquem al boto de modificar professors
     * @param ae
     */
    @FXML
    public void modificar(ActionEvent ae)
    {
        Professor prof = new Professor();
        prof.setId(Integer.parseInt(id.getText()));
        prof.setNom(nom.getText());
        prof.setCognoms(cognoms.getText());

        try {
            professorDAO.modificar(prof);
            lavel.setText("Professor modificat");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Funcio que s'executa que li cliquem al boto de tornar enrere
     * @param event
     * @throws IOException
     */
    @FXML
    public void tornar(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/hello-view.fxml"));
        Stage Window = (Stage) enrrere.getScene().getWindow();
        Window.setScene(new Scene(root));
    }

}
