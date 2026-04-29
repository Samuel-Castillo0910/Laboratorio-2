package Proyecto;

import Workers.Worker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Proyecto {
    private String nombre;
    private int id;
    private String estado;
    private ArrayList<Worker> trabajadores = new ArrayList<>();

    public Proyecto(String nombre, int id, String estado) {
        this.nombre = nombre;
        this.id = id;
        this.estado = estado;
    }

    public void agregarTrabajador(Worker worker) {
        boolean yaExiste = trabajadores.stream()
                .anyMatch(w -> w.getId() == worker.getId());
        if (!yaExiste) {
            trabajadores.add(worker);
            System.out.println("Trabajador " + worker.getName() + " agregado al proyecto " + nombre);
        } else {
            System.out.println("Ese trabajador ya esta en el proyecto");
        }
    }

    public Optional<Worker> buscarTrabajador(int id) {
        return trabajadores.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }

    public List<Worker> mejoresTrabajadores() {
        return trabajadores.stream()
                .filter(w -> w.CalculatePerformance() >= 90)
                .collect(Collectors.toList());
    }

    public List<Worker> filtrarTrabajadores(Predicate<Worker> criterio) {
        return trabajadores.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    public List<Worker> ordenarTrabajadores(Comparator<Worker> criterio) {
        return trabajadores.stream()
                .sorted(criterio)
                .collect(Collectors.toList());
    }

    public String getNombre() { return nombre; }
    public int getId() { return id; }
    public String getEstado() { return estado; }
    public List<Worker> getTrabajadores() { return trabajadores; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Proyecto: " + nombre + " id: " + id + " estado: " + estado;
    }
}
