package WildLife;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitoringSystem {
    private List<MonitoredZone> monitoredZones;
    private List<WildAnimal> wildAnimals;
    private Lock moveLock; // Lock for synchronization of animal movements
    private Semaphore reportSemaphore; // Semaphore for controlling report access

    public MonitoringSystem() {
        this.monitoredZones = new ArrayList<>();
        this.wildAnimals = new ArrayList<>();
        this.moveLock = new ReentrantLock();
        this.reportSemaphore = new Semaphore(1); // Only one thread can report at a time
    }

    public void addMonitoredZone(MonitoredZone zone) {
        monitoredZones.add(zone);
    }

    public void addWildAnimal(WildAnimal animal) {
        wildAnimals.add(animal);
    }

    // Placeholder method for simulating monitoring activities
    public void monitor() {
        for (MonitoredZone zone : monitoredZones) {
            zone.spawnWildAnimal();
            zone.moveWildAnimals();
            System.out.println("Monitoring activities in zone with size " + zone.getSize() + ".");
        }
    }

    // Placeholder method for reporting trouble
    public void reportTrouble(MonitoredZone zone, int x, int y) {
        try {
            reportSemaphore.acquire();
            System.out.println("Trouble reported in zone at position (" + x + ", " + y + ")");
            // Notify authorities or perform other actions
        } catch (InterruptedException e) {
            System.err.println("Error reporting trouble: " + e.getMessage());
        } finally {
            reportSemaphore.release();
        }
    }

    // Placeholder method for coordinating move and report to avoid concurrency
    public void coordinateMoveAndReport(WildAnimal animal) {
        moveLock.lock();
        try {
            animal.move(); // Ensure move is synchronized
            reportTrouble(animal.getZone(), animal.getX(), animal.getY()); // Ensure report is not called concurrently
        } finally {
            moveLock.unlock();
        }
    }

    public int getNumDevastatedPlaces() {
        // Placeholder logic to return the current number of devastated places
        // You need to implement the actual logic based on your simulation
        return 0;
    }

    public int[][] getAnimalPositions() {
        // Placeholder logic to return the current positions of wild animals
        // You need to implement the actual logic based on your simulation
        return null;
    }
}
