package edu.heroesYVillanos.modelo;

import edu.heroesYVillanos.modelo.entidades.Enfrentable;
import edu.heroesYVillanos.modelo.entidades.Personaje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Juego {
    private List<Enfrentable> enfrentables;

    public Juego() {
        this.enfrentables = new ArrayList<>();
    }

    public List<Enfrentable> getQuienesVencen(Enfrentable e, Comparator c){
        List<Enfrentable> vencedores = new ArrayList<>();
        for (Enfrentable enfrentable : enfrentables) {
            if (!enfrentable.equals(e) && enfrentable.enfrentar(e, c) == enfrentable) {
                vencedores.add(enfrentable);
            }
        }
        return vencedores;
    }

    public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator c){
        return e1.enfrentar(e2,c);
    }

    public boolean addEnfrentable(Enfrentable e){
        if(!enfrentables.contains(e)){
            return enfrentables.add(e);
        } else {
            return false;
        }
    }

    public List<Personaje> ordenarPersonajes(Comparator c){
        List<Personaje> personajes = new ArrayList<>();
        for (Enfrentable enfrentable : enfrentables) {
            if (enfrentable instanceof Personaje) {
                personajes.add((Personaje) enfrentable);
            }
        }
        personajes.sort(c);
        return personajes;
    }
}
