package edu.heroesYVillanos.modelo.entidades;

import java.util.ArrayList;
import java.util.List;

public class Liga extends Enfrentable {
    private List<Enfrentable> integrantes;

    public Liga(String nombre, String nombreFantasia, List<Enfrentable> integrantes) {
        super(nombre, nombreFantasia);
        this.integrantes = integrantes;
    }

    public Liga(String nombre, String nombreFantasia) {
        super(nombre, nombreFantasia);
        this.integrantes = new ArrayList<>();
    }

    public boolean addIntegrante(Enfrentable e){
        if (!integrantes.contains(e)){
            return integrantes.add(e);
        } else {
            return false;
        }
    }

    @Override
    public float getValorAtributo(String key) {
        float valor = 0;
        int contador = 0;
        for (Enfrentable integrante : integrantes){
            valor += integrante.getValorAtributo(key);
            contador++;
        }
        return (contador > 0) ? valor/contador : 0;
    }

    @Override
    protected List<Personaje> getPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        for (Enfrentable integrante : integrantes){
            if (integrante instanceof Personaje){
                personajes.add((Personaje) integrante);
            }
        }
        return personajes;
    }
}
