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


    private ArrayList<Worker> workers = new ArrayList<>();

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

    // Adds a worker to this worker's list, but only if they are not already in it.
    // with the same worker, satisfying the client's "no duplicates" requirement.
    // stream() converts the list into a pipeline we can query.
    // anyMatch() goes through each element (w) and checks a condition.
    // w -> w.getId() == worker.getId() is a lambda for each w in the list,
    // compare its id to the id of the worker we want to add.
    // If any element matches, anyMatch() returns true and we skip the add.
    public void addWorker(Worker worker){
        boolean alreadyExists = workers.stream()
        .anyMatch(w -> w.getId() == worker.getId());
        if (!alreadyExists){
            workers.add(worker);
        }

    }

    // Returns the full internal list of workers.
    // Other classes can call this to iterate,
    public List<Worker> getWorkers() {
        return workers;
    }

    // Uses a stream to search the list by id and returns an Optional.
    // Optional means there might or might not be a result.
    // This forces the caller to handle the "not found" case,
    // avoiding NullPointerExceptions
    public Optional<Worker> findById(int id){
        return workers.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
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
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                ", performance=" + performance +
                ", workers=" + workers +
                '}';
    }
}
