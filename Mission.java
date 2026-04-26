package com.sprintflow.models;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private int id;
    private String titre;
    private String description;
    private double budget;
    private String competenceRequise; // "dev", "design", "marketing"
    private String statut; // OUVERTE, EN_COURS, TERMINEE
    private Entreprise entreprise;
    private List<MicroSprint> microSprints;
    private List<Soumission> soumissions;

    public Mission() {}

    public Mission(int id, String titre, String description, double budget, Entreprise entreprise) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.budget = budget;
        this.statut = "OUVERTE";
        this.entreprise = entreprise;
        this.microSprints = new ArrayList<>();
        this.soumissions = new ArrayList<>();
        this.competenceRequise = "dev";
    }

    public Mission(int id, String titre, String description,
                   double budget, Entreprise entreprise, String competenceRequise) {
        this(id, titre, description, budget, entreprise);
        this.competenceRequise = competenceRequise;
    }

    // ✅ swiperDroite 
    public void swiperDroite(Freelance freelance) {
        System.out.println("✅ " + freelance.getNom()
            + " a swipe DROITE sur : " + this.titre
            + " (" + this.budget + " DT)");
    }

    // ✅ swiperGauche 
    public void swiperGauche(Freelance freelance) {
        System.out.println("❌ " + freelance.getNom()
            + " a swipe GAUCHE sur : " + this.titre);
    }

   

    public void ajouterMicroSprint(MicroSprint ms) { microSprints.add(ms); }
    public void ajouterSoumission(Soumission s) { soumissions.add(s); }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public double getBudget() { return budget; }
    public void setBudget(double b) { this.budget = b; }
    public String getCompetenceRequise() { return competenceRequise; }
    public void setCompetenceRequise(String c) { this.competenceRequise = c; }
    public String getStatut() { return statut; }
    public void setStatut(String s) { this.statut = s; }
    public Entreprise getEntreprise() { return entreprise; }
    public List<MicroSprint> getMicroSprints() { return microSprints; }
    public List<Soumission> getSoumissions() { return soumissions; }

    @Override
    public String toString() {
        return "Mission #" + id + " : " + titre
            + " [" + statut + "] - Budget: " + budget + " DT"
            + " | Competence: " + competenceRequise;
    }
}
