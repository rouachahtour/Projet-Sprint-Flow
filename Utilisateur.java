package com.sprintflow.models;

public abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;
    protected String motDePasse;
    protected boolean estActif;

    public Utilisateur(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.estActif = true;
    }

    //  sInscrire — Achrif
    public void sInscrire() {
        System.out.println("✅ Inscription reussie : " + nom + " (" + email + ")");
        System.out.println("   Role : " + getRole());
    }

    //  validerEmail V2 — Achrif
    public boolean validerEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            System.out.println("✅ Email valide : " + email);
            return true;
        }
        System.out.println("❌ Email invalide : " + email);
        return false;
    }

   

    //  seDeconnecter — Achrif
    public void seDeconnecter() {
        System.out.println("👋 " + nom + " s'est deconnecte");
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public boolean isEstActif() { return estActif; }
    public void setEstActif(boolean actif) { this.estActif = actif; }

    public abstract String getRole();

    @Override
    public String toString() {
        return "[" + getRole() + "] " + nom + " (" + email + ")";
    }
}
