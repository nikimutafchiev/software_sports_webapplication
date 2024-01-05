package application;
class InvalidParameterException extends Exception{
    InvalidParameterException(String message){
        super(message);
    }
}
public class UserInterface {
    private int num_games;
    private int num_players;
    private int num_teams;
    private static UserInterface singleton_instance = null;

    private UserInterface(){
        num_games = 0;
        num_players = 0;
        num_teams = 0;
    }

    public static UserInterface getSingleton_instance(){
        if(singleton_instance == null)
            singleton_instance = new UserInterface();
        return singleton_instance;
    }
    public int startGame(int team1id, int team2id) throws InvalidParameterException{
        if(team1id< 0 || team1id>num_teams || team2id< 0 || team2id > num_teams)
            throw new InvalidParameterException("Invalid team id");
        //TODO
        int generated_id = 0; //will return the id in the database
        return generated_id;
    }
    public void endGame(int gameId, int score) throws InvalidParameterException{
        if(score < 0 )
            throw new InvalidParameterException("Invalid score");
        if(gameId < 0 || gameId > num_games)
            throw new InvalidParameterException("Invalid game id");
        //TODO
    }
    public int addTeam(String name, int[] players){
        //TODO
        int generated_id = 0; //will return the id in the database
        return generated_id;
    }
    public int addPlayer(String name, int jerseyNumber){
        //TODO
        int generated_id = 0; //will return the id in the database
        return generated_id;
    }
    public void addPlayerToTeam(int playerId, int teamId) throws InvalidParameterException{
        if(playerId< 0 || playerId > num_players)
            throw new InvalidParameterException("Invalid player id");
        if (teamId< 0 || teamId > num_teams)
            throw new InvalidParameterException("Invalid team id");
        //TODO
    }
}
