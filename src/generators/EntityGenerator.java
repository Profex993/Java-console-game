package generators;

import entity.*;

import java.util.Random;

public class EntityGenerator {
    private static final Random rnd = new Random();
    public static Enemy generateEntity() {
        return new Enemy(rnd.nextInt(91) + 10);
    }
}
