package src;

/**
 * Classe abstraite représentant un utilisateur de Sprint-Flow
 * Membre 1 — Authentification
 */
public abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;
    protected String motDePasse;
    protected boolean estConnecte;

    public Utilisateur(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.estConnecte = false;
    }

    /**
     * Connecte l'utilisateur si les credentials sont corrects
     * @return true si connexion réussie, false sinon
     */
    public boolean seConnecter(String email, String motDePasse) {
        if (this.email.equals(email) && this.motDePasse.equals(motDePasse)) {
            this.estConnecte = true;
            System.out.println("✅ Connexion réussie pour : " + this.nom);
            System.out.println("   → Redirection vers le dashboard...");
            return true;
        } else {
            System.out.println("❌ Erreur : Email ou mot de passe incorrect.");
            return false;
        }
    }

    /**
     * Déconnecte l'utilisateur
     */
    public void seDeconnecter() {
        this.estConnecte = false;
        System.out.println("👋 " + this.nom + " s'est déconnecté.");
    }

    /**
     * Méthode abstraite — chaque type d'utilisateur a son propre processus d'inscription
     */
    public abstract boolean sInscrire();

    // Getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public boolean isEstConnecte() { return estConnecte; }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + nom + " (" + email + ")";
    }
}