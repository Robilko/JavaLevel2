package Java_2_AdvancedLevel.lesson7.Server;

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}