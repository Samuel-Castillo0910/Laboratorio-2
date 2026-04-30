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

    public Proyecto(String nombre, int id, String estado) {
        this.nombre = nombre;
        this.id = id;
        this.estado = estado;
    }

    public String getNombre() { return nombre; }
    public int getId() { return id; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Proyecto)) return false;
        Proyecto otro = (Proyecto) obj;
        return this.id == otro.id;
    }

    @Override
    public String toString() {
        return "Proyecto: " + nombre + " id: " + id + " estado: " + estado;
    }
}
