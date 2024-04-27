package WildLife;

import java.util.ArrayList;
import java.util.List;

public class Headquarter {
    private List<MonitoredZone> zones;
    private List<WildAnimal> wildAnimals;
    private MonitoringSystem monitoringSystem;
    private List<AuthoritiesEmployee> authoritiesEmployees;
    private LaboratoryManager laboratoryManager;

    public Headquarter() {
        this.zones = new ArrayList<>();
        this.wildAnimals = new ArrayList<>();
        this.monitoringSystem = new MonitoringSystem();
        this.authoritiesEmployees = new ArrayList<>();
        this.laboratoryManager = new LaboratoryManager(6789); // Replace 6789 with the desired port
    }

    public void createZones(int numberOfZones) {
        // Create and initialize zones with random matrix sizes
        for (int i = 0; i < numberOfZones; i++) {
            int matrixSize = (int) (Math.random() * 401) + 100; // Random size between 100 and 500
            MonitoredZone zone = new MonitoredZone(matrixSize, monitoringSystem); // Pass monitoringSystem
            zones.add(zone);
            monitoringSystem.addMonitoredZone(zone); // Add the zone to monitoringSystem
        }
    }


    public void createWildAnimals() {
        // Create and initialize wild animals
        for (MonitoredZone zone : zones) {
            int numberOfAnimals = (int) (Math.random() * (zone.getSize() / 2)) + 1; // Random number of animals
            for (int i = 0; i < numberOfAnimals; i++) {
                WildAnimal animal = new WildAnimal(zone);
                wildAnimals.add(animal);
                monitoringSystem.addWildAnimal(animal);
            }
        }
    }

    public void assignWildAnimalsToZones() {
        // Assign wild animals to random zones
        for (WildAnimal animal : wildAnimals) {
            MonitoredZone randomZone = zones.get((int) (Math.random() * zones.size()));
            animal.setZone(randomZone);
            randomZone.registerWildAnimal(animal);
            // Ensure the monitoringSystem is set for the zone
            randomZone.setMonitoringSystem(monitoringSystem);
        }
    }


    public void createAuthoritiesEmployees(int numberOfEmployees) {
        // Create and initialize authorities' employees
        for (int i = 0; i < numberOfEmployees; i++) {
            AuthoritiesEmployee employee = new AuthoritiesEmployee(monitoringSystem);
            authoritiesEmployees.add(employee);
        }
    }

    public void startSimulation() {
        // Start the simulation by starting threads for wild animals and authorities' employees
        for (WildAnimal animal : wildAnimals) {
            animal.start();
        }

        for (AuthoritiesEmployee employee : authoritiesEmployees) {
            new Thread(employee).start();
        }

        new Thread(laboratoryManager::startListening).start();
    }

    public void stopSimulation() {
        // Stop the simulation by stopping threads and cleaning up resources
        for (WildAnimal animal : wildAnimals) {
            animal.interrupt();
        }

        for (AuthoritiesEmployee employee : authoritiesEmployees) {
            employee.stopReading();
        }

        laboratoryManager.stopListening();
    }

    public void createMonitoringSystem() {
        // TODO: You may want to implement this method if needed
    }

    public void createLaboratoryManager() {
        // TODO: You may want to implement this method if needed
    }
}
