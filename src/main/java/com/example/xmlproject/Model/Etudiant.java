package com.example.xmlproject.Model;

import java.time.LocalDate;

public class Etudiant {

    private String idStu,nom,prenom,resVille,etudiantEmail,etudiantTelephone,AnneBacalaureat,lieuN;
    private LocalDate dob;

    public Etudiant() {}

    public Etudiant(String idStu, String nom, String prenom, String resVille, String etudiantEmail,
                    String etudiantTelephone, String anneBacalaureat,String lieuN , LocalDate dob) {
        this.idStu = idStu;
        this.nom = nom;
        this.prenom = prenom;
        this.resVille = resVille;
        this.etudiantEmail = etudiantEmail;
        this.etudiantTelephone = etudiantTelephone;
        AnneBacalaureat = anneBacalaureat;
        this.lieuN = lieuN;
        this.dob = dob;
    }

    public String getIdStu() {
        return idStu;
    }

    public void setIdStu(String idStu) {
        this.idStu = idStu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getResVille() {
        return resVille;
    }

    public void setResVille(String resVille) {
        this.resVille = resVille;
    }

    public String getEtudiantEmail() {
        return etudiantEmail;
    }

    public void setEtudiantEmail(String etudiantEmail) {
        this.etudiantEmail = etudiantEmail;
    }

    public String getEtudiantTelephone() {
        return etudiantTelephone;
    }

    public void setEtudiantTelephone(String etudiantTelephone) {
        this.etudiantTelephone = etudiantTelephone;
    }

    public String getAnneBacalaureat() {
        return AnneBacalaureat;
    }

    public void setAnneBacalaureat(String anneBacalaureat) {
        AnneBacalaureat = anneBacalaureat;
    }

    public String getLieuN() {
        return lieuN;
    }

    public void setLieuN(String lieuN) {
        this.lieuN = lieuN;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
