package Java_2_AdvancedLevel.lesson1;

public class Wall extends Equipment{

    public Wall() {
        this.height = (float) (0.2 + Math.random() * 1);
    }
}
