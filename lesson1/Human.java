package Java_2_AdvancedLevel.lesson1;

public class Human implements Run, Jump {
    private final String NAME;
    private final float RUN_LIMIT;
    private final float JUMP_LIMIT;
    private static int count;

    public Human() {
        NAME = "Человек №" + (++count);
        RUN_LIMIT = (float) (500 + Math.random() * 2000);
        JUMP_LIMIT = (float) (0.2 + Math.random() * 1);
    }

    @Override
    public boolean jump(float limit) {
        System.out.println(NAME + " прыгнул на " + String.format("%.2f", JUMP_LIMIT) + " единиц");
        return (limit < JUMP_LIMIT);
    }

    @Override
    public boolean run(float limit) {
        System.out.println(NAME + " пробежал " + String.format("%.2f", RUN_LIMIT) + " единиц");
        return (limit < RUN_LIMIT);
    }
}
