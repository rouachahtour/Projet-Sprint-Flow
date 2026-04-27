package com.sprintflow.models;

import java.util.ArrayList;
import java.util.List;

public class Freelance extends Utilisateur {
    private String competences;
    private double tarifJournalier;
    private List<Soumission> soumissions;
    private List<Mission> missionsSauvegardees; // ✅ Ajout Tasnim

    // constructeur principal uniquement

    public Freelance(int id, String nom, String email, String motDePasse,
                     String competences, double tarifJournalier) {
        super(id, nom, email, motDePasse);
        this.competences = competences;
        this.tarifJournalier = tarifJournalier;
        this.soumissions = new ArrayList<>();
        this.missionsSauvegardees = new ArrayList<>();
    }

    // ✅ swiperDroite — Tasnim
    public void swiperDroite(Mission mission) {
        missionsSauvegardees.add(mission);
        System.out.println("✅ " + getNom()
            + " a swipe DROITE sur : " + mission.getTitre()
            + " -> Mission sauvegardee !");
    }

    // ✅ swiperGauche — Tasnim
    public void swiperGauche(Mission mission) {
        System.out.println("❌ " + getNom()
            + " a swipe GAUCHE sur : " + mission.getTitre()
            + " -> Mission ignoree");
    }

    // ✅ voirMissionsSauvegardees — Tasnim
    public void voirMissionsSauvegardees() {
        System.out.println("📋 Missions sauvegardees de " + getNom() + " :");
        if (missionsSauvegardees.isEmpty()) {
            System.out.println("   Aucune mission sauvegardee");
        } else {
            for (Mission m : missionsSauvegardees) {
                System.out.println("   - " + m.getTitre()
                    + " | " + m.getBudget() + " DT"
                    + " | " + m.getCompetenceRequise());
            }
        }
    }

    public void ajouterSoumission(Soumission s) { soumissions.add(s); }

    public String getCompetences() { return competences; }
    public void setCompetences(String c) { this.competences = c; }
    public double getTarifJournalier() { return tarifJournalier; }
    public void setTarifJournalier(double t) { this.tarifJournalier = t; }
    public List<Soumission> getSoumissions() { return soumissions; }
    public List<Mission> getMissionsSauvegardees() { return missionsSauvegardees; }

    @Override
    public String getRole() { return "Freelance"; }
}
