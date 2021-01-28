package Java_2_AdvancedLevel.lesson1;

public class Robot implements Run, Jump {
    private final String NAME;
    private final float RUN_LIMIT;
    private final float JUMP_LIMIT;
    private static int count;

    public Robot() {
        NAME = "Робот №" + (++count);
        RUN_LIMIT = (float) (1000 + Math.random() * 5000);
        JUMP_LIMIT = (float) (0.5 + Math.random() * 2);
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
