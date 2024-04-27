package WildLife;

public class WildAnimal extends Thread {
    private MonitoredZone zone;
    private int x, y; // Animal's position

    public WildAnimal(MonitoredZone zone) {
        this.zone = zone;
        // Randomly assign initial position
        this.x = (int) (Math.random() * zone.getSize());
        this.y = (int) (Math.random() * zone.getSize());
    }

    public WildAnimal(MonitoredZone monitoredZone, int x, int y) {
        this.zone = monitoredZone;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            move();
            System.out.println("Animal at position (" + getX() + ", " + getY() + ") moved.");
            produceTrouble();
            System.out.println("Animal at position (" + getX() + ", " + getY() + ") produced trouble.");
            rest();
            System.out.println("Animal at position (" + getX() + ", " + getY() + ") is resting.");
        }
    }


    public synchronized void move() {
        // Animal movement logic
        // Placeholder: Move in a random direction within the zone
        int direction = (int) (Math.random() * 4); // 0: left, 1: right, 2: up, 3: down

        switch (direction) {
            case 0:
                x = (x > 0) ? x - 1 : x;
                break;
            case 1:
                x = (x < zone.getSize() - 1) ? x + 1 : x;
                break;
            case 2:
                y = (y > 0) ? y - 1 : y;
                break;
            case 3:
                y = (y < zone.getSize() - 1) ? y + 1 : y;
                break;
        }
    }

    public synchronized void produceTrouble() {
        // Trouble production logic
        // Placeholder: Inform the monitoring system about the trouble produced
        zone.reportTrouble(x, y);
        try {
            Thread.sleep(30); // Resting time after trouble production
        } catch (InterruptedException e) {
            System.err.println("Error during resting: " + e.getMessage());
            Thread.currentThread().interrupt(); // Preserve interrupted status
        }
    }

    public synchronized void rest() {
        // Resting logic
        // Placeholder: Rest for a random time between 10 and 50 milliseconds
        int restingTime = (int) (Math.random() * 41) + 10;
        try {
            Thread.sleep(restingTime);
        } catch (InterruptedException e) {
            System.err.println("Error during resting: " + e.getMessage());
            Thread.currentThread().interrupt(); // Preserve interrupted status
        }
    }

    public synchronized void setZone(MonitoredZone randomZone) {
        this.zone = randomZone;
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized int getY() {
        return y;
    }

    public synchronized MonitoredZone getZone() {
        return zone;
    }
}

