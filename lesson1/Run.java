package Java_2_AdvancedLevel.lesson1;

public interface Run {
    default boolean run(float limit) {
        return false;
    }
}
