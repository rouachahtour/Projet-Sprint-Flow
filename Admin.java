/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sprintflow.models;

public class Admin extends Utilisateur {

    public Admin(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
    }

    public void afficherStatistiques() {
        System.out.println("Stats: utilisateurs = 10, missions = 5");
    }

    public void bloquerCompte(Utilisateur user) {
        System.out.println("Compte bloqué: " + user.getNom());
    }

    public void supprimerMission(MicroSprint mission) {
        System.out.println("Mission supprimée: " + mission.getTitre());
    }
}