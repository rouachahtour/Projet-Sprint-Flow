package com.sprintflow.models;

import java.util.List;

public class Soumission {
    private int id;
    private Freelance freelance;
    private Mission mission;
    private double montantPropose;
    private String messageCoverLetter;
    private String statut;
    private int note;
    private String commentaire;
    private int tempsRestantHeures;

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

    // soumettre — Laith
    public void soumettre() {
        if (tempsRestantHeures > 0) {
            this.statut = "EN_ATTENTE";
            System.out.println("📤 Solution soumise par " + freelance.getNom()
                + " pour : " + mission.getTitre());
            System.out.println("   💰 Montant propose : " + montantPropose + " DT");
            System.out.println("   ⏰ Temps restant   : " + tempsRestantHeures + "h");
        } else {
            System.out.println("❌ Deadline depassee ! Soumission bloquee.");
            this.statut = "EXPIREE";
        }
    }

    // soumettreSiDelaiValide V2 — Laith
    public void soumettreSiDelaiValide() {
        if (tempsRestantHeures <= 0) {
            System.out.println("❌ Deadline depassee ! Soumission impossible.");
            this.statut = "EXPIREE";
        } else if (tempsRestantHeures <= 6) {
            System.out.println("⚠️  Attention ! Il reste seulement "
                + tempsRestantHeures + "h !");
            soumettre();
        } else {
            soumettre();
        }
    }

    // calculerTempsRestant — Laith
    public int calculerTempsRestant() {
        System.out.println("⏱  Temps restant pour soumission #" + id
            + " : " + tempsRestantHeures + "h");
        return tempsRestantHeures;
    }

    // noterSoumission — Laith
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

    //  calculerScoreMoyen V2 — Laith
    public static double calculerScoreMoyen(List<Soumission> soumissions) {
        if (soumissions.isEmpty()) return 0;
        int total = 0;
        int count = 0;
        for (Soumission s : soumissions) {
            if (s.getNote() > 0) {
                total += s.getNote();
                count++;
            }
        }
        double moyenne = count > 0 ? (double) total / count : 0;
        System.out.println("⭐ Score moyen : " + moyenne + "/5");
        return moyenne;
    }



    // afficherResultat — Laith
    public void afficherResultat() {
        System.out.println("📊 Resultat Soumission #" + id + " :");
        System.out.println("   👤 Freelance    : " + freelance.getNom());
        System.out.println("   📋 Mission      : " + mission.getTitre());
        System.out.println("   📌 Statut       : " + statut);
        System.out.println("   ⭐ Note         : "
            + (note > 0 ? note + "/5" : "Non notee"));
        System.out.println("   💬 Commentaire  : "
            + (commentaire.isEmpty() ? "Aucun" : commentaire));
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
