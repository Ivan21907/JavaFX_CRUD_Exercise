package com.example.demo.Controller;

import com.example.demo.DAO.ModulDAO;
import com.example.demo.DAO.ProfessorDAO;
import com.example.demo.Interficie.ModulDAOInterficie;
import com.example.demo.Interficie.ProfessorDAOInterficie;
import com.example.demo.Model.ModulProfessional;
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

public class ModulController
{

    private static ModulDAO modulDAO;

    static {
        try {
            modulDAO = new ModulDAOInterficie();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private TextField idModul;
    @FXML
    private TextField nomModul;
    @FXML
    private TextField idProfessor;

    @FXML
    private TextField nomProfessor;
    @FXML
    private TextField cognomProfessor;

    @FXML
    private Button enrrere;

    @FXML
    private Label lavel;

    @FXML
    private TableView<ModulProfessional> table;

    @FXML
    private TableColumn<ModulProfessional, Integer> table_id_modul;
    @FXML
    private TableColumn<ModulProfessional, String> table_nom_modul;
    @FXML
    private TableColumn<ModulProfessional, String> table_nom_professor;
    @FXML
    private TableColumn<ModulProfessional, String> table_cognom_professor;

    public void afegir()
    {
        ModulProfessional mp = new ModulProfessional();
        mp.setNomModul(nomModul.getText());
        mp.setId_professor(Integer.parseInt(idProfessor.getText()));
        try {
            modulDAO.afegir(mp);
            lavel.setText("Modul afegit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar()
    {
        ModulProfessional mp = new ModulProfessional();
        mp.setIdModul(Integer.parseInt(idModul.getText()));
        try {
            modulDAO.eliminar(mp);
            lavel.setText("Modul eliminat");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificar()
    {
        ModulProfessional mp = new ModulProfessional();
        mp.setIdModul(Integer.parseInt(idModul.getText()));
        mp.setNomModul(nomModul.getText());
        mp.setId_professor(Integer.parseInt(idProfessor.getText()));
        try {
            modulDAO.modificar(mp);
            lavel.setText("Modul modificat");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    ObservableList<ModulProfessional> listM = FXCollections.observableArrayList();


    @FXML
    public void llistar()
    {
        try
        {
            listM.clear();
            table_id_modul.setCellValueFactory(new PropertyValueFactory<ModulProfessional, Integer>("idModul"));
            table_nom_modul.setCellValueFactory(new PropertyValueFactory<ModulProfessional, String>("nomModul"));
            table_nom_professor.setCellValueFactory(new PropertyValueFactory<ModulProfessional, String>("nomProfessor"));
            table_cognom_professor.setCellValueFactory(new PropertyValueFactory<ModulProfessional, String>("cognomProfessor"));
            modulDAO.llistar(listM);
            table.setItems(listM);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @FXML
    public void tornar(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/hello-view.fxml"));
        Stage Window = (Stage) enrrere.getScene().getWindow();
        Window.setScene(new Scene(root));
    }

}
