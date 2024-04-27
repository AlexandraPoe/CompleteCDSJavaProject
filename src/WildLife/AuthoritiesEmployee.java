package WildLife;

import java.util.concurrent.Semaphore;

public class AuthoritiesEmployee extends Thread {
    private MonitoringSystem monitoringSystem;
    private Semaphore sampleSemaphore; // Semaphore for controlling access to monitoring information

    public AuthoritiesEmployee(MonitoringSystem monitoringSystem) {
        this.monitoringSystem = monitoringSystem;
        this.sampleSemaphore = new Semaphore(1); // Only one employee can collect samples at a time
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(getRandomDelay()); // Simulate random time delay
                collectSamples(); // Placeholder for collecting samples
            } catch (InterruptedException e) {
                System.err.println("Authorities Employee thread interrupted.");
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        }
    }

    // Placeholder method for simulating collecting samples
    public void collectSamples() {
        try {
            sampleSemaphore.acquire();
            // Access monitoring information and collect samples
            int numDevastatedPlaces = monitoringSystem.getNumDevastatedPlaces();
            int[][] animalPositions = monitoringSystem.getAnimalPositions();
            System.out.println("Employee collected samples. Devastated places: " + numDevastatedPlaces);
            // Perform other actions with collected samples
        } catch (InterruptedException e) {
            System.err.println("Error while collecting samples: " + e.getMessage());
        } finally {
            sampleSemaphore.release();
        }
    }

    // Placeholder method to get a random time delay
    private long getRandomDelay() {
        return (long) (Math.random() * 5000); // Adjust the range as needed
    }

    public void stopReading() {
        interrupt(); // Interrupt the thread to stop reading
    }
}

