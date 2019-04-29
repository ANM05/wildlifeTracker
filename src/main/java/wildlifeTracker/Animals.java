package wildlifeTracker;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class Animals {
    public int id;
    public String name;
    public String type;

    public Animals(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getType(){
        return type;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animals)){
            return false;
        }
        else{
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getType().equals(newAnimal.getType());
        }
    }
    public void save(){
        if (name.equals("")) {
            throw new IllegalArgumentException("Please enter a name.");
        }
        try(Connection connect = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type);";
            this.id = (int) connect.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
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
    public static Animals find(int id){
        try(Connection connect = DB.sql2o.open()){
            String sql = "SELECT * FROM animals WHERE id = :id;";
            Animals animal = connect.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animals.class);
                    return animal;
        }
    }
}
