import application.UserInterface;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        UserInterface console = UserInterface.getSingleton_instance();

    }
}