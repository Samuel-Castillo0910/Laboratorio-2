package Main;

import Gestion.GestorProyecto;
import Gestion.GestorWorker;
import Proyecto.Proyecto;
import Workers.Worker;
import Proyecto.Asignacion;

public class Main {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("=========TRABAJADORES CREADOS=========");
        System.out.println("======================================");

        Worker Trabajador1 = new Worker("Samuel", 0, "Tecnico", 1000000, 95);
        Worker Trabajador2 = new Worker("Pepe", 1, "Programador", 100000, 50);
        Worker Trabajador3 = new Worker("Titi", 2, "Manager", 5000000, 80);
        Worker Trabajador4 = new Worker("Alexis", 3, "Tecnico", 2000000, 40);
        Worker Trabajador5 = new Worker("Ramon", 4, "Programador", 600000, 100);
        Worker Trabajador6 = new Worker("Jose", 5, "Manager", 9000000, 86);

        System.out.println(Trabajador1.toString());
        System.out.println(Trabajador2.toString());
        System.out.println(Trabajador3.toString());
        System.out.println(Trabajador4.toString());
        System.out.println(Trabajador5.toString());
        System.out.println(Trabajador6.toString());

        System.out.println("======================================");
        System.out.println("==========PROYECTOS  CREADOS==========");
        System.out.println("======================================");

        Proyecto Proyecto1 = new Proyecto("1", 0, "En Progreso");
        Proyecto Proyecto2 = new Proyecto("2", 1, "Finalizado");

        System.out.println(Proyecto1.toString());
        System.out.println(Proyecto2.toString());

        System.out.println("======================================");
        System.out.println("========TRABAJADOR POR PROYECTO========");
        System.out.println("======================================");

        Asignacion a = new Asignacion();

        a.asignarProyecto(Trabajador1, Proyecto1);
        a.asignarProyecto(Trabajador2, Proyecto1);
        a.asignarProyecto(Trabajador3, Proyecto1);
        a.asignarProyecto(Trabajador4, Proyecto2);
        a.asignarProyecto(Trabajador5, Proyecto2);
        a.asignarProyecto(Trabajador6, Proyecto2);

        System.out.println("Proyecto 1: " + a.getTrabajadoresPorProyecto(Proyecto1)
                .stream()
                .map(Worker::getName)
                .toList());

        System.out.println("Proyecto 2: " + a.getTrabajadoresPorProyecto(Proyecto2)
                .stream()
                .map(Worker::getName)
                .toList());

        System.out.println("======================================");
        System.out.println("========RANKING DE DESEMPEÑO==========");
        System.out.println("======================================");

        GestorWorker b = new GestorWorker();
        b.agregarWorker(Trabajador1);
        b.agregarWorker(Trabajador2);
        b.agregarWorker(Trabajador3);
        b.agregarWorker(Trabajador4);
        b.agregarWorker(Trabajador5);
        b.agregarWorker(Trabajador6);

        b.obtenerRankingDesempeño()
                .forEach(w -> System.out.println(w.getName() + " - " + w.getPerformance() + " - Score: " + w.CalculatePerformance()));

        System.out.println("======================================");
        System.out.println("==========DUPLICADO RECHAZADO=========");
        System.out.println("======================================");

        b.agregarWorker(Trabajador1);

        System.out.println("======================================");
        System.out.println("==========FILTRAR PROYECTOS===========");
        System.out.println("======================================");

        GestorProyecto gestorProyecto = new GestorProyecto();
        gestorProyecto.agregarProyecto(Proyecto1);
        gestorProyecto.agregarProyecto(Proyecto2);

        gestorProyecto.filtrar(p -> p.getEstado().equals("En Progreso"))
                .forEach(System.out::println);

        System.out.println("======================================");
        System.out.println("=========ORDENAR POR NOMBRE===========");
        System.out.println("======================================");

        b.listarPorNombre()
                .forEach(w -> System.out.println(w.getName()));

        System.out.println("======================================");
        System.out.println("==========BUSCAR POR ID===============");
        System.out.println("======================================");

        b.buscarPorId(0)
                .ifPresent(w -> System.out.println("Encontrado: " + w.getName()));

        b.buscarPorId(99)
                .ifPresentOrElse(
                        w -> System.out.println("Encontrado: " + w.getName()),
                        () -> System.out.println("Worker no encontrado")
                );
    }
}



