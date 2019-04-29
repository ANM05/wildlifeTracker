package wildlifeTracker;

import org.junit.*;
import static org.junit.Assert.*;

public class AnimalsTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();

    @Test
    public void animals_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals("Lion", "yes");
        assertEquals(true, testAnimal instanceof Animals);
    }
    @Test
    public void Animals_instantiatesWithName_String() {
        Animals testAnimal = new Animals("Lion", "yes");
        assertEquals("Lion", testAnimal.getName());
    }
    @Test
    public void Animals_instantiatesWithType_true(){
        Animals testAnimal = new Animals("Lion", "yes");
        assertEquals("yes", testAnimal.getType());
    }
    @Test
    public void equals_returnsTrueIfNamesAreEqual_true(){
        Animals firstAnimal = new Animals("Lion", "yes");
        Animals secondAnimal = new Animals("Lion", "yes");
        assertTrue(firstAnimal.equals(secondAnimal));
    }
    @Test
    public void save_insertObjectsIntoDatabase_Animals(){
        Animals testAnimal = new Animals("Lion", "yes");
        testAnimal.save();
        assertTrue(Animals.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfAnimals_true(){
        Animals firstAnimal = new Animals("Lion", "yes");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Snake", "yes");
        secondAnimal.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimal));
        assertEquals(true, Animals.all().get(1).equals(secondAnimal));
    }
    @Test
    public void find_returnsObjectWithTheSpecifiedId_firstAnimal(){
        Animals firstAnimal = new Animals("Lion", "yes");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Snake", "yes");
        secondAnimal.save();
        assertEquals(Animals.find(firstAnimal.getId()), firstAnimal);
    }
}
