package Proyecto;
import Workers.Worker;
import java.util.ArrayList;


public class Asignacion {
    private Worker Trabajador;
    private Proyecto Proyecto;
    private ArrayList<Asignacion> Asignacion = new ArrayList<>();

    public Asignacion() {
    }

    private Asignacion(Worker trabajador, Proyecto proyecto) {
        this.Trabajador = trabajador;
        this.Proyecto = proyecto;
    }

    public void asignarProyecto (Worker trabajador, Proyecto proyecto){
            Asignacion.add(new Asignacion(trabajador,proyecto));
    }

    public Worker getTrabajador() { return Trabajador; }
    public Proyecto getProyecto() { return Proyecto; }
    public ArrayList<Asignacion> getAsignaciones() { return Asignacion; }

    public ArrayList<Worker> getTrabajadoresPorProyecto(Proyecto proyecto) {
        ArrayList<Worker> resultado = new ArrayList<>();
        for (Asignacion a : Asignacion) {
            if (a.getProyecto().equals(proyecto)) {
                resultado.add(a.getTrabajador());
            }
        }
        return resultado;
    }
}
