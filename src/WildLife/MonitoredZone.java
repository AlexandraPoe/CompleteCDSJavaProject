/*package WildLife;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonitoredZone {
    private int size; // N x N matrix size
    private List<WildAnimal> wildAnimals;
    private int[][] devastatedPlaces;

    public MonitoredZone(int size) {
        this.size = size;
        this.wildAnimals = new ArrayList<>();
        this.devastatedPlaces = new int[size][size];
    }
    

    public int getSize() {
        return size;
    }

    public List<WildAnimal> getWildAnimals() {
        return wildAnimals;
    }

    public int[][] getDevastatedPlaces() {
        return devastatedPlaces;
    }

    public synchronized void spawnWildAnimal() {
        Random rand = new Random();
        int x = rand.nextInt(size);
        int y = rand.nextInt(size);

        // Create a new WildAnimal and add it to the zone
        WildAnimal newAnimal = new WildAnimal(this, x, y);
        wildAnimals.add(newAnimal);

        // Inform authorities about the new animal
        System.out.println("New wild animal spawned at position (" + x + ", " + y + ")");
        monitoringSystem.addWildAnimal(newAnimal);
    }

    public synchronized void moveWildAnimals() {
        // Iterate through all wild animals and move them
        for (WildAnimal animal : wildAnimals) {
            animal.move();
        }
    }

    public synchronized void restWildAnimals() {
        // Iterate through all wild animals and make them rest if surrounded
        for (WildAnimal animal : wildAnimals) {
            animal.rest();
        }
    }

    public synchronized void simulateTimePassage() {
        // Placeholder logic for simulating time passage
        // This method may trigger periodic updates or activities in the zone
        System.out.println("Time is passing in the monitored zone...");
    }

    public synchronized void stopSimulation() {
        // Placeholder logic to stop the simulation
        // This method may involve interrupting threads and cleaning up resources
        System.out.println("Stopping the simulation in the monitored zone...");
    }

    public synchronized int getNumDevastatedPlaces() {
        // Placeholder logic to return the current number of devastated places
        // You need to implement the actual logic based on your simulation
        return 0;
    }

    public synchronized int[][] getAnimalPositions() {
        // Placeholder logic to return the current positions of wild animals
        // You need to implement the actual logic based on your simulation
        return null;
    }

    public syncronized void reportTrouble(int x, int y) {
        // Placeholder method for reporting trouble to the monitoring system
        monitoringSystem.reportTrouble(this, x, y);
    }

    public synchronized void registerWildAnimal(WildAnimal animal) {
        // Placeholder method for registering a wild animal with the zone
        wildAnimals.add(animal);
    }
}

*/

package WildLife;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonitoredZone {
    private int size; // N x N matrix size
    private List<WildAnimal> wildAnimals;
    private int[][] devastatedPlaces;
    private MonitoringSystem monitoringSystem; // Add MonitoringSystem reference

    public MonitoredZone(int size, MonitoringSystem monitoringSystem) {
        this.size = size;
        this.monitoringSystem = monitoringSystem; // Initialize MonitoringSystem reference
        this.wildAnimals = new ArrayList<>();
        this.devastatedPlaces = new int[size][size];
    }

    public void setMonitoringSystem(MonitoringSystem monitoringSystem) {
        this.monitoringSystem = monitoringSystem;
    }
    
    public MonitoredZone(int matrixSize) {
		// TODO Auto-generated constructor stub
	}

	public int getSize() {
        return size;
    }

    public List<WildAnimal> getWildAnimals() {
        return wildAnimals;
    }

    public int[][] getDevastatedPlaces() {
        return devastatedPlaces;
    }

    public synchronized void spawnWildAnimal() {
        Random rand = new Random();
        int x = rand.nextInt(size);
        int y = rand.nextInt(size);

        // Create a new WildAnimal and add it to the zone
        WildAnimal newAnimal = new WildAnimal(this, x, y);
        wildAnimals.add(newAnimal);

        // Inform authorities about the new animal
        System.out.println("New wild animal spawned at position (" + x + ", " + y + ")");
        monitoringSystem.addWildAnimal(newAnimal);
    }

    public synchronized void moveWildAnimals() {
        // Iterate through all wild animals and move them
        for (WildAnimal animal : wildAnimals) {
            animal.move();
        }
    }

    public synchronized void restWildAnimals() {
        // Iterate through all wild animals and make them rest if surrounded
        for (WildAnimal animal : wildAnimals) {
            animal.rest();
        }
    }

    public synchronized void simulateTimePassage() {
        // Placeholder logic for simulating time passage
        // This method may trigger periodic updates or activities in the zone
        System.out.println("Time is passing in the monitored zone...");
    }

    public synchronized void stopSimulation() {
        // Placeholder logic to stop the simulation
        // This method may involve interrupting threads and cleaning up resources
        System.out.println("Stopping the simulation in the monitored zone...");
    }

    public synchronized int getNumDevastatedPlaces() {
        // Placeholder logic to return the current number of devastated places
        // You need to implement the actual logic based on your simulation
        return 0;
    }

    public synchronized int[][] getAnimalPositions() {
        // Placeholder logic to return the current positions of wild animals
        // You need to implement the actual logic based on your simulation
        return null;
    }

    public synchronized void reportTrouble(int x, int y) {
        // Placeholder method for reporting trouble to the monitoring system
        monitoringSystem.reportTrouble(this, x, y);
    }

    public synchronized void registerWildAnimal(WildAnimal animal) {
        // Placeholder method for registering a wild animal with the zone
        wildAnimals.add(animal);
    }
}
