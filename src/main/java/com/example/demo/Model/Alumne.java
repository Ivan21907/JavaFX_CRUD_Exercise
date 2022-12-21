package com.example.demo.Model;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

//Cursos que pot fer un alumne
enum curs
{
    ESO, Batxillerat, Cicles_Formatius;
}

public class Alumne
{
    //Atributs de la classe
    private int id;
    private String nom;
    private String cognoms;
    private Date data_naixement;
    private String curs;
    private String[] nom_Projenitors;

    //constructors de la classe

    public Alumne(int id, String nom, String cognoms, Date data_naixement, String curs, String[] nom_Projenitors)
    {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.data_naixement = data_naixement;
        this.curs = curs;
        this.nom_Projenitors = nom_Projenitors;
    }
    public Alumne(String nom, String cognoms, Date data_naixement, String curs, String[] nom_Projenitors)
    {
        this.nom = nom;
        this.cognoms = cognoms;
        this.data_naixement = data_naixement;
        this.curs = curs;
        this.nom_Projenitors = nom_Projenitors;
    }

    public Alumne(String nom, String cognoms)
    {
        this.nom = nom;
        this.cognoms = cognoms;

    }

    public Alumne(int id, String nom, String cognoms)
    {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;

    }

    public Alumne(int id)
    {
        this.id = id;

    }

    public Alumne()
    {


    }

    //getters i setters de la classe

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public Date getData_naixement() {
        return data_naixement;
    }

    public void setData_naixement(Date data_naixement) {
        this.data_naixement = data_naixement;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public String[] getNom_Projenitors() {
        return nom_Projenitors;
    }

    public void setNom_Projenitors(String[] nom_Projenitors) {
        this.nom_Projenitors = nom_Projenitors;
    }

}
