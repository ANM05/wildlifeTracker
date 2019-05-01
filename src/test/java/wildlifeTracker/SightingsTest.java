package wildlifeTracker;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.Timestamp;

public class SightingsTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();
    @Test
    public void Sightings_instantiatesCorrectly_true(){
    Sightings testSighting = new Sightings("area 1", "Vick",1);
    assertEquals(testSighting instanceof Sightings, true);
    }
    @Test
    public void getLocation_instantiatesWithLocation_String(){
    Sightings testSighting = new Sightings("area 1", "Vick",1);
    assertEquals("area 1", testSighting.getLocation());
    }
    @Test
    public void getLocation_instantiatesWithRangerName_String() {
        Sightings testSighting = new Sightings("area 1", "Vick", 1);
        assertEquals("Vick", testSighting.getRangerName());
    }
    @Test
    public void getLocation_instantiatesWithAnimalId_int() {
        Sightings testSighting = new Sightings("area 1", "Vick", 1);
        assertEquals(1, testSighting.getAnimalId());
    }
    @Test
    public void equals_returnsTrueIfSightingsObjectsAreTrue_true(){

    }
    @Test
    public void save_savesSightingsObjectsIntoDatabase(){
        Sightings testSighting = new Sightings("area 1", "Vick", 1);
        testSighting.save();
        assertEquals(true, Sightings.all().get(0).equals(testSighting));
    }
    @Test
    public void all_returnsAllObjectsOfSightingsClass_true(){
        Sightings firstSighting = new Sightings("area 1", "Vick",1);
        firstSighting.save();
        Sightings secondSighting = new Sightings("area 1", "Vick",1);
        secondSighting.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSighting));
        assertEquals(true, Sightings.all().get(1).equals(secondSighting));
    }
}
