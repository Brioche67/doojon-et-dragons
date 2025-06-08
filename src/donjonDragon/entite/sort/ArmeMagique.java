package donjonDragon.entite.sort;

import donjonDragon.entite.Entite;
import donjonDragon.entite.Personnage;
import donjonDragon.entite.TypeEntite;
import donjonDragon.equipement.Arme;
import donjonDragon.equipement.Equipement;
import donjonDragon.equipement.TypeEquipement;
import donjonDragon.plateau.Donjon;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmeMagique implements Sort{
    private Scanner m_scanner;

    public ArmeMagique() {
        m_scanner = new Scanner(System.in);
    }
    @Override
    public void lancer(ArrayList<Personnage> entites, Donjon donjon)
    {
        listPerso(entites);
        int index = -1;
        try {
            index = Integer.parseInt(m_scanner.nextLine()) - 1;
            if (index < 0 || index >= entites.size()) {
                System.out.println("Index invalide.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Entrée invalide.");
            return;
        }
        Personnage cible = entites.get(index);

        if (cible.getType() != TypeEntite.JOUEUR) {
            System.out.println("Ce sort ne peut être lancé que sur un personnage.");
            return;
        }
        Personnage perso = (Personnage) cible;

        ArrayList<Arme> armeDispo = new ArrayList<>();
        if(perso.getArme()!=null){
            armeDispo.add(perso.getArme());
        }
        for (Equipement equipement:perso.getInventaire()) {
            if(equipement.getType()== TypeEquipement.ARME){
                armeDispo.add((Arme)equipement);
            }
        }
        listArme(perso,armeDispo);

        int choix = -1;
        try {
            choix = Integer.parseInt(m_scanner.nextLine()) - 1;
            if (choix < 0 || choix >= armeDispo.size()) {
                System.out.println("Choix d'arme invalide.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Entrée invalide.");
            return;
        }

        Arme armeCible;
        if (choix == 0) {
            armeCible = perso.getArme();
        } else {
            armeCible = armeDispo.get(choix);
        }

        armeCible.setM_bonus(armeCible.getBonus()+1);

    }
    public void listPerso(ArrayList<Personnage> persos)
    {
        System.out.println("Choisissez une cible parmis :");
        for (int i=0;i<persos.size();i++)
        {
            System.out.println((i+1)+" - "+persos.get(i));
        }
    }
    public void listArme(Personnage perso,ArrayList<Arme> armeDispo){
        System.out.println("Choisissez une arme parmis :");

        for (int i=0;i<armeDispo.size();i++)
        {
            System.out.println((i+1)+" - "+armeDispo.get(i));
        }
    }
}
