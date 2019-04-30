package wildlifeTracker;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class NonEndangeredTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();
    @Test
    public void NonEndangered_instantiatesCorrectly_true(){
        NonEndangered testanimal = new NonEndangered("bees");
        assertEquals(testanimal instanceof NonEndangered, true);
    }
    
}
