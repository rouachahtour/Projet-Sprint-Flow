# SprintFlow

SprintFlow est une plateforme de mise en relation entre **freelances** et **entreprises**, organisée autour de micro-sprints agiles.

## Structure du Projet

```
SprintFlow/
├── docs/captures/        # Captures d'écran (maquettes, kanban, reviews)
├── diagrammes/           # Diagrammes UML (DCU, DC, DS)
└── src/com/sprintflow/models/  # Code source Java
```

## Modèles Principaux

| Classe | Rôle |
|---|---|
| `Utilisateur` | Classe abstraite de base |
| `Freelance` | Acteur proposant ses services |
| `Entreprise` | Acteur publiant des missions |
| `Mission` | Offre de travail structurée |
| `MicroSprint` | Unité d'exécution d'une mission |
| `Soumission` | Candidature d'un freelance à une mission |
| `Admin` | Gestionnaire de la plateforme |

## Lancer le Projet

```bash
javac src/com/sprintflow/models/*.java
java -cp src com.sprintflow.models.Main
```
