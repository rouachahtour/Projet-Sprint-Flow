package com.sprintflow.models;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SprintFlow — Sprint 1 ===\n");

        // =========================================================
        // --- Authentification (Membre 1 — Roua) ---
        // =========================================================
        System.out.println("--- Authentification (Roua) ---");

        Entreprise ent = new Entreprise(1, "TechCorp Tunis",
            "contact@techcorp.tn", "pass123", "IT");
        Freelance fl = new Freelance(2, "Amine Ben Ali",
            "amine@freelance.tn", "pass456", "Java, Spring Boot, React", 250.0);
        Admin admin = new Admin(3, "Sara Admin",
            "sara@sprintflow.tn", "admin789", "SUPER");

        ent.sInscrire();
        fl.sInscrire();
        fl.seConnecter("amine@freelance.tn", "pass456");
        fl.seConnecter("amine@freelance.tn", "wrongpass");
        fl.seDeconnecter();

        // =========================================================
        // --- Recherche & Swipe (Membre 2 — Tasnim) ---
        // =========================================================
        System.out.println("\n--- Recherche & Swipe (Tasnim) ---");

        Mission m1 = new Mission(1, "Creer une API REST en Java",
            "Creer 3 endpoints GET/POST/DELETE", 150.0, ent, "dev");
        Mission m2 = new Mission(2, "Design logo startup",
            "Logo moderne pour app mobile", 80.0, ent, "design");
        Mission m3 = new Mission(3, "Rediger landing page",
            "Texte marketing en francais", 60.0, ent, "marketing");
        Mission m4 = new Mission(4, "Corriger bugs React",
            "Fix 3 bugs critiques sur dashboard", 120.0, ent, "dev");

        m1.afficherDetails();
        System.out.println();

        fl.swiperDroite(m1);
        fl.swiperGauche(m2);
        fl.swiperDroite(m4);
        fl.swiperGauche(m3);

        System.out.println();
        List<Mission> touteMissions = new ArrayList<>();
        touteMissions.add(m1); touteMissions.add(m2);
        touteMissions.add(m3); touteMissions.add(m4);

        List<Mission> missionsDevs = Mission.filtrerParCompetence(touteMissions, "dev");
        for (Mission m : missionsDevs) {
            System.out.println("   -> " + m.getTitre() + " (" + m.getBudget() + " DT)");
        }

        System.out.println();
        fl.voirMissionsSauvegardees();

        // =========================================================
        // --- Publication Mission (Membre 3 — Ella) ---
        // =========================================================
        System.out.println("\n--- Publication Mission (Ella) ---");

        Mission missionPrincipale = new Mission(5, "Developpement App Mobile",
            "Creer une app React Native pour Sprint-Flow", 3000.0, ent, "dev");

        MicroSprint s1 = new MicroSprint(1, "Setup & Auth",
            "Initialisation + JWT", 3, missionPrincipale);
        MicroSprint s2 = new MicroSprint(2, "CRUD Missions",
            "Endpoints CRUD Mission", 5, missionPrincipale);
        MicroSprint s3 = new MicroSprint(3, "Tests & Deploy",
            "Tests unitaires + CI/CD", 2, missionPrincipale);

        s1.validerMission();
        s1.publier();
        s2.validerMission();
        s2.publier();
        s3.validerMission();
        s3.publier();

        missionPrincipale.ajouterMicroSprint(s1);
        missionPrincipale.ajouterMicroSprint(s2);
        missionPrincipale.ajouterMicroSprint(s3);

        ent.publierMission(missionPrincipale);
        ent.afficherMissionsPubliees();

        s1.afficherDetails();

        // =========================================================
        // --- Soumission & Evaluation (Membre 4 — Achrif) ---
        // =========================================================
        System.out.println("\n--- Soumission & Evaluation (Achrif) ---");

        Soumission soumission = new Soumission(1, fl, missionPrincipale,
            2800.0, "5 ans experience React Native. Pret a demarrer.");

        soumission.soumettre();
        soumission.calculerTempsRestant();

        missionPrincipale.ajouterSoumission(soumission);
        fl.ajouterSoumission(soumission);

        soumission.accepter();
        soumission.noterSoumission(5, "Excellent profil, experience solide !");
        soumission.afficherResultat();

        missionPrincipale.setStatut("EN_COURS");
        s1.demarrer();

        // =========================================================
        // --- Admin Dashboard (Membre 5 — Laith) ---
        // =========================================================
        System.out.println("\n--- Admin Dashboard (Laith) ---");

        List<Utilisateur> tousUsers = new ArrayList<>();
        tousUsers.add(ent);
        tousUsers.add(fl);
        tousUsers.add(admin);

        List<Mission> toutesMissions = new ArrayList<>();
        toutesMissions.add(m1);
        toutesMissions.add(m2);
        toutesMissions.add(m3);
        toutesMissions.add(m4);
        toutesMissions.add(missionPrincipale);

        admin.getStatistiques(tousUsers, toutesMissions);
        admin.voirAlertes(toutesMissions);
        admin.validerMission(missionPrincipale);
        admin.bloquerCompte(fl);

        System.out.println("\n=== Fin Sprint 1 — SprintFlow ===");
    }
}
