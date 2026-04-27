package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Freelance — hérite de Utilisateur
 * Membre 1 — Authentification
 */
public class Freelance extends Utilisateur {
    private String competences;
    private List<String> missionsSauvegardees;
    private double note;

    public Freelance(int id, String nom, String email, String motDePasse, String competences) {
        super(id, nom, email, motDePasse);
        this.competences = competences;
        this.missionsSauvegardees = new ArrayList<>();
        this.note = 0.0;
    }

    /**
     * Inscription d'un nouveau freelance
     * Critères d'acceptation US1:
     * 1) Formulaire avec nom, email, mot de passe
     * 2) Email unique vérifié (simulé)
     * 3) Confirmation d'inscription reçue
     */
    @Override
    public boolean sInscrire() {
        // Validation des champs obligatoires
        if (nom == null || nom.isEmpty()) {
            System.out.println("❌ Inscription échouée : le nom est requis.");
            return false;
        }
        if (email == null || !email.contains("@")) {
            System.out.println("❌ Inscription échouée : email invalide.");
            return false;
        }
        if (motDePasse == null || motDePasse.length() < 6) {
            System.out.println("❌ Inscription échouée : mot de passe trop court (min 6 caractères).");
            return false;
        }

        // Simulation vérification email unique
        System.out.println("🔍 Vérification de l'unicité de l'email...");
        boolean emailUnique = verifierEmailUnique(email);
        if (!emailUnique) {
            System.out.println("❌ Inscription échouée : cet email est déjà utilisé.");
            return false;
        }

        // Inscription réussie
        System.out.println("✅ Inscription réussie pour le freelance : " + nom);
        System.out.println("   → Un email de confirmation a été envoyé à : " + email);
        return true;
    }

    /**
     * Simule la vérification d'unicité de l'email en base de données
     */
    private boolean verifierEmailUnique(String email) {
        // En vrai projet : requête DB. Ici on simule toujours unique.
        return true;
    }

    public void ajouterMissionSauvegardee(String mission) {
        missionsSauvegardees.add(mission);
    }

    // Getters & Setters
    public String getCompetences() { return competences; }
    public List<String> getMissionsSauvegardees() { return missionsSauvegardees; }
    public double getNote() { return note; }
    public void setNote(double note) { this.note = note; }
}