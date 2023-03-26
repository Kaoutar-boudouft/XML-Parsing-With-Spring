package com.example.xmlproject.Model;

import java.util.ArrayList;

public class OFPPT {
    private ArrayList<Departement> departements;

    public OFPPT(){}

    public OFPPT(ArrayList<Departement> departements){
        this.departements = departements;
    }

    public void setDepartements(ArrayList<Departement> departements){
        this.departements = departements;
    }

    public ArrayList<Departement> getDepartements(){
        return this.departements;
    }
}
