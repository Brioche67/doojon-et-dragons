package donjonDragon.entite.sort;

import donjonDragon.entite.*;
import donjonDragon.plateau.Donjon;

import java.util.ArrayList;

public interface Sort {
    void lancer(ArrayList<Personnage> entites, Donjon donjon);
}
