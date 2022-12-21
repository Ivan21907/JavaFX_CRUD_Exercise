package com.example.demo.Model;

import java.sql.*;
import java.util.Scanner;

public class Professor
{
    //Atributs de la classe
    private int id;
    private String nom;
    private String cognoms;

    //constructors de la classe
    public Professor()
    {

    }

    public Professor(String nom, String cognoms)
    {
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public Professor(int id, String nom, String cognoms)
    {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public Professor(int id)
    {
        this.id = id;
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

}
