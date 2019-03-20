package com.sabrine.panne.model;

public class DataModel {
    String id, nom, prenom, numTel, identifiant, motDePasse,specialite,adresse;

    public DataModel(String id, String nom, String prenom, String numTel, String identifiant, String motDePasse, String specialite, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.specialite = specialite;
        this.adresse = adresse;
    }

    public String getId() {
        return id;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
}
