package edu.heroesYVillanos.modelo.entidades;

import java.util.Comparator;
import java.util.List;

public abstract class Enfrentable {
    protected String nombre;
    protected String nombreFantasia;

    public Enfrentable(String nombre, String nombreFantasia) {
        this.nombre = nombre;
        this.nombreFantasia = nombreFantasia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public abstract float getValorAtributo(String key);

    public Enfrentable enfrentar(Enfrentable e, Comparator c){
        int result = c.compare(this, e);
        if (result > 0) {
            return this;
        } else if(result < 0) {
            return e;
        } else {
            return null;
        }
    }

    public List<Personaje> ordenar(Comparator c){
        List<Personaje> personajes = getPersonajes();
        personajes.sort(c);
        return personajes;
    }

    protected abstract List<Personaje> getPersonajes();
}
