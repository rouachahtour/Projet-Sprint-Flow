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

    // validerMotDePasse V2 — Achrif
    public boolean validerMotDePasse(String mdp) {
        if (mdp != null && mdp.length() >= 8) {
            System.out.println("✅ Mot de passe valide");
            return true;
        }
        System.out.println("❌ Mot de passe trop court (minimum 8 caracteres)");
        return false;
    }


    //  seConnecterV2 — Achrif (avec verif estActif)
    public boolean seConnecterV2(String email, String mdp) {
        if (!estActif) {
            System.out.println("🚫 Compte bloque ! Contactez l'admin.");
            return false;
        }
        if (this.email.equals(email) && this.motDePasse.equals(mdp)) {
            System.out.println("🔓 Connexion reussie : " + nom + " [" + getRole() + "]");
            return true;
        }
        System.out.println("❌ Email ou mot de passe incorrect");
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
