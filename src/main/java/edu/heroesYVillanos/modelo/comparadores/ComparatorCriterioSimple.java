package edu.heroesYVillanos.modelo.comparadores;

import edu.heroesYVillanos.modelo.entidades.Enfrentable;

import java.util.Comparator;

public class ComparatorCriterioSimple implements Comparator<Enfrentable> {
    private String atributo;

    public ComparatorCriterioSimple(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public int compare(Enfrentable e1, Enfrentable e2) {
        return Float.compare(e1.getValorAtributo(atributo), e2.getValorAtributo(atributo));
    }
}
