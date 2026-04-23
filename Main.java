import src.Freelance;
import src.Entreprise;

/**
 * Main.java — Scénario de démonstration Sprint 1
 * Membre 1 : Authentification (US1 & US2)
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("      SPRINT-FLOW — Sprint 1 Demo       ");
        System.out.println("  Membre 1 : Inscription & Connexion    ");
        System.out.println("========================================\n");

        // ── US1 : Inscription Freelance ───────────────────────────────
        System.out.println("--- US1 : Inscription d'un Freelance ---");
        Freelance freelance = new Freelance(1, "Aymen Ben Ali",
                "aymen@gmail.com", "pass123", "Java, React");
        freelance.sInscrire();

        System.out.println();

        // ── US1 : Inscription Entreprise ──────────────────────────────
        System.out.println("--- US1 : Inscription d'une Entreprise ---");
        Entreprise entreprise = new Entreprise(2, "Sana Mrad",
                "sana@techcorp.tn", "secure456", "TechCorp", "IT");
        entreprise.sInscrire();

        System.out.println();

        // ── US2 : Connexion réussie ───────────────────────────────────
        System.out.println("--- US2 : Connexion Entreprise (succès) ---");
        entreprise.seConnecter("sana@techcorp.tn", "secure456");

        System.out.println();

        // ── US2 : Connexion échouée ───────────────────────────────────
        System.out.println("--- US2 : Connexion Entreprise (mauvais mot de passe) ---");
        entreprise.seConnecter("sana@techcorp.tn", "wrongpass");

        System.out.println();

        // ── Connexion Freelance ───────────────────────────────────────
        System.out.println("--- Connexion Freelance ---");
        freelance.seConnecter("aymen@gmail.com", "pass123");

        System.out.println();

        // ── Déconnexion ───────────────────────────────────────────────
        System.out.println("--- Déconnexion ---");
        freelance.seDeconnecter();
        entreprise.seDeconnecter();

        System.out.println("\n========================================");
        System.out.println("     ✅ Scénario terminé avec succès    ");
        System.out.println("========================================");
    }
}