package donjonDragon.entite.sort;

import donjonDragon.entite.*;
import donjonDragon.plateau.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BoogieWoogie implements Sort{
    private Scanner m_scanner;

    public BoogieWoogie() {
        m_scanner = new Scanner(System.in);
    }

    @Override
    public void lancer(ArrayList<Personnage> entites, Donjon donjon) {
        boolean valide = false;
        int[] cible1, cible2;
        while (!valide)
        {
            cible1 = this.coordonneCible(1,donjon);
            cible2 = this.coordonneCible(2,donjon);
            
            Position[][] carte = donjon.getCarte();
            Entite combattant1 = carte[cible1[0]][cible1[1]].getEntite();
            Entite combattant2 = carte[cible2[0]][cible2[1]].getEntite();
            if (!(carte[cible1[0]][cible1[1]].estVide() || carte[cible1[0]][cible1[1]].aJusteEquipement()) && !(carte[cible2[0]][cible2[1]].estVide() || carte[cible2[0]][cible2[1]].aJusteEquipement()))
            {
                carte[cible1[0]][cible1[1]].placerEntite(combattant1);
                carte[cible2[0]][cible2[1]].placerEntite(combattant2);
                valide = true;
            }
        }
    }
    
    public int[] coordonneCible(int numCible, Donjon donjon)
    {
        int[] cible = {-1,-1};
        boolean valide = false;
        while (!valide)
        {
            try {
                System.out.print("Insérer les coordonées de la cible "+numCible+":");
                String coord = m_scanner.nextLine().toUpperCase().trim();
                cible[1]=donjon.coordonneX(coord.charAt(0));
                cible[0]=Integer.parseInt(coord.substring(1))-1;
                valide = true;
            } catch (NumberFormatException e) {
                System.out.println("Erreur: Il faut entrer un nombre!");
            }
        }
        return cible;
    }
}
