package edu.heroesYVillanos.modelo.comparadores;

import edu.heroesYVillanos.modelo.entidades.Enfrentable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorCompuesto implements Comparator<Enfrentable> {
    private List<Comparator> comparators;

    public ComparatorCompuesto() {
        this.comparators = new ArrayList<>();
    }

    public ComparatorCompuesto(List<Comparator> comparators) {
        this.comparators = comparators;
    }

    public boolean addComparator(Comparator c){
        if(!comparators.contains(c)){
            return comparators.add(c);
        } else {
            return false;
        }
    }

    public boolean addComparator(Comparator c, int index){
        if(!comparators.contains(c)){
            comparators.add(index, c);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compare(Enfrentable e1, Enfrentable e2) {
        for(Comparator c : comparators){
            int result = c.compare(e1, e2);
            if(result!=0){
                return result;
            }
        }
        return 0;
    }
}
