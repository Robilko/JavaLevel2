package Java_2_AdvancedLevel.lesson1;

public abstract class Equipment {
    protected float height;
    protected float distance;

    public boolean action(Jump member) {
        return member.jump(height);
    }

    public boolean action(Run member) {
        return member.run(distance);
    }
}
