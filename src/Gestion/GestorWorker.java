package Gestion;

import Utils.OrdenadorGenerico;
import Workers.Worker;

import java.util.*;

public class GestorWorker {
    private Set<Worker> workers = new HashSet<>();

    public void agregarWorker(Worker w) {
        boolean agregado = workers.add(w);
        if (!agregado) {
            System.out.println("Worker " + w.getName() + " ya existe");
        }
    }

    public List<Worker> obtenerRankingDesempeño() {
        List<Worker> lista = new ArrayList<>(workers);
        return OrdenadorGenerico.ordenar(lista,
                Comparator.comparingDouble(Worker::CalculatePerformance).reversed());
    }

    public List<Worker> listarPorNombre() {
        return OrdenadorGenerico.ordenar(new ArrayList<>(workers),
                Comparator.comparing(Worker::getName));
    }

    public Optional<Worker> buscarPorId(int id) {
        return workers.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }
}