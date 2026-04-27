package com.sprintflow.models;

import java.util.List;

public class Admin extends Utilisateur {
    private String niveauAcces;

    public Admin(int id, String nom, String email,
                 String motDePasse, String niveauAcces) {
        super(id, nom, email, motDePasse);
        this.niveauAcces = niveauAcces;
    }

    // bloquerCompte — Tasnim
    public void bloquerCompte(Utilisateur u) {
        u.setEstActif(false);
        System.out.println("🚫 Compte bloque : " + u.getNom()
            + " [" + u.getRole() + "]");
    }

    // suspendreUtilisateur — Tasnim
    public void suspendreUtilisateur(Utilisateur u) {
        u.setEstActif(false);
        System.out.println("⏸  Utilisateur suspendu : " + u.getNom());
    }

    // supprimerMission — Tasnim
    public void supprimerMission(Mission m) {
        m.setStatut("SUPPRIMEE");
        System.out.println("🗑  Mission supprimee : " + m.getTitre());
    }

    // validerMission — Tasnim
    public void validerMission(Mission m) {
        System.out.println("✅ Admin " + nom
            + " a valide : " + m.getTitre());
    }

    //  getStatistiques — Tasnim
    public void getStatistiques(List<Utilisateur> users,
                                 List<Mission> missions) {
        long freelances  = users.stream()
            .filter(u -> u.getRole().equals("Freelance")).count();
        long entreprises = users.stream()
            .filter(u -> u.getRole().equals("Entreprise")).count();
        long actives = missions.stream()
            .filter(m -> m.getStatut().equals("OUVERTE")).count();

        System.out.println("📊 Statistiques Sprint-Flow :");
        System.out.println("   👥 Total utilisateurs : " + users.size());
        System.out.println("   💼 Freelances         : " + freelances);
        System.out.println("   🏢 Entreprises        : " + entreprises);
        System.out.println("   📋 Missions actives   : " + actives);
        System.out.println("   📁 Total missions     : " + missions.size());
    }

    //  voirAlertes — Tasnim
    public void voirAlertes(List<Mission> missions) {
        System.out.println("⚠️  Alertes Admin :");
        boolean alerteTrouvee = false;
        for (Mission m : missions) {
            if (m.getSoumissions().isEmpty()
                && m.getStatut().equals("OUVERTE")) {
                System.out.println("   🔴 Mission sans soumission : "
                    + m.getTitre()
                    + " | Budget : " + m.getBudget() + " DT");
                alerteTrouvee = true;
            }
        }
        if (!alerteTrouvee) {
            System.out.println("   ✅ Aucune alerte detectee");
        }
    }

    // voirAlertesAvancees V2 — Tasnim
    public void voirAlertesAvancees(List<Mission> missions) {
        System.out.println("⚠️  Alertes Avancees :");
        for (Mission m : missions) {
            if (m.getSoumissions().isEmpty()
                && m.getStatut().equals("OUVERTE")) {
                System.out.println("   🔴 URGENT : " + m.getTitre()
                    + " — aucune soumission depuis 24h !");
            }
            if (m.getStatut().equals("SUPPRIMEE")) {
                System.out.println("   🗑  Mission supprimee : "
                    + m.getTitre());
            }
        }
    }
    // genererRapportJournalier V2 — Tasnim
    public void genererRapportJournalier(List<Utilisateur> users,
            List<Mission> missions, List<Soumission> soumissions) {
        double revenus = missions.stream()
            .filter(m -> m.getStatut().equals("EN_COURS")
                   || m.getStatut().equals("TERMINEE"))
            .mapToDouble(Mission::getBudget).sum();

        System.out.println("📄 Rapport Journalier Sprint-Flow :");
        System.out.println("   📅 Date              : 2026-04-23");
        System.out.println("   👥 Utilisateurs      : " + users.size());
        System.out.println("   📋 Missions actives  : "
            + missions.stream()
                .filter(m -> m.getStatut().equals("OUVERTE"))
                .count());
        System.out.println("   📤 Soumissions       : "
            + soumissions.size());
        System.out.println("   💰 Revenus du jour   : " + revenus + " DT");
    }

  

    

    public String getNiveauAcces() { return niveauAcces; }

    @Override
    public String getRole() { return "Admin"; }
}
