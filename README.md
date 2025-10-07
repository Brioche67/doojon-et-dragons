# DOOnjon&Dragon

<img width="939" height="895" alt="image" src="https://github.com/user-attachments/assets/e5bb5815-4e36-4a68-8f5e-a7ff0b527cc2" />
<img width="702" height="1104" alt="image" src="https://github.com/user-attachments/assets/766d861a-8add-4637-99bc-c98b654b893a" />

<img width="576" height="576" alt="image" src="https://github.com/user-attachments/assets/e8561292-f3f5-4413-bae3-594f724f1152" />


On souhaite développer une application pour **un nouveau un jeu D&D**.
C'est un jeu de rôle de Medieval Fantasy où les joueurs incarnent des personnages affrontant des monstres dans plusieurs donjons successifs.

## Organisation

- Travail en **binôme** au sein d'un même groupe de TP
- Le travail doit être réalisé sur un fork du projet dans le groupe <nom_etudiant_1>-<nom_etudiant_2> que vous aurez créé
- Durée : 5 semaines
- Nombre de séances :
   - 8h encadrées en groupe de TD
   - 12h encadrées, en groupe TP
   - 10h tutorées, en promo complète
   - travail non-encadré (SAé libre)
- Sujet dévoilé en deux phases :
  - Phase 1 dévoilée **Lundi 5 mai** sur les deux premières semaines
  - Phase 2 dévoilée le **Lundi 19 mai**

## Calendrier

- Lundi **5 mai** : début du projet
- Dimanche **18 mai** : rendu intermédiaire
- Lundi 19 mai : début de la phase 2
- Dimanche **8 Juin** à minuit : rendu final
- De Mercredi **11** à Vendredi **13 juin** : soutenances

De plus, il y aura un rendu hebdomadaire avant chaque **dimanche, minuit**.



## Le jeu

Il s'agit d'un jeu avec plusieurs joueurs face à des monstres contrôlés par le maître du jeu, qui se joue **au tour par tour**. Les joueurs incarnant les personnages doivent éliminer les monstres de trois donjons successifs. Un autre joueur est Maître du Jeu et a pour rôle de narrer l'histoire et expliquer le contexte aux joueurs. Si un seul joueur est éliminé par un monstre dans un des donjons, l'équipe a perdu.

 Le jeu se base sur des jets de dés désignés par <nombre de dés>d<nombre de faces des dés>.
 Par exemple, 3d4 désigne le jet de 3 dés à 4 faces.


### Les personnages

Chaque joueur à l'exception du Maître du Jeu incarne un personnage.
Chaque personnage est défini par:
- un nom
- une race parmi:
  - Humain
  - Nain
  - Elfe
  - Halfelin
- une classe parmi:
  - Guerrier
  - Clerc
  - Magicien
  - Roublard
- ses caractéristiques:
  - ses points de vie
  - sa force
  - sa dextérité
  - sa vitesse
  - son initiative
- son inventaire d'équipements en armes et armures (n'est pas limité en nombre d'équipements)
- les équipements qu'il porte (limité à une arme et une armure)

#### Les caractéristiques
- la caractéristique de points de vie indique le nombre de dégâts que peut subir un joueur avant de mourir
- la caractéristique force offre un bonus lors de l'utilisation d'une arme de corps à corps (voir Déroulement d'un donjon >  Tour d'un personnage ou d'un monstre > Attaquer)
- la caractéristique dextérité offre un bonus lors de l'utilisation de armes à distance (voir Déroulement d'un donjon >  Tour d'un personnage ou d'un monstre > Attaquer)
- la caractéristique vitesse indique la distance que peut parcourir un personnage lors d'une action (voir Déroulement d'un donjon >  Tour d'un personnage ou d'un monstre > Se déplacer)
- la caractéristique initiative offre un bonus pour déterminer l'ordre dans lequel jouera un personnage lors d'un combat dans un donjon (voir Déroulement d'un donjon >  Mise en Place)

#### Les équipements
- les armures légères
  - armure d'écailles, classe d'armure: 9
  - demi-plate,        classe d'armure: 10
- les armures lourdes
  - cotte de mailles,  classe d'armure: 11
  - harnois: classe d'armure: 12
- les armes courantes au corps-à-corps
  - bâton, dégât: 1d6, portée: 1 case
  - masse d'armes, dégât: 1d6, portée: 1 case
- les armes de guerre au corps-à-corps
  - épée longue, dégât: 1d8, portée: 1 case
  - rapière, dégât: 1d8, portée: 1 case
- les armes à distance
  - arbalète légère, dégât: 1d8, portée 16 cases
  - fronde, dégât 1d4, portée 6 cases
  - arc court, dégât 1d6, portée 16 cases

Les armes de guerre lorsqu'elles sont équipées par un personnage diminuent de 2 points leur vitesse et augmente de 4 leur force.
Les armures lourdes lorsqu'elles sont équipées par un personnage diminuent de 4 point leur vitesse.

#### Les races
- les Elfes possèdent une dextérité de base augmentée de 6 points
- les Halfelins possèdent une dextérité de base augmentée de 4 points et une vitesse de base augmentée de 2 points
- les Humains ont toutes leurs caractéristiques de base augmentée de 2 points
- les Nains ont leur force de base augmentée de 6 points



#### Les classes
- les Clercs possèdent à leur création:
  - 16 points de vie
  - un équipement de base contenant une masse d'armes, une armure d'écailles et une arbalète légère
- les Guerriers possèdent à leur création:
  - 20 points de vie,
  - un équipement contenant une cotte de mailles, une épée longue, une arbalète légère
- les Magiciens possèdent à leur création:
  - 12 points de vie
  - un équipement contenant un bâton et une fronde
- les Roublards possèdent à leur création:
  - 16 points de vie
  - un équipement contenant une rapière et un arc court

#### Création d'un personnage
Au début d'une partie, chaque joueur crée son personnage de la façon suivante:
- le joueur choisit un nom pour son personnage
- le joueur choisit une race pour son personnage
- le joueur choisit une classe pour son personnage
- la caractéristique point de vie est déterminée par la classe de son personnage
- chacune des autres caractéristique du personnage est déterminée par la somme de:
  - 4d4
  - 3 points
  - l'augmentation déterminée par la race du personnage

### Les monstres

*« Wait a minute!\
Did you hear that ? That... that sound?\
Boom !\
That didn't come from the troglodytes. No, that came from something else...\
The Demogorgon ! »\
Stranger Things, Saison 1, épisode 1*


Les monstres sont contrôlés par le maître du jeu.
Un monstre est défini par:
- son espèce (par exemple dragon)
- son numéro si plusieurs monstres de la même espèce sont présents
- son attaque (qui est unique)
    - la portée de l'attaque (valant 1 si l'attaque est au corps-à-corps)
    - les dégâts de l'attaque (choix du jet de dés)
- ses caractéristiques
  - ses points de vie
  - sa vitesse
  - sa force (0 s'il attaque à distance)
  - sa dextérité (0 s'il attaque au corps à corps)
  - sa classe d'armure
  - son initiative



En revanche un monstre ne possède pas d'équipement.



### Déroulement d'un donjon
#### Mise en Place
*«Vous entrez dans une pièce sombre et vous retrouvez face à face à ...»*

Au début de chaque donjon, le maître du jeu
- crée la carte d'un donjon: un rectangle dont les dimensions sont comprises entre 15 et 25 cases
- positionne des obstacles sur la carte: cases où les joueurs et les monstres ne pourront pas se déplacer
- crée les monstres et choisit leurs caractéristiques
- positionne les joueurs et les monstres sur la carte (en-dehors des obstacles)
- positionne des équipements sur la carte que les joueurs pourront récupérer
- présente en quelques phrases le contexte aux joueurs

Afin de faciliter la tâche au maître du jeu, un choix de mise en place du donjon par défaut devra être proposé pour chaque donjon.

Chaque joueur et chaque monstre lance 1d20 et ajoute leur caractéristique d'initiative. Ils joueront par ordre décroissant du résultat d'initiative.

Avant de débuter le donjon, chaque joueur peut équiper l'armure et l'arme de son choix.


#### Tour d'un personnage ou d'un monstre
Les tours sont joués dans l'ordre déterminé par l'initiative lors de la mise en place du donjon. Après le dernier joueur ou monstre, c'est le premier joueur ou monstre qui continue.

Lors de son tour, le joueur ou le monstre (contrôlé par le maître du jeu) peut réaliser jusqu'à 3 actions parmi. Une action consiste soit à s'équiper, soit à se déplacer, soit attaquer, soit ramasser un équipement.

A la fin de chaque action le joueur ou le maître du jeu peut commenter l'action pour améliorer le *Role Play*.

##### S'équiper *(uniquement pour les personnages)*
Un joueur peut équiper une arme ou une armure de son inventaire.
(L'arme ou l'armure précédemment équipée retourne dans l'inventaire)
Ne pas oublier de prendre alors en compte l'éventuel modificateur de vitesse dû à l'arme de guerre ou l'armure lourde lors des futurs déplacements du personnage.

##### Se Déplacer
Un joueur ou un monstre peut de déplacer d'une distance égale à sa caractéristique de vitesse divisée par 3 sur une case sans monstre, joueur ou obstacle.
L'évitement d'obstacles n'est pas pris en compte pour le calcul de la distance de déplacement.

##### Attaquer
L'attaquant attaque avec l'arme  qu'il porte.
- L'attaquant choisit la cible de son attaque(monstre dans le cas d'un attaquant personnage et personnage dans le cas d'un attaquant monstre). La cible de l'attaque  doit être à portée du joueur donnée par l'arme (les armes au corps-à-corps ont une portée d'une seule case). Les obstacles ne bloquent pas les attaques des armes à distance.
- L'attaquant commence par faire un jet d'attaque (1d20). Il ajoute ensuite au résultat du dé sa caractéristique de Dextérité s'il s'agit d'une attaque avec arme à distance et sa caractéristique de Force s'il s'agit d'une attaque avec arme au corps-à-corps.
- Si la somme est supérieur à la classe d'armure de la cible, l'attaquant lance le dé de dégât de l'arme et la cible perd en point de vies le résultat du jet de dé. Dans le cas contraire, l'attaquant finit son action sans infliger de dégâts à la cible.

#### Ramasser un équipement *(uniquement pour les personnages)*
Si un joueur est sur une case contenant un équipement (une arme ou une armure), il peut prendre l'équipement pour l'ajouter à son inventaire (l'équipement disparaît de la carte)

#### Fin d'un donjon
Un donjon se termine lorsqu'un joueur est tué (défaite) ou lorsque tous les monstres sont éliminés (victoire).

En cas de victoire, les personnages regagnent l'intégralité de leur vie et passent au donjon suivant.

### Exemple d'affichage

```console
********************************************************************************
Donjon 2:
                                    Caelynn (Elfe magicienne)              

********************************************************************************
Tour 3:
   And   Andry (Naine Clerc, 15/16)
   X(    Demogorgon (25/45)
   Dar   Darvin (Humain Guerrier, 13/20)
-> Cae   Caelynn (Elfe Magicienne, 10/12)
   X^    Dragon bleu (35/50)
   Alt   Alton (Halfelin Roublard, 14/16)

      A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W
   *-----------------------------------------------------------------------*
1  |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
2  |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
3  |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
4  |  .  .  .  .  X^ .  .  .  .  .  *  .  .  .  .  .  .  .  .  .  .  .  .  |
5  |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
6  |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
7  |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  *  .  .  .  .  .  .  |
8  |  .  .  .  .  .  .  .  .  . [ ] .  .  .  .  .  .  .  .  .  .  .  .  .  |
9  |  .  .  .  .  .  .  .  .  . [ ][ ] .  .  .  .  .  .  .  .  .  .  .  .  |
10 |  .  .  .  .  .  .  .  .  .  . [ ] . Alt .  .  .  .  .  .  .  .  .  .  |
11 |  .  .  .  .  .  .  .  .  .  . [ ] .  .  .  .  .  .  .  .  .  .  .  .  |
12 |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
13 |  .  .  .  .  .  .  .  .  .  .  . Cae .  .  .  .  .  .  .  .  .  .  .  |
14 |  .  .  .  .  .  .  .  .  .  .  . And .  .  .  X( .  .  .  *  .  .  .  |
15 |  .  .  .  .  *  .  .  .  .  *  .  .  .  .  .  .  .  .  .  .  .  .  .  |
16 |  .  .  .  .  .  .  .  .  .  .  .  .  . Dar .  .  .  .  .  .  .  .  .  |
17 |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
18 |  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  |
   *-----------------------------------------------------------------------*
    * Equipement   |   [ ] Obstacle  |

Caelynn
  Vie : 10/12
  Armure: aucune
  Arme: fronde (degat: 1d4, portee: 6)
  Inventaire: [1] baton
  Force: 8
  Dextérité: 16
  Vitesse: 12

Caelynn il vous reste 2 actions que souhaitez vous faire ?
  - laisser le maître du jeu commenter l'action précédente (mj <texte>)
  - commenter action précédente (com <texte>)
  - attaquer (att <Case>)
  - se déplacer (dep <Case>)
  - s'équiper (equ <numero equipement>)
```

```
  $ att P14
  Lancer un dé de 20 (appuyer sur n'importe quelle touche)
  $
  Vous avez fait 13
  Votre attaque est de 13+16(Dextérité)=29.
  Votre attaque perce l'armure du Demogorgon (18).
  Lancer un dé de 4 pour infliger des dégâts (appuyer sur n'importe quelle touche)
  $
  Le Demogorgon subit 3 dégâts!
  Il lui reste 22 PV.
```

Il n'est pas nécessaire de reproduire le visuel tel quel mais toutes les informations doivent être présentes.

### Fin du jeu

À la fin du jeu, un écran affiche "Vous avez perdu" ou "Vous avez gagné" et indique la cause de la défaite ou de la victoire.
## Rendus hebdomadaires

Votre projet doit être un fork de ce dépôt dans un groupe ayant pour nom `<nom_etudiant_1>-<nom_etudiant_2>`.
Votre enseignant en TP et le responsable du module doivent être ajoutés comme Reporter à votre projet.

Vous devez effectuer un rendu par semaine au plus tard le dimanche soir à minuit : la régularité des rendus sera prise en compte dans l'évaluation.
Un rendu est une branche qui a pour nom `rendu<numéro-rendu>`.
Le dernier rendu sera évalué en tant que rendu final.

Chaque rendu doit contenir :

- un programme qui compile dont les sources sont dans le répertoire `src/`,
- un diagramme de classes à jour placé dans le répertoire `uml/` ayant pour nom `semaine<numero>.puml`,

La structure du dépôt git doit être la suivante :
```bash
.
├── README.md
├── .gitignore
├── src/
    ├── Main.java
    ├── ...
├── uml/
    ├── semaine1.puml
    ├──...
```

## Rendus évalués

#### 1er rendu : 18 mai

Seront évalués :

- Diagramme de classes complet de la phase 1
  - respect des conventions UML
- Code
  - cohérence avec l'UML

## Quelques consignes

Veillez :

- à respecter les [P21 Guidelines](https://git.unistra.fr/p21/p21/-/blob/main/guidelines.pdf?ref_type=heads)
- à la bonne conception du code : il doit être lisible et facile à corriger, à réutiliser, à modifier et à étendre.

## Quelques conseils

- N'essayez pas d'implémenter toutes les fonctionnalités en une seule fois. Commencez par un programme simple mais fonctionnel et intégrez progressivement les fonctionnalités.
- Il s'agit d'une version très simplifiée de Donjon et Dragon. Il peut être tentant d'améliorer le projet et d'intégrer beaucoup de fonctionnalités et règles du jeu originel. Cependant cela ne vous permettra pas d'augmenter votre note. Ne négligez pas le projet de base ni les projets des autres modules. Vous aurez tout le loisir d'améliorer le projet durant votre été.
- Faites des commits réguliers sur vos branches de travail.
- Concevez votre code de façon à ce qu'il soit facile à modifier et à étendre avec de nouvelles fonctionnalités, notamment en prévision de la phase 2.
- La qualité de la conception et du code produit est plus importante que le nombre de fonctionnalités intégrées.
