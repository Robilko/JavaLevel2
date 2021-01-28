package Java_2_AdvancedLevel.lesson1;

public interface Jump {
    default boolean jump(float limit){
        return false;
    }
}
