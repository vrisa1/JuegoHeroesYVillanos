package edu.heroesYVillanos;
import edu.heroesYVillanos.modelo.*;
import edu.heroesYVillanos.modelo.atributos.*;
import edu.heroesYVillanos.modelo.comparadores.*;
import edu.heroesYVillanos.modelo.entidades.*;

import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Juego
        Juego juego = new Juego();

        //Atributos
        Atributo fuerza = new AtributoSimple(700);
        Atributo velocidad = new AtributoSimple(600);
        Atributo invisibilidad = new AtributoSimple(200);
        Atributo edad = new AtributoSimple(45);
        Atributo resistencia = new AtributoOperacion("fuerza", "velocidad");
        Atributo camuflaje = new AtributoCondicional("invisibilidad", "fuerza",new AtributoSimple(50),velocidad);

        //Personajes
        Personaje heroe1 = new Personaje("Tony Stark", "Ironman");
        heroe1.addAtributo("fuerza", fuerza);
        heroe1.addAtributo("velocidad", velocidad);
        heroe1.addAtributo("invisibilidad", invisibilidad);
        heroe1.addAtributo("edad", edad);
        heroe1.addAtributo("resistencia", resistencia);
        heroe1.addAtributo("camuflaje", camuflaje);

        Personaje heroe2 = new Personaje("Natasha Romanoff", "Black Widow");
        heroe2.addAtributo("fuerza", new AtributoSimple(500));
        heroe2.addAtributo("velocidad", new AtributoSimple(300));
        heroe2.addAtributo("invisibilidad", new AtributoSimple(300));
        heroe2.addAtributo("edad", new AtributoSimple(33));
        heroe2.addAtributo("resistencia", resistencia);
        heroe2.addAtributo("camuflaje", new AtributoCondicional("invisibilidad", "fuerza", new AtributoSimple(50), new AtributoSimple(300)));

        Personaje villano1 = new Personaje("Loki", "Loki");
        villano1.addAtributo("fuerza", new AtributoSimple(500));
        villano1.addAtributo("velocidad", new AtributoSimple(350));
        villano1.addAtributo("invisibilidad", new AtributoSimple(300));
        villano1.addAtributo("edad", new AtributoSimple(40));
        villano1.addAtributo("resistencia", resistencia);
        villano1.addAtributo("camuflaje", new AtributoCondicional("invisibilidad", "fuerza", new AtributoSimple(50), new AtributoSimple(350)));

        Personaje villano2 = new Personaje("Thanos", "Thanos");
        villano2.addAtributo("fuerza", new AtributoSimple(1000));
        villano2.addAtributo("velocidad", new AtributoSimple(800));
        villano2.addAtributo("invisibilidad", new AtributoSimple(400));
        villano2.addAtributo("edad", new AtributoSimple(50));
        villano2.addAtributo("resistencia", resistencia);
        villano2.addAtributo("camuflaje", new AtributoCondicional("invisibilidad", "fuerza", new AtributoSimple(50), new AtributoSimple(800)));

        //Agregar personajes al juego
        juego.addEnfrentable(heroe1);
        juego.addEnfrentable(heroe2);
        juego.addEnfrentable(villano1);
        juego.addEnfrentable(villano2);

        //Liga de héroes
        Liga ligaHeroes = new Liga("Liga de heroes", "Avengers");
        ligaHeroes.addIntegrante(heroe1);
        ligaHeroes.addIntegrante(heroe2);

        //Liga de villanos
        Liga ligaVillanos = new Liga("Liga de villanos", "Villanos");
        ligaVillanos.addIntegrante(villano1);
        ligaVillanos.addIntegrante(villano2);

        //Agregar ligas al juego
        juego.addEnfrentable(ligaHeroes);
        juego.addEnfrentable(ligaVillanos);

        //Comparadores
        Comparator<Enfrentable> comparadorFuerza = new ComparatorCriterioSimple("fuerza");
        Comparator<Enfrentable> comparadorResistencia = new ComparatorCriterioSimple("resistencia");
        Comparator<Enfrentable> comparadorCamuflaje = new ComparatorCriterioSimple("camuflaje");
        ComparatorCompuesto comparadores = new ComparatorCompuesto();
        comparadores.addComparator(comparadorFuerza);
        comparadores.addComparator(comparadorResistencia);

        //Enfrentar
        System.out.println("Enfrentamiento por fuerza: ");
        Enfrentable ganador = juego.enfrentar(heroe2, villano1, comparadorFuerza);
        if(ganador!=null) {
            System.out.println("El ganador entre " + heroe2.getNombreFantasia() + " y " + villano1.getNombreFantasia() + " es: " + ganador.getNombreFantasia());
        } else {
            System.out.println("El ganador entre " + heroe2.getNombreFantasia() + " y " + villano1.getNombreFantasia() + " es: Empate!");
        }

        System.out.println("Enfrentamiento por fuerza y resistencia: ");
        Enfrentable ganador2 = juego.enfrentar(heroe2, villano1, comparadores);
        if(ganador2!=null) {
            System.out.println("El ganador entre " + heroe2.getNombreFantasia() + " y " + villano1.getNombreFantasia() + " es: " + ganador2.getNombreFantasia());
        } else {
            System.out.println("El ganador entre " + heroe2.getNombreFantasia() + " y " + villano1.getNombreFantasia() + " es: Empate!");
        }

        System.out.println("Enfrentamiento por fuerza y resistencia: ");
        Enfrentable ganador3 = juego.enfrentar(heroe1, ligaVillanos, comparadores);
        if(ganador3!=null) {
            System.out.println("El ganador entre " + heroe1.getNombreFantasia() + " y " + ligaVillanos.getNombreFantasia() + " es: " + ganador3.getNombreFantasia());
        } else {
            System.out.println("El ganador entre " + heroe1.getNombreFantasia() + " y " + ligaVillanos.getNombreFantasia() + " es: Empate!");
        }

        //Obtener personajes que vencen a un personaje dado
        List<Enfrentable> vencedores = juego.getQuienesVencen(villano1, comparadorCamuflaje);
        System.out.println("Los personajes que vencen a " + villano1.getNombreFantasia() + " por camuflaje:");
        for (Enfrentable e : vencedores) {
            System.out.println("- " + e.getNombreFantasia());
        }

        //Ordenar personajes por resistencia
        List<Personaje> personajesOrdenados = juego.ordenarPersonajes(comparadorResistencia.reversed());
        System.out.println("Personajes ordenados por resistencia:");
        for (Personaje e : personajesOrdenados) {
            System.out.println("- " + e.getNombreFantasia() + " (Resistencia: " + e.getValorAtributo("resistencia") + ")");
        }

    }
}