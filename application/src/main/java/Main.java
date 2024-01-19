import application.UserInterface;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        UserInterface console = UserInterface.getSingleton_instance();
        try {
            console.deleteAllData();
            console.addTeam("Botev","Plovdiv",new int[]{});
            console.addPlayer("Ivan",12,1);
            console.addPlayer("Petar",23,1);
            console.addPlayer("Georgi",45,1);
            console.addPlayer("Simeon",56,1);
            console.addPlayer("Boris",78,1);
            console.addTeam("Litex","Sofia",new int[]{1,3});
            console.startGame(1,2);
            console.endGame(1,2,1,2,3);
            console.viewAllTeams();
            console.viewAllPlayers();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}