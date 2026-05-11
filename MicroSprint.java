package com.sprintflow.models;

public class MicroSprint {
    private int id;
    private String titre;
    private String description;
    private int dureeDays;
    private String statut; // A_FAIRE, EN_COURS, TERMINE
    private Mission mission;
    private boolean estValide;

    public MicroSprint(int id, String titre, String description, int dureeDays, Mission mission) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dureeDays = dureeDays;
        this.statut = "A_FAIRE";
        this.mission = mission;
        this.estValide = false;
    }

    // ✅ publier — Ella
    public void publier() {
        this.estValide = true;
        this.statut = "A_FAIRE";
        System.out.println("📢 Micro-Sprint publie : " + titre
            + " (" + dureeDays + " jours)");
    }

    // ✅ validerMission 
    public boolean validerMission() {
        if (titre != null && !titre.isEmpty()
            && description != null && !description.isEmpty()
            && dureeDays > 0) {
            this.estValide = true;
            System.out.println("✅ Micro-Sprint valide : " + titre);
            return true;
        }
        System.out.println("❌ Micro-Sprint invalide : informations manquantes");
        return false;
    }

    // ✅ afficherDetails 
    public void afficherDetails() {
        System.out.println("🔹 Micro-Sprint #" + id + " : " + titre);
        System.out.println("   📝 Description : " + description);
        System.out.println("   ⏱  Durée       : " + dureeDays + " jours");
        System.out.println("   📊 Statut      : " + statut);
        System.out.println("   ✔  Validé      : " + (estValide ? "Oui" : "Non"));
    }

    public void demarrer() {
        this.statut = "EN_COURS";
        System.out.println("▶️  Micro-Sprint demarre : " + titre);
    }

    public void terminer() {
        this.statut = "TERMINE";
        System.out.println("🏁 Micro-Sprint termine : " + titre);
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public String getStatut() { return statut; }
    public int getDureeDays() { return dureeDays; }
    public Mission getMission() { return mission; }
    public boolean isEstValide() { return estValide; }

    @Override
    public String toString() {
        return "Sprint #" + id + " : " + titre
            + " (" + dureeDays + "j) [" + statut + "]";
    }
}
