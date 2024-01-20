import application.UserInterface;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        UserInterface console = UserInterface.getSingleton_instance();
        try {
            console.deleteAllData();
            console.addTeam("Philipo","Plovdiv",new int[]{});
            console.addTeam("Stars","Sofia",new int[]{1,3});
            console.addTeam("Bulls","Kaspichan",new int[]{});
            console.addPlayer("Ivan",12,1);
            console.addPlayer("Petar",23,1);
            console.addPlayer("Georgi",45,1);
            console.addPlayer("Simeon",56,1);
            console.addPlayer("Boris",78,1);
            console.transferPlayerToTeam(2,3);
            console.startGame(2,1);
            console.startGame(1,2);
            console.startGame(3,2);
            console.startGame(3,1);
            console.endGame(1,2,1,2,3);
            console.endGame(1,2,2,4,17);
            console.endGame(3,2,3,0,0);
            console.endGame(3,1,4,5,1);
            console.viewAllTeams();
            console.viewAllPlayers();
            console.viewAllGames();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}