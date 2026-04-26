package com.sprintflow.models;

import java.util.ArrayList;
import java.util.List;

public class Entreprise extends Utilisateur {
    private String secteur;
    private List<Mission> missions;

    public Entreprise(int id, String nom, String email, String motDePasse, String secteur) {
        super(id, nom, email, motDePasse);
        this.secteur = secteur;
        this.missions = new ArrayList<>();
    }

    // ✅ publierMission — Ella
    public void publierMission(Mission m) {
        missions.add(m);
        System.out.println("📢 Mission publiee par " + nom + " : " + m.getTitre());
    }

    // ✅ fermerMission — Ella
    public void fermerMission(Mission m) {
        m.setStatut("FERMEE");
        System.out.println("🔒 Mission fermee : " + m.getTitre());
    }

    // ✅ afficherMissionsPubliees — Ella
    public void afficherMissionsPubliees() {
        System.out.println("📋 Missions publiees par " + nom + " :");
        if (missions.isEmpty()) {
            System.out.println("   Aucune mission publiee");
        } else {
            for (Mission m : missions) {
                System.out.println("   - " + m.getTitre()
                    + " | " + m.getBudget() + " DT"
                    + " | Statut : " + m.getStatut());
            }
        }
    }

    public String getSecteur() { return secteur; }
    public List<Mission> getMissions() { return missions; }

    @Override
    public String getRole() { return "Entreprise"; }
}
