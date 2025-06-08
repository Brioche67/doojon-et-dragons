package donjonDragon.entite.sort;

import donjonDragon.De;
import donjonDragon.entite.*;
import donjonDragon.plateau.Donjon;

import java.util.ArrayList;
import java.util.Scanner;

public class Guerison implements Sort{
    private Scanner m_scanner;

    public Guerison() {
        m_scanner = new Scanner(System.in);
    }

    @Override
    public void lancer(ArrayList<Personnage> entites, Donjon donjon)
    {
        listPerso(entites);
        Entite cible = entites.get(Integer.parseInt(m_scanner.nextLine())-1);
        De UnDeDix = new De(1,10);
        int resSoin = UnDeDix.lancer();
        if(cible.getPv()+resSoin>cible.getPvMax()){
            cible.setPv(cible.getPvMax());
            System.out.println(cible.getNom()+" a été entièrement soigné ! Ses pv sont à son maximum ! ("+cible.getPvMax()+")");
        }
        else{
            cible.setPv(cible.getPv()+resSoin);
            System.out.println(cible.getNom()+" a été soigné ! Ses pv sont à "+cible.getPv()+"/"+cible.getPvMax());
        }
    }
    public void listPerso(ArrayList<Personnage> persos)
    {
        System.out.println("Choisissez une cible parmis :");
        int i = 0;
        for (Entite perso : persos)
        {
            System.out.println((i++)+" - "+perso.getNom());
        }
    }
}
