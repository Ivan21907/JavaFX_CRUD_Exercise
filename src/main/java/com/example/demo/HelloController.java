package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController
{
    //elements xml que s'utilitzaran per l'interfície
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button sortir;

    /**
     * Mètode que s'executa quan es prem el botó de carregar la següent pantalla (Gestionar professors)
     * @param ae parametre que s'envia quan es prem el botó
     * @throws IOException
     */
    @FXML
    public void escenaProfessor(ActionEvent ae) throws IOException {
        //carreguem la següent pantalla
        root = FXMLLoader.load(getClass().getResource("professor_view.fxml"));
        //obtenim el stage
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        //creem la nova escena
        scene = new Scene(root);
        //la posem al stage
        stage.setScene(scene);
        //la mostrem
        stage.show();
    }

    /**
     * Mètode que s'executa quan es prem el botó de carregar la següent pantalla (Gestionar moduls)
     * @param ae parametre que s'envia quan es prem el botó
     * @throws IOException
     */
    @FXML
    public void escenaModul(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("modul_view.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Mètode que s'executa quan es prem el botó de carregar la següent pantalla (Gestionar alumnes)
     * @param ae parametre que s'envia quan es prem el botó
     * @throws IOException
     */
    @FXML
    public void escenaAlumne(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("alumne_view.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Mètode que s'executa quan es prem el botó de sortir de l'aplicació
     */
    public void sortir()
    {
        sortir.setOnAction(event -> Platform.exit());
    }


}