package edu.heroesYVillanos.modelo.comparadores;

import edu.heroesYVillanos.modelo.entidades.Enfrentable;

import java.util.Comparator;

public class ComparatorNombre implements Comparator<Enfrentable> {
    @Override
    public int compare(Enfrentable e1, Enfrentable e2) {
        return e1.getNombreFantasia().compareTo(e2.getNombreFantasia());
    }
}
