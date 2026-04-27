package com.sprintflow.models;

import java.util.ArrayList;
import java.util.List;

public class Freelance extends Utilisateur {
    private String competences;
    private double tarifJournalier;
    private List<Soumission> soumissions;
    private List<Mission> missionsSauvegardees;

    public Freelance(int id, String nom, String email, String motDePasse,
                     String competences, double tarifJournalier) {
        super(id, nom, email, motDePasse);
        this.competences = competences;
        this.tarifJournalier = tarifJournalier;
        this.soumissions = new ArrayList<>();
        this.missionsSauvegardees = new ArrayList<>();
    }

    //  swiperDroite — Roua
    public void swiperDroite(Mission mission) {
        missionsSauvegardees.add(mission);
        System.out.println("✅ " + getNom()
            + " a swipe DROITE sur : " + mission.getTitre()
            + " -> Mission sauvegardee !");
    }

    //  swiperGauche — Roua
    public void swiperGauche(Mission mission) {
        System.out.println("❌ " + getNom()
            + " a swipe GAUCHE sur : " + mission.getTitre()
            + " -> Mission ignoree");
    }

    // dejaSauvegardee V2 — Roua
    public boolean dejaSauvegardee(Mission mission) {
        for (Mission m : missionsSauvegardees) {
            if (m.getId() == mission.getId()) {
                System.out.println("⚠️  Mission deja sauvegardee : "
                    + mission.getTitre());
                return true;
            }
        }
        return false;
    }

    //  swiperDroiteV2 — Roua (avec verif doublon)
    public void swiperDroiteV2(Mission mission) {
        if (!dejaSauvegardee(mission)) {
            missionsSauvegardees.add(mission);
            System.out.println("✅ " + getNom()
                + " a swipe DROITE : " + mission.getTitre());
            System.out.println("   📋 Total sauvegardees : "
                + missionsSauvegardees.size());
        }
    }



    //  voirMissionsSauvegardees — Roua
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
