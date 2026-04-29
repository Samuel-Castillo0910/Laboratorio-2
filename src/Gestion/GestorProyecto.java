package Gestion;

import Proyecto.Proyecto;
import Workers.Worker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestorProyecto {

    private ArrayList<Proyecto> proyectos = new ArrayList<>();

    public void agregarProyecto(Proyecto proyecto) {
        boolean yaExiste = proyectos.stream()
                .anyMatch(p -> p.getId() == proyecto.getId());
        if (!yaExiste) {
            proyectos.add(proyecto);
            System.out.println("Proyecto agregado: " + proyecto.getNombre());
        } else {
            System.out.println("Proyecto ya existe");
        }
    }

    public void eliminarProyecto(int id) {
        proyectos.removeIf(p -> p.getId() == id);
        System.out.println("Eliminado");
    }

    public Optional<Proyecto> buscarProyecto(int id) {
        return proyectos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public List<Proyecto> filtrar(Predicate<Proyecto> criterio) {
        return proyectos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    public List<Proyecto> ordenar(Comparator<Proyecto> criterio) {
        return proyectos.stream()
                .sorted(criterio)
                .collect(Collectors.toList());
    }

    public List<Worker> mejoresDesempeños() {
        return proyectos.stream()
                .flatMap(p -> p.getTrabajadores().stream())
                .filter(w -> w.CalculatePerformance() >= 90)
                .distinct()
                .collect(Collectors.toList());
    }

    public void mostrarProyectos() {
        for (Proyecto p : proyectos) {
            System.out.println(p);
            System.out.println("Trabajadores: ");
            for (Worker w : p.getTrabajadores()) {
                System.out.println( w.getName()
                        + " desempeño: " + w.getPerformance()
                        + " score: " + w.CalculatePerformance());
            }
        }
    }

    public ArrayList<Proyecto> getProyectos() { return proyectos; }
}
