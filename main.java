/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sprintflow.models;
public class main {
    public static void main(String[] args) {

        System.out.println("--- Admin Dashboard ---");

        Admin admin = new Admin("Admin1", "admin@mail.com", "1234");

        
        Utilisateur freelance1 = new Utilisateur("Ali", "ali@mail.com", "123");
        MicroSprint mission1 = new MicroSprint("Test mission");

        admin.afficherStatistiques();
        admin.bloquerCompte(freelance1);
        admin.supprimerMission(mission1);
    }
}
