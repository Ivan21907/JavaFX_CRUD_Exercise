package com.example.demo.Controller;

import com.example.demo.DAO.AlumneDAO;
import com.example.demo.Interficie.AlumneDAOInterficie;
import com.example.demo.Model.Alumne;
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
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class AlumneController
{
    //objecte que s'utilitzarà per accedir a les funcions que s'han implementat a la classe AlumneDAO
    private static AlumneDAO alumneDAO;

    //diguem que l'objecte alumneDAO és igual a l'objecte AlumneDAOInterficie amb el codi de les funcions implementades
    static {
        try {
            alumneDAO = new AlumneDAOInterficie();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //elements xml que s'utilitzaran per l'interfície
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button enrrere;
    @FXML
    private TextField idAlumne;
    @FXML
    private TextField NomAlumne;
    @FXML
    private TextField CognomsAlumne;
    @FXML
    private DatePicker NaixementAlumne;
    @FXML
    private TextField CursAlumne;
    @FXML
    private TextField ProjenitorAlumne1;
    @FXML
    private TextField ProjenitorAlumne2;

    @FXML
    private Label lavel;

    //elements de la taula per mostrar les dades de les Bases de dades a la interfície
    @FXML
    private TableView<Alumne> table;

    @FXML
    private TableColumn<Alumne, Integer> table_id_alumne;
    @FXML
    private TableColumn<Alumne, String> table_nom_alumne;
    @FXML
    private TableColumn<Alumne, String> table_cognom_alumne;
    @FXML
    private TableColumn<Alumne, DatePicker> table_data_alumne;
    @FXML
    private TableColumn<Alumne, String> table_curs_alumne;
    @FXML
    private TableColumn<Alumne, String[]> table_projenitors_alumne;


    /**
     * Funcio que s'executa quan li cliquem al boto d'afegir alumnes
     */
    public void afegir()
    {
        try {

            //instancia d'objecte alumne
            Alumne alumne = new Alumne();
            //guardem els projenitors en una array
            String[] projenitors = new String[]{ProjenitorAlumne1.getText(), ProjenitorAlumne2.getText()};

            //obtenim els valors dels camps de text i els guardem a l'objecte alumne
            alumne.setNom(NomAlumne.getText());
            alumne.setCognoms(CognomsAlumne.getText());
            alumne.setData_naixement(Date.valueOf(NaixementAlumne.getValue()));
            alumne.setCurs(CursAlumne.getText());
            alumne.setNom_Projenitors(projenitors);

            alumneDAO.afegir(alumne);
            lavel.setText("Alumne afegit correctament");

        } catch (SQLException e)
        {
            lavel.setText("Error al afegir alumne");
            e.printStackTrace();
        }
    }

    /**
     * Funcio que s'executa quan li cliquem al boto d'eliminar alumnes
     */
    public void eliminar()
    {
        try
        {
            Alumne alumne = new Alumne();

            //per eliminar un alumne necessitem el seu id
            alumne.setId(Integer.parseInt(idAlumne.getText()));

            alumneDAO.eliminar(alumne);
            lavel.setText("Alumne eliminat correctament");

        } catch (SQLException e)
        {
            lavel.setText("Error al eliminar alumne");
            e.printStackTrace();
        }
    }

    /**
     * Funcio que s'executa quan li cliquem al boto d'actualitzar alumnes
     */
    public void modificar()
    {
        try
        {

            Alumne alumne = new Alumne();
            String[] projenitors = new String[]{ProjenitorAlumne1.getText(), ProjenitorAlumne2.getText()};

            alumne.setId(Integer.parseInt(idAlumne.getText()));
            alumne.setNom(NomAlumne.getText());
            alumne.setCognoms(CognomsAlumne.getText());
            alumne.setData_naixement(Date.valueOf(NaixementAlumne.getValue()));
            alumne.setCurs(CursAlumne.getText());
            alumne.setNom_Projenitors(projenitors);

            alumneDAO.modificar(alumne);
            lavel.setText("Alumne modificat correctament");

        } catch (SQLException e)
        {
            lavel.setText("Error al modificar alumne");
            e.printStackTrace();
        }
    }

    //llista observable que s'utilitzarà per mostrar les dades de la taula
    ObservableList<Alumne> listM = FXCollections.observableArrayList();

    /**
     * Funcio que s'executa quan li cliquem al boto de mostrar alumnes
     */
    public void llistar()
    {
        try
        {
            //cada vegada que se cliqui al boto de llistar es netejarà la llista
            listM.clear();
            //posem les dades de la BDD al valor de la taula que li correspongui
            table_id_alumne.setCellValueFactory(new PropertyValueFactory<Alumne, Integer>("id"));
            table_nom_alumne.setCellValueFactory(new PropertyValueFactory<Alumne, String>("nom"));
            table_cognom_alumne.setCellValueFactory(new PropertyValueFactory<Alumne, String>("cognoms"));
            table_data_alumne.setCellValueFactory(new PropertyValueFactory<Alumne, DatePicker>("data_naixement"));
            table_curs_alumne.setCellValueFactory(new PropertyValueFactory<Alumne, String>("curs"));
            table_projenitors_alumne.setCellValueFactory(new PropertyValueFactory<Alumne, String[]>("nom_Projenitors"));
            //mostrem la llista
            alumneDAO.llistar(listM);
            //posem la llista a la taula
            table.setItems(listM);

        } catch (SQLException e)
        {
            lavel.setText("Error al llistar alumnes");
            e.printStackTrace();
        }
    }

    /**
     * Funcio que s'executa quan li cliquem al boto de tirar enrrere
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
