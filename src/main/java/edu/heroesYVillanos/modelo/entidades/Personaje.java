package edu.heroesYVillanos.modelo.entidades;

import edu.heroesYVillanos.modelo.atributos.Atributo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personaje extends Enfrentable {
    private Map<String, Atributo> atributos;

    public Personaje(String nombre, String nombreFantasia) {
        super(nombre, nombreFantasia);
        this.atributos = new HashMap<>();
    }

    @Override
    public float getValorAtributo(String key) {
        Atributo atributo = atributos.get(key);
        return (atributo != null) ? atributo.getValor(this) : 0;
    }

    @Override
    protected List<Personaje> getPersonajes() {
        return List.of(this);
    }

    public boolean addAtributo(String k, Atributo a){
        if(!atributos.containsKey(k)){
            atributos.put(k,a);
            return true;
        }
        return false;
    }
}
