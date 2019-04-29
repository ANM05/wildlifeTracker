package wildlifeTracker;

public class Endangered extends Animals{
    private String health;
    private String age;

    public static final String HEALTHY = "healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "okay";

    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";
    
    public Endangered(String name, String type, String health, String age) {
        super(name, type);
        this.health = health;
        this.age = age;
    }
}
