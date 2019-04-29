package wildlifeTracker;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class Animals {
    private int id;
    private String name;

    public Animals(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animals)){
            return false;
        }
        else{
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }
    public void save(){
        try(Connection connect = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name) VALUES (:name);";
            this.id = (int) connect.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Animals> all(){
        String sql = "SELECT * FROM animals;";
        try(Connection connect= DB.sql2o.open()){
            return connect.createQuery(sql).executeAndFetch(Animals.class);
        }
    }
}
