package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Entreprise — hérite de Utilisateur
 * Membre 1 — Authentification
 */
public class Entreprise extends Utilisateur {
    private String nomEntreprise;
    private String secteur;
    private List<String> missionsPubliees;

    public Entreprise(int id, String nom, String email, String motDePasse,
                      String nomEntreprise, String secteur) {
        super(id, nom, email, motDePasse);
        this.nomEntreprise = nomEntreprise;
        this.secteur = secteur;
        this.missionsPubliees = new ArrayList<>();
    }

    /**
     * Inscription d'une nouvelle entreprise
     * Critères d'acceptation US1 (côté entreprise):
     * 1) Formulaire avec nom, email, mot de passe
     * 2) Email unique vérifié (simulé)
     * 3) Confirmation d'inscription reçue
     */
    @Override
    public boolean sInscrire() {
        if (nom == null || nom.isEmpty()) {
            System.out.println("❌ Inscription échouée : le nom du contact est requis.");
            return false;
        }
        if (nomEntreprise == null || nomEntreprise.isEmpty()) {
            System.out.println("❌ Inscription échouée : le nom de l'entreprise est requis.");
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

        System.out.println("🔍 Vérification de l'unicité de l'email entreprise...");
        System.out.println("✅ Inscription réussie pour l'entreprise : " + nomEntreprise);
        System.out.println("   → Un email de confirmation a été envoyé à : " + email);
        return true;
    }

    /**
     * Connexion entreprise — redirige vers dashboard après succès
     * Critères d'acceptation US2
     */
    @Override
    public boolean seConnecter(String email, String motDePasse) {
        boolean succes = super.seConnecter(email, motDePasse);
        if (succes) {
            System.out.println("   → Dashboard entreprise chargé pour : " + nomEntreprise);
        }
        return succes;
    }

    public void ajouterMissionPubliee(String mission) {
        missionsPubliees.add(mission);
        System.out.println("📋 Mission ajoutée : " + mission);
    }

    // Getters
    public String getNomEntreprise() { return nomEntreprise; }
    public String getSecteur() { return secteur; }
    public List<String> getMissionsPubliees() { return missionsPubliees; }
}