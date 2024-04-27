package WildLife;

public class Main {
    public static void main(String[] args) {
        // Create and initialize the headquarters
        Headquarter headquarters = new Headquarter();
        headquarters.createZones(3); // Change the number of zones as needed
        headquarters.createWildAnimals();
        headquarters.createMonitoringSystem();
        headquarters.createAuthoritiesEmployees(5); // Change the number of employees as needed
        headquarters.createLaboratoryManager();

        // Start the simulation
        headquarters.startSimulation();

        // Simulate the passage of time for a certain duration (e.g., 10 seconds)
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Error during simulation: " + e.getMessage());
        }

        // Stop the simulation
        headquarters.stopSimulation();
    }
}

