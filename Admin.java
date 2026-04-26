package com.sprintflow.models;

import java.util.List;

public class Admin extends Utilisateur {
    private String niveauAcces;

    public Admin(int id, String nom, String email, String motDePasse, String niveauAcces) {
        super(id, nom, email, motDePasse);
        this.niveauAcces = niveauAcces;
    }

    // ✅ bloquerCompte — Laith
    public void bloquerCompte(Utilisateur u) {
        u.setEstActif(false);
        System.out.println("🚫 Compte bloque par Admin : " + u.getNom()
            + " [" + u.getRole() + "]");
    }

    // ✅ suspendreUtilisateur — Laith
    public void suspendreUtilisateur(Utilisateur u) {
        u.setEstActif(false);
        System.out.println("⏸  Utilisateur suspendu : " + u.getNom());
    }

    // ✅ supprimerMission — Laith
    public void supprimerMission(Mission m) {
        m.setStatut("SUPPRIMEE");
        System.out.println("🗑  Mission supprimee par Admin : " + m.getTitre());
    }

    // ✅ validerMission — Laith
    public void validerMission(Mission m) {
        System.out.println("✅ Admin " + nom + " a valide la mission : " + m.getTitre());
    }

    // ✅ getStatistiques — Laith
    public void getStatistiques(List<Utilisateur> users, List<Mission> missions) {
        long freelances  = users.stream().filter(u -> u.getRole().equals("Freelance")).count();
        long entreprises = users.stream().filter(u -> u.getRole().equals("Entreprise")).count();
        long actives     = missions.stream().filter(m -> m.getStatut().equals("OUVERTE")).count();

        System.out.println("📊 Statistiques Sprint-Flow :");
        System.out.println("   👥 Total utilisateurs  : " + users.size());
        System.out.println("   💼 Freelances          : " + freelances);
        System.out.println("   🏢 Entreprises         : " + entreprises);
        System.out.println("   📋 Missions actives    : " + actives);
        System.out.println("   📁 Total missions      : " + missions.size());
    }

    // ✅ voirAlertes — Laith
    public void voirAlertes(List<Mission> missions) {
        System.out.println("⚠️  Alertes Admin :");
        boolean alerteTrouvee = false;
        for (Mission m : missions) {
            if (m.getSoumissions().isEmpty() && m.getStatut().equals("OUVERTE")) {
                System.out.println("   🔴 Mission sans soumission : " + m.getTitre()
                    + " | Budget : " + m.getBudget() + " DT");
                alerteTrouvee = true;
            }
        }
        if (!alerteTrouvee) {
            System.out.println("   ✅ Aucune alerte detectee");
        }
    }

    public String getNiveauAcces() { return niveauAcces; }

    @Override
    public String getRole() { return "Admin"; }
}
