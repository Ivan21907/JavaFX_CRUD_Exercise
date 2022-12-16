package com.example.demo.Model;

import java.sql.*;
import java.util.Scanner;

public class ModulProfessional
{
    //Atributs de la classe
    private int idModul;
    private String nomModul;

    private String nomProfessor;

    private String cognomProfessor;

    private int id_professor;

    //constructors de la classe

    public ModulProfessional(String nomModul, int id_professor)
    {
        this.nomModul = nomModul;
        this.id_professor = id_professor;
    }

    public ModulProfessional()
    {

    }

    public ModulProfessional(int idModul)
    {
        this.idModul = idModul;
    }

    public ModulProfessional(String nomModul)
    {
        this.nomModul = nomModul;
    }




    public ModulProfessional(int idmòdul_professional, String nom, String nomProfessor, String cognomProfessor)
    {
        this.idModul = idmòdul_professional;
        this.nomModul = nom;
        this.nomProfessor = nomProfessor;
        this.cognomProfessor = cognomProfessor;

    }


    public int getIdModul() {
        return idModul;
    }

    public void setIdModul(int idModul) {
        this.idModul = idModul;
    }

    public String getNomModul() {
        return nomModul;
    }

    public void setNomModul(String nomModul) {
        this.nomModul = nomModul;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public String getNomProfessor() {
        return nomProfessor;
    }

    public void setNomProfessor(String nomProfessor) {
        this.nomProfessor = nomProfessor;
    }

    public String getCognomProfessor() {
        return cognomProfessor;
    }

    public void setCognomProfessor(String cognomProfessor) {
        this.cognomProfessor = cognomProfessor;
    }


}

