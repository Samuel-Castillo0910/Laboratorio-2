package Trabajador;

import java.util.ArrayList;

public class Trabajadores {
    private String Name;
    private int Id;
    private ArrayList<Trabajadores> trabajador = new ArrayList<>();

    public Trabajadores(String name, int id) {
        this.Name = name;
        this.Id = id;
    }

    public void generarTrabajador(Trabajadores trabajador){

    }

    public int getId() {
        return Id;
    }
}
