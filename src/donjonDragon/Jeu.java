package donjonDragon;

import donjonDragon.entite.*;
import donjonDragon.equipement.*;
import donjonDragon.plateau.*;
import donjonDragon.entite.race.*;
import donjonDragon.entite.classe.*;
import donjonDragon.entite.sort.*; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jeu {
    private ArrayList<Donjon> m_donjons;
    private int m_donjonActuel;
    private ArrayList<Personnage> m_joueurs;
    private Scanner m_scanner;

    public Jeu() {
        this.m_joueurs = this.initialiserJoueurs();
        this.m_donjons = new ArrayList<>();
        this.m_donjonActuel = 0;
        this.m_scanner = new Scanner(System.in);

        // Création des 3 donjons
        for (int i = 0; i < 3; i++) {
            m_donjons.add(null);
        }
    }
    
    public ArrayList<Personnage> initialiserJoueurs()
    {
        ArrayList<Personnage> joueurs = new ArrayList<Personnage>();
        
        // Récupérer le nombre de joueurs
        boolean valide = false;
        int nbJoueurs = 0;
        while (!valide)
        {
            nbJoueurs = AffichageJeu.nombreJoueurs(4);
            if ((nbJoueurs > 0) && (nbJoueurs <= 4)) { valide = true; }
            else { AffichageJeu.afficherErreur(); }
        }
        
        // Créer les joueurs
        for (int i=0; i<nbJoueurs; i++)
        {
            String nom = AffichageJeu.nomJoueur(i+1);
            Classe classe = initClassePersonnage();
            Race race = initRacePersonnage();
            
            int pvMax = classe.getPv();
            AffichageJeu.presentationCaracteristiques();
            int force = this.initCaracteristiquePersonnage("force");
            force += race.getForce();
            int dexterite = this.initCaracteristiquePersonnage("dextérité");
            dexterite += race.getDexterite();
            int vitesse = this.initCaracteristiquePersonnage("vitesse");
            vitesse += race.getVitesse();
            int initiative = this.initCaracteristiquePersonnage("initiative");
            initiative += race.getInitiative();
            
            Personnage joueur = new Personnage(nom, classe, race, pvMax, force, dexterite, vitesse, initiative);
            joueurs.add(joueur);
        }
        
        return joueurs;
    }
    
    public Classe initClassePersonnage()
    {
        boolean valide = false;
        Classe classe = null;
        while (!valide) {
            String nomClasse = AffichageJeu.classeJoueur();
            if (nomClasse.equals("clerc")) {
                classe = new Clerc();
                valide = true;
            }
            else if (nomClasse.equals("guerrier")) {
                classe = new Guerrier();
                valide = true;
            }
            else if (nomClasse.equals("magicien")) {
                classe = new Magicien();
                valide = true;
            }
            else if (nomClasse.equals("roublard")) {
                classe = new Roublard();
                valide = true;
            }
            else { AffichageJeu.afficherErreur(); }
        }
        return classe;
    }
    
    public Race initRacePersonnage()
    {
        boolean valide = false;
        Race race = null;
        while (!valide) {
            String nomRace = AffichageJeu.raceJoueur();
            if (nomRace.equals("elfe")) {
                race = new Elfe();
                valide = true;
            }
            else if (nomRace.equals("halfelin")) {
                race = new Halfelin();
                valide = true;
            }
            else if (nomRace.equals("humain")) {
                race = new Humain();
                valide = true;
            }
            else if (nomRace.equals("nain")) {
                race = new Nain();
                valide = true;
            }
            else { AffichageJeu.afficherErreur(); }
        }
        return race;
    }
    
    public int initCaracteristiquePersonnage(String nomCaracteristique)
    {
        AffichageJeu.caracteristiqueJoueur(nomCaracteristique);
        De de = new De(4,4);
        int caracteristique = 3;
        caracteristique += de.lancer();                        
        return caracteristique;
    }

    public void lancerPartie() {
        System.out.println("Début de la partie !");

        while (m_donjonActuel < m_donjons.size()) {
            Personnage joueur;
            Monstre monstre;
            Donjon donjon = m_donjons.get(m_donjonActuel);
            int nbtour=1;
            System.out.println("\n--- Donjon " + (m_donjonActuel + 1) + " ---");

            donjon = proposerMiseEnPlace();
            for (Personnage p : m_joueurs) p.choisirEquipementDepart(); // à implémenter
            ArrayList<Entite> initiativeOrdre = calculerInitiative(donjon);

            boolean donjonTermine = false;
            while (!donjonTermine) {
                for (Entite entite : initiativeOrdre) {
                    if (auMoinsUnJoueurMort()) {
                        AffichageJeu.afficherDefaite();
                        return;
                    }

                    if (entite.estEnVie()) {
                        switch (entite.getType()) {
                            case JOUEUR:
                                AffichageJeu.afficherOrdre(nbtour, initiativeOrdre, entite);
                                gererTourPersonnage((Personnage) entite, donjon);
                                break;
                            case MONSTRE:
                                AffichageJeu.afficherOrdre(nbtour, initiativeOrdre, entite);
                                gererTourMonstre((Monstre) entite, donjon);
                                break;
                            default:
                                System.out.println("Type d'entité inconnu.");
                                break;
                        }
                    if(donjonEstTermine(donjon)) {
                        donjonTermine = true;
                        break;
                        }
                    }
                    nbtour++;
                }

                if (!auMoinsUnJoueurMort()) {
                    restaurerVieJoueurs();
                    AffichageJeu.afficherVictoireDonjon(m_donjonActuel);
                    m_donjonActuel++;
                }
            }

            AffichageJeu.afficherVictoire();
        }
    }

    public Donjon proposerMiseEnPlace (){
        System.out.print("Souhaitez-vous une mise en place automatique ? (oui/non) : ");
        String choix = m_scanner.nextLine().trim().toLowerCase();
        if (choix.equals("oui")) {
            ArrayList<Equipement> equipementsParDefaut = new ArrayList<>();
            equipementsParDefaut.add(new Armure("Armure d'écailles", 9, false));
            equipementsParDefaut.add(new Armure("Demi-plate", 10, false));
            equipementsParDefaut.add(new Armure("Cotte de mailles", 11, false));
            equipementsParDefaut.add(new Armure("Harnois", 12, false));
            equipementsParDefaut.add(new Arme("Bâton",  new De(1, 6), 1, false));
            equipementsParDefaut.add(new Arme("Masse d'armes",  new De(1, 6), 1, false));
            equipementsParDefaut.add(new Arme("Épée longue", new De(1, 8), 1, true));
            equipementsParDefaut.add(new Arme("Rapière", new De(1, 8), 1, true));
            equipementsParDefaut.add(new Arme("Arbalète légère", new De(1, 8), 16, false));
            equipementsParDefaut.add(new Arme("Fronde", new De(1, 4), 6, false));
            equipementsParDefaut.add(new Arme("Arc court",  new De(1, 6), 16, false));
            equipementsParDefaut.add(new Arme("l'épée à deux mains", new De(2,6), 1,true));
            ArrayList<Monstre> monstresParDefaut = new ArrayList<>();
            monstresParDefaut.add(new Monstre("Gobelin", 0, new De(1, 4), 1, 6, 1, 2, 2, 1, 8, "XvX"));
            monstresParDefaut.add(new Monstre("Gobelin", 1, new De(1, 4), 1, 6, 1, 2, 2, 1, 8, "XvX"));
            monstresParDefaut.add(new Monstre("Squelette", 0, new De(1, 6), 1, 8, 2, 2, 1, 1, 7, "0°0"));
            monstresParDefaut.add(new Monstre("Squelette", 1, new De(1, 6), 1, 8, 2, 2, 1, 1, 7, "0°0"));
            monstresParDefaut.add(new Monstre("Orc", 0, new De(1, 8), 2, 12, 3, 3, 2, 2, 12, "0w0"));
            monstresParDefaut.add(new Monstre("Ogre", 0, new De(2, 6), 3, 20, 4, 2, 1, 3, 15, "uwu"));
            
            Donjon donjon = new Donjon(25,20);
            donjon.donjonDefaut(m_joueurs,equipementsParDefaut,monstresParDefaut );
            return donjon;
        } else {
            Donjon donjon = new Donjon();
            donjon.afficherCarte();
            for (Personnage p : m_joueurs) donjon.placerEntite(p);
            donjon.afficherCarte();
            
            // creation et ajout des monstres dans le donjon à implémenter
            donjon.creerMonstre();
            for (Monstre m : donjon.getMonstres()) donjon.placerEntite(m);
            donjon.afficherCarte();
            
            //ajouter les obstacles
            boolean valide = false;
            int nbObstacles = 0;
            while (!valide)
            {
                nbObstacles = AffichageJeu.nombreObjet(donjon.getTaille(), "obstacles");
                if ((nbObstacles >= 0) && (nbObstacles <= donjon.getTaille())) { valide = true; }
                else { AffichageJeu.afficherErreur(); }
            }
            for (int i=0; i<nbObstacles; i++) { donjon.placerObstacle(); }
            donjon.afficherCarte();
            
            donjon = this.ajoutEquipementDonjon(donjon);
            
            return donjon;
        }
    }
    
    public Donjon ajoutEquipementDonjon(Donjon donjon)
    {
        //ajouter les equipements
        boolean valide = false;
        int nbEquipement = 0;
        while (!valide)
        {
            nbEquipement = AffichageJeu.nombreObjet(donjon.getTaille(), "équipement");
            if ((nbEquipement >= 0) && (nbEquipement <= donjon.getTaille())) { valide = true; }
            else { AffichageJeu.afficherErreur(); }
        }
        for (int i=0; i<nbEquipement; i++) { 
            String nomObjet = AffichageJeu.choisirEquipement(i);
            Equipement objet = this.objetSelectionnnez(nomObjet);
            
            donjon.placerEquipement(objet);
        }
        
        return donjon;
    }
    
    public Equipement objetSelectionnnez(String nomObjet)
    {
        boolean valide = false;
        Equipement objet = null;
        while (!valide)
        {
            if (nomObjet.equals("armure d'écailles")) { 
                objet = new Armure("Armure d'écailles", 9, false);
                valide = true;
            }
            else if (nomObjet.equals("demi-plate")) { 
                objet = new Armure("Demi-plate", 10, false);
                valide = true;
            }
            else if (nomObjet.equals("cotte de mailles")) { 
                objet = new Armure("Cotte de mailles", 11, false);
                valide = true;
            }
            else if (nomObjet.equals("harnois")) { 
                objet = new Armure("Harnois", 12, false);
                valide = true;
            }
            else if (nomObjet.equals("bâton")) { 
                objet = new Arme("Bâton",  new De(1, 6), 1, false);
                valide = true;
            }
            else if (nomObjet.equals("masse d'armes")) { 
                objet = new Arme("Masse d'armes",  new De(1, 6), 1, false);
                valide = true;
            }
            else if (nomObjet.equals("épée longue")) { 
                objet = new Arme("Épée longue", new De(1, 8), 1, true);
                valide = true;
            }
            else if (nomObjet.equals("rapière")) { 
                objet = new Arme("Rapière", new De(1, 8), 1, true);
                valide = true;
            }
            else if (nomObjet.equals("fronde")) { 
                objet = new Arme("Fronde", new De(1, 4), 6, false);
                valide = true;
            }
            else if (nomObjet.equals("arc court")) { 
                objet = new Arme("Arc court",  new De(1, 6), 16, false);
                valide = true;
            }
            else if (nomObjet.equals("l'épée à deux mains")) { 
                objet = new Arme("l'épée à deux mains", new De(2,6), 1,true);
                valide = true;
            }
            else { AffichageJeu.afficherErreur(); }            
        }
        return objet;
    }

    public ArrayList<Entite> calculerInitiative(Donjon donjon) {
        ArrayList<Entite> entites = new ArrayList<>();
        if (m_joueurs == null) {
            System.out.println("ERREUR : m_joueurs est null !");
        }
        if (donjon.getMonstres() == null) {
            System.out.println("ERREUR : donjon.getMonstres() est null !");
        }

        entites.addAll(m_joueurs);
        entites.addAll(donjon.getMonstres());

        De unDeVingt = new De(1, 20);
        Map<Entite, Integer> initiatives = new HashMap<>();

        // On lance une seule fois le dé pour chaque entité + initiative statique
        for (Entite e : entites) {
            AffichageJeu.afficherInitiativeCombattant(e.getNom());
            int jet = unDeVingt.lancer();
            int totalInitiative = jet + e.getInitiative();
            initiatives.put(e, totalInitiative);
        }

        // On trie selon les valeurs stockées dans la map
        entites.sort((a, b) -> initiatives.get(b).compareTo(initiatives.get(a)));

        return entites;
    }

    public void gererTourPersonnage (Personnage joueur, Donjon donjon){
        int actions = 3;
        String input="";
        int[]pos=new int[2];
        while (actions > 0) {
            donjon.afficherCarte();
            System.out.println(joueur.toString());
            AffichageJeu.afficherTourPersonnage(joueur,actions);
            input=AffichageJeu.nextLineTourPersonnage();
            if (input.startsWith("com ")) {
                AffichageJeu.afficherRP(input.substring(4));
            } else if (input.startsWith("att ")) {
                if(donjon.coordonneX(input.charAt(4))!= -1){
                    pos[1]=donjon.coordonneX(input.charAt(4));
                    pos[0]=Integer.parseInt(input.substring(5))-1;
                    if(donjon.coordonneValide(pos[0],pos[1])){
                        if(donjon.attaquerEntite(joueur,donjon.getCarte()[pos[0]][pos[1]].getEntite()))
                        {
                            actions--;
                        }
                    }
                }
            } else if (input.startsWith("dep ")) {
                if(donjon.coordonneX(input.charAt(4))!= -1){
                    pos[1]=donjon.coordonneX(input.charAt(4));
                    pos[0]=Integer.parseInt(input.substring(5))-1;
                    if(donjon.coordonneValide(pos[0],pos[1])){
                        if(donjon.deplacementEntite(joueur,pos))
                        {
                            actions--;
                        }
                    }
                }
            } else if (input.startsWith("ram")) {
                int[] posJoueur = donjon.trouverPositionEntite(joueur);
                if (posJoueur != null) {
                    Position caseJoueur = donjon.getCarte()[posJoueur[0]][posJoueur[1]];
                    if (joueur.ramasser(caseJoueur)) {
                        actions--;
                    }
                }
            } else if (input.startsWith("equ ")) {
                if(joueur.sEquiper(joueur.getInventaire().get(Integer.parseInt(input.substring(4))))){
                    actions--;
                }
                else{
                    AffichageJeu.afficherErreur();
                }
            } else if (input.startsWith("lan")) {
                Classe classeJoueur = joueur.getClasse();
                if (classeJoueur.getTypeClasse() != TypeClasse.AUTRE)
                {
                    String sort = AffichageJeu.proposerSort();
                    if (sort.equals("guérison")) {
                        Sort guerison = new Guerison();
                        guerison.lancer(m_joueurs,donjon);
                        actions--; 
                    }
                    else if (sort.equals("woogie woogie")) {
                        Sort boogieWoogie = new BoogieWoogie();
                        boogieWoogie.lancer(m_joueurs,donjon);
                        actions--; 
                    }
                    else if (sort.equals("arme magique")) {
                        Sort armeMagique = new ArmeMagique();
                        armeMagique.lancer(m_joueurs,donjon);
                        actions--; 
                    }
                    else { System.out.println("Commande invalide."); }
                }
                else { AffichageJeu.mauvaiseClasse(); }
            } else {
                System.out.println("Commande invalide.");
            }
            gererTourMJ(donjon);
        }
    }

    public void gererTourMonstre (Monstre monstre, Donjon donjon){
        int actions = 3;
        String input="";
        int[]pos=new int[2];
        while (actions > 0) {
            donjon.afficherCarte();
            System.out.println(monstre.toString());
            AffichageJeu.afficherTourMonstre(monstre,actions);
            input=AffichageJeu.nextLineTourMonstre();
            if (input.startsWith("com ")) {
                System.out.println("RP : " + input.substring(4));
            } else if (input.startsWith("att ")) {
                if(donjon.coordonneX(input.charAt(4))!= -1){
                    pos[1]=donjon.coordonneX(input.charAt(4));
                    pos[0]=Integer.parseInt(input.substring(5))-1;
                    if(donjon.coordonneValide(pos[0],pos[1])){
                        if(donjon.attaquerEntite(monstre,donjon.getCarte()[pos[0]][pos[1]].getEntite()))
                        {
                            actions--;
                        }
                    }
                }
            } else if (input.startsWith("dep ")) {
                if(donjon.coordonneX(input.charAt(4))!= -1){
                    pos[1]=donjon.coordonneX(input.charAt(4));
                    pos[0]=Integer.parseInt(input.substring(5))-1;
                    if(donjon.coordonneValide(pos[0],pos[1])){
                        if(donjon.deplacementEntite(monstre,pos))
                        {
                            actions--;
                        }
                    }
                }
            } else {
                System.out.println("Commande invalide.");
            }
            gererTourMJ(donjon);
        }
    }
    public void gererTourMJ(Donjon donjon) {
        int[]pos=new int[2];
        AffichageJeu.afficherGererTourMJ();
        String input = AffichageJeu.nextLineGererTourMJ();

        if (input.startsWith("deplacer ")) {
            if (donjon.coordonneX(input.charAt(9)) != -1) {
                pos[1] = donjon.coordonneX(input.charAt(9));
                pos[0] = Integer.parseInt(input.substring(10)) - 1;

                if (donjon.coordonneValide(pos[0], pos[1])) {
                    Position caseSource = donjon.getCarte()[pos[0]][pos[1]];
                    if (!donjon.deplacementEntiteMJ(caseSource)) {
                        System.out.println("Échec du déplacement.");
                    }
                } else {
                    System.out.println("Coordonnées invalides.");
                }
            } else {
                System.out.println("Coordonnée X invalide.");
            }
        } else if (input.startsWith("degats ")) {
            if(donjon.coordonneX(input.charAt(7))!= -1){
                pos[1]=donjon.coordonneX(input.charAt(7));
                pos[0]=Integer.parseInt(input.substring(8))-1;
                if(donjon.coordonneValide(pos[0],pos[1])){
                    De degat= AffichageJeu.demanderLancerDe();
                    if(donjon.attaquerEntiteMJ(donjon.getCarte()[pos[0]][pos[1]],degat))
                    {

                    }
                    else{
                        System.out.println("Ya personne ici");
                    }
                }
            }
        } else if (input.startsWith("obstacle")) {
            boolean valide = false;
            int nbObstacles = 0;
            while (!valide)
            {
                nbObstacles = AffichageJeu.nombreObjet(donjon.getTaille(), "obstacles");
                if ((nbObstacles >= 0) && (nbObstacles <= donjon.getTaille())) { valide = true; }
                else { AffichageJeu.afficherErreur(); }
            }
            for (int i=0; i<nbObstacles; i++) { donjon.placerObstacle(); }
            donjon.afficherCarte();
        } else if (input.startsWith("passer")) {
            System.out.println("Le MJ ne fait rien.");
        } else {
            System.out.println("Commande du MJ invalide.");
        }
    }


    public boolean donjonEstTermine (Donjon donjon){
        for (Monstre m : donjon.getMonstres()) {
            if (m.estEnVie()) return false;
        }
        return true;
    }

    public void restaurerVieJoueurs () {
        for (Personnage p : m_joueurs) {
            p.setPv(p.getPvMax());
        }
    }

    public boolean auMoinsUnJoueurMort () {
        for (Personnage p : m_joueurs) {
            if (!p.estEnVie()) return true;
        }
        return false;
    }
}
