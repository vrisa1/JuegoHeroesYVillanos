package edu.heroesYVillanos.modelo.atributos;

import edu.heroesYVillanos.modelo.entidades.Enfrentable;

public class AtributoOperacion implements Atributo{
    protected String key1;
    protected String key2;

    public AtributoOperacion(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    @Override
    public float getValor(Enfrentable e) {
        float val1 = e.getValorAtributo(key1);
        float val2 = e.getValorAtributo(key2);
        return val1 / val2;
    }
}
