package Workers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Worker implements CalculatePerformance, meaning it signs a contract
public class Worker implements calculatePerformance {

    private String name;
    private int id;
    private double salary;
    private String job;
    private double performance;


    public Worker(String name, int id, String job, double salary, double performance) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.job = job;
        this.performance = performance;
    }

    // "this.performance" refers to the field of this object,
    // distinguishing it from any local variable or parameter that might
    // also be named "performance". Both work here, but "this." makes it clearer.
    @Override
    public double CalculatePerformance(){
        return this.performance;
    }

    // Translate the numeric score of performance into a readable tag.
    @Override
    public String getPerformance(){
        if (performance >= 90){ return "EXCELLENT!!";}
        if (performance >= 70) { return "GOOD!";}
        if(performance >= 50) { return "AVERAGE";}
        return "LOW";
    }

    //Getters
    public String getName() {return name;}
    public int getId() {return id;}
    public double getSalary() {return salary;}
    public String getJob() {return job;}
    //Setters
    // Immutable identity = consistent, trustworthy references throughout the system.
    public void setName(String name) {this.name = name;}
    public void setSalary(double salary) {this.salary = salary;}
    public void setJob(String job) {this.job = job;}
    public void setPerformance(double performance) {this.performance = performance;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Worker)) return false;
        Worker otro = (Worker) obj;
        return this.id == otro.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                ", performance=" + performance +
                '}';
    }
}
