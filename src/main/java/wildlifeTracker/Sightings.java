package wildlifeTracker;

import java.sql.Timestamp;

public class Sightings {
    private String location;
    private String rangerName;
    private Timestamp spotted;
    private int animalId;
    private int id;

    public Sightings(String location, String ranger_name, int animal_id) {
        this.location = location;
        this.rangerName = ranger_name;
        this.animalId = animal_id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Timestamp getSpotted() {
        return spotted;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }
}
