package edu.heroesYVillanos.modelo.atributos;

import edu.heroesYVillanos.modelo.entidades.Enfrentable;

public class AtributoSimple implements Atributo{
    private float value;

    public AtributoSimple(float value) {
        this.value = value;
    }

    @Override
    public float getValor(Enfrentable e) {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
