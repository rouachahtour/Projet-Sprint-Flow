package com.sprintflow.models;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SprintFlow — Sprint 1 & 2 ===\n");

        // =========================================================
        // SPRINT 1
        // =========================================================
        System.out.println("========== SPRINT 1 ==========\n");

        // --- Authentification (Membre 1 — Achrif) ---
        System.out.println("--- Authentification (Achrif) ---");
        Entreprise ent = new Entreprise(1, "TechCorp Tunis",
            "contact@techcorp.tn", "pass1234", "IT");
        Freelance fl = new Freelance(2, "Amine Ben Ali",
            "amine@freelance.tn", "pass5678",
            "Java, Spring Boot, React", 250.0);
        Admin admin = new Admin(3, "Sara Admin",
            "sara@sprintflow.tn", "admin789", "SUPER");

        ent.sInscrire();
        fl.sInscrire();
        fl.seConnecter("amine@freelance.tn", "pass5678");
        fl.seConnecter("amine@freelance.tn", "wrongpass");
        fl.seDeconnecter();

        // --- Recherche & Swipe (Membre 2 — Roua) ---
        System.out.println("\n--- Recherche & Swipe (Roua) ---");
        Mission m1 = new Mission(1, "Creer une API REST en Java",
            "Creer 3 endpoints GET/POST/DELETE", 150.0, ent, "dev");
        Mission m2 = new Mission(2, "Design logo startup",
            "Logo moderne pour app mobile", 80.0, ent, "design");
        Mission m3 = new Mission(3, "Rediger landing page",
            "Texte marketing en francais", 60.0, ent, "marketing");
        Mission m4 = new Mission(4, "Corriger bugs React",
            "Fix 3 bugs critiques sur dashboard", 120.0, ent, "dev");

        m1.afficherDetails();
        fl.swiperDroite(m1);
        fl.swiperGauche(m2);
        fl.swiperDroite(m4);

        List<Mission> touteMissions = new ArrayList<>();
        touteMissions.add(m1); touteMissions.add(m2);
        touteMissions.add(m3); touteMissions.add(m4);
        List<Mission> devMissions = Mission.filtrerParCompetence(
            touteMissions, "dev");
        for (Mission m : devMissions) {
            System.out.println("   -> " + m.getTitre()
                + " (" + m.getBudget() + " DT)");
        }
        fl.voirMissionsSauvegardees();

        // --- Publication Mission (Membre 3 — Ella) ---
        System.out.println("\n--- Publication Mission (Ella) ---");
        Mission missionPrincipale = new Mission(5,
            "Developpement App Mobile",
            "Creer une app React Native pour Sprint-Flow",
            3000.0, ent, "dev");

        MicroSprint s1 = new MicroSprint(1, "Setup & Auth",
            "Initialisation + JWT", 3, missionPrincipale);
        MicroSprint s2 = new MicroSprint(2, "CRUD Missions",
            "Endpoints CRUD Mission", 5, missionPrincipale);
        MicroSprint s3 = new MicroSprint(3, "Tests & Deploy",
            "Tests unitaires + CI/CD", 2, missionPrincipale);

        s1.validerMission(); s1.publier();
        s2.validerMission(); s2.publier();
        s3.validerMission(); s3.publier();

        missionPrincipale.ajouterMicroSprint(s1);
        missionPrincipale.ajouterMicroSprint(s2);
        missionPrincipale.ajouterMicroSprint(s3);
        ent.publierMission(missionPrincipale);
        ent.afficherMissionsPubliees();
        s1.afficherDetails();

        // --- Soumission & Evaluation (Membre 4 — Laith) ---
        System.out.println("\n--- Soumission & Evaluation (Laith) ---");
        Soumission soumission = new Soumission(1, fl,
            missionPrincipale, 2800.0,
            "5 ans experience React Native.");

        soumission.soumettre();
        soumission.calculerTempsRestant();
        missionPrincipale.ajouterSoumission(soumission);
        fl.ajouterSoumission(soumission);
        soumission.accepter();
        soumission.noterSoumission(5,
            "Excellent profil, experience solide !");
        soumission.afficherResultat();
        missionPrincipale.setStatut("EN_COURS");
        s1.demarrer();

        // --- Admin Dashboard (Membre 5 — Tasnim) ---
        System.out.println("\n--- Admin Dashboard (Tasnim) ---");
        List<Utilisateur> tousUsers = new ArrayList<>();
        tousUsers.add(ent); tousUsers.add(fl); tousUsers.add(admin);

        List<Mission> toutesMissions = new ArrayList<>();
        toutesMissions.add(m1); toutesMissions.add(m2);
        toutesMissions.add(m3); toutesMissions.add(m4);
        toutesMissions.add(missionPrincipale);

        admin.getStatistiques(tousUsers, toutesMissions);
        admin.voirAlertes(toutesMissions);
        admin.validerMission(missionPrincipale);

        // =========================================================
        // SPRINT 2
        // =========================================================
        System.out.println("\n========== SPRINT 2 ==========\n");

        // --- Scenario 1 : Connexion securisee (Achrif) ---
        System.out.println("📌 Scenario 1 : Connexion securisee (Achrif)");
        fl.validerEmail("amine@freelance.tn");
        fl.validerEmail("amineSANSarobase");
        fl.validerMotDePasse("pass5678");
        fl.validerMotDePasse("abc");
        fl.seConnecterV2("amine@freelance.tn", "pass5678");
        admin.bloquerCompte(fl);
        fl.seConnecterV2("amine@freelance.tn", "pass5678");
        fl.setEstActif(true); // Debloquer pour la suite

        // --- Scenario 2 : Swipe avec doublon (Roua) ---
        System.out.println("\n📌 Scenario 2 : Swipe avec doublon (Roua)");
        fl.swiperDroiteV2(m1); // deja sauvegardee
        fl.swiperDroiteV2(m3); // nouvelle
        fl.afficherHistoriqueSwipes();

        // --- Scenario 3 : Publication + notification (Ella) ---
        System.out.println("\n📌 Scenario 3 : Publication + notification (Ella)");
        ent.modifierMission(m2, "Design logo startup V2", 100.0);
        ent.notifierNouvellesSoumission(missionPrincipale);
        ent.afficherStatsMissions();

        // --- Scenario 4 : Soumission deadline + score (Laith) ---
        System.out.println("\n📌 Scenario 4 : Deadline + score moyen (Laith)");
        Soumission soumission2 = new Soumission(2, fl, m1,
            140.0, "Expert Java, disponible immediatement.");
        soumission2.setTempsRestantHeures(6);
        soumission2.soumettreSiDelaiValide();
        m1.ajouterSoumission(soumission2);
        fl.ajouterSoumission(soumission2);
        soumission2.noterSoumission(4, "Bon travail, code propre");

        Soumission soumission3 = new Soumission(3, fl, m4,
            110.0, "Specialiste React.");
        soumission3.setTempsRestantHeures(0);
        soumission3.soumettreSiDelaiValide();

        List<Soumission> toutesSOumissions = fl.getSoumissions();
        Soumission.calculerScoreMoyen(toutesSOumissions);
        Soumission.afficherHistoriqueEvaluations(
            toutesSOumissions, fl.getNom());

        // --- Scenario 5 : Rapport journalier admin (Tasnim) ---
        System.out.println("\n📌 Scenario 5 : Rapport journalier (Tasnim)");
        List<Soumission> toutesLesSOumissions = new ArrayList<>();
        toutesLesSOumissions.add(soumission);
        toutesLesSOumissions.add(soumission2);

        admin.genererRapportJournalier(tousUsers,
            toutesMissions, toutesLesSOumissions);
        admin.calculerRevenus(toutesMissions);
        admin.voirAlertesAvancees(toutesMissions);

        System.out.println("\n=== Fin Sprint-Flow — Demo Complete ===");
    }
}
