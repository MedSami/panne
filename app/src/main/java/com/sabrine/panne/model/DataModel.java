package com.sabrine.panne.model;

public class DataModel {
    String id, nom, prenom, numTel, identifiant, motDePasse,specialite,adresse,message;

    public DataModel(String id,String message, String nom, String prenom, String numTel, String identifiant, String motDePasse, String specialite, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.message=message;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.specialite = specialite;
        this.adresse = adresse;
    }

    public String getMessage() {
        return message;
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
