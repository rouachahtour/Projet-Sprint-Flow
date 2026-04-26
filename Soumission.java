package com.sprintflow.models;

public class Soumission {
    private int id;
    private Freelance freelance;
    private Mission mission;
    private double montantPropose;
    private String messageCoverLetter;
    private String statut; // EN_ATTENTE, ACCEPTEE, REFUSEE
    private int note;           // ✅ Achrif — note 1 a 5
    private String commentaire; // ✅ Achrif — commentaire
    private int tempsRestantHeures; // ✅ Achrif — compte a rebours 48h

    public Soumission(int id, Freelance freelance, Mission mission,
                      double montantPropose, String messageCoverLetter) {
        this.id = id;
        this.freelance = freelance;
        this.mission = mission;
        this.montantPropose = montantPropose;
        this.messageCoverLetter = messageCoverLetter;
        this.statut = "EN_ATTENTE";
        this.note = 0;
        this.commentaire = "";
        this.tempsRestantHeures = 48;
    }

    
    public void soumettre() {
        if (tempsRestantHeures > 0) {
            this.statut = "EN_ATTENTE";
            System.out.println("📤 Solution soumise par " + freelance.getNom()
                + " pour : " + mission.getTitre());
            System.out.println("   💰 Montant propose : " + montantPropose + " DT");
            System.out.println("   ⏰ Temps restant   : " + tempsRestantHeures + "h");
        } else {
            System.out.println("❌ Deadline depassee ! Soumission bloquee.");
        }
    }

   
    public int calculerTempsRestant() {
        System.out.println("⏱  Temps restant pour soumission #" + id
            + " : " + tempsRestantHeures + "h");
        return tempsRestantHeures;
    }

    
    public void noterSoumission(int note, String commentaire) {
        if (note >= 1 && note <= 5) {
            this.note = note;
            this.commentaire = commentaire;
            System.out.println("⭐ Note attribuee a " + freelance.getNom()
                + " : " + note + "/5");
            System.out.println("   💬 Commentaire : " + commentaire);
        } else {
            System.out.println("❌ Note invalide ! Doit etre entre 1 et 5");
        }
    }

    public void afficherResultat() {
        System.out.println("📊 Resultat Soumission #" + id + " :");
        System.out.println("   👤 Freelance : " + freelance.getNom());
        System.out.println("   📋 Mission   : " + mission.getTitre());
        System.out.println("   📌 Statut    : " + statut);
        System.out.println("   ⭐ Note      : " + (note > 0 ? note + "/5" : "Non notee"));
        System.out.println("   💬 Commentaire : " + (commentaire.isEmpty() ? "Aucun" : commentaire));
    }

    public void accepter() {
        this.statut = "ACCEPTEE";
        System.out.println("✅ Soumission #" + id + " ACCEPTEE !");
    }

    public void refuser() {
        this.statut = "REFUSEE";
        System.out.println("❌ Soumission #" + id + " REFUSEE");
    }

    public void setTempsRestantHeures(int h) { this.tempsRestantHeures = h; }
    public int getId() { return id; }
    public Freelance getFreelance() { return freelance; }
    public Mission getMission() { return mission; }
    public double getMontantPropose() { return montantPropose; }
    public String getStatut() { return statut; }
    public int getNote() { return note; }
    public String getCommentaire() { return commentaire; }

    @Override
    public String toString() {
        return "Soumission #" + id + " par " + freelance.getNom()
            + " pour " + mission.getTitre() + " [" + statut + "]";
    }
}
