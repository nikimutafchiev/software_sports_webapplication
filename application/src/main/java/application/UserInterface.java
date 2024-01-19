package application;

public class UserInterface {
    private static UserInterface singleton_instance = null;

    private UserInterface(){
    }

    public static UserInterface getSingleton_instance(){
        if(singleton_instance == null) {
            singleton_instance = new UserInterface();
            System.out.println("Interface created successfully");
        }
        return singleton_instance;
    }
    public int startGame(int team1id, int team2id) throws InvalidParameterException{
        if(team1id< 0  || team2id< 0)
            throw new InvalidParameterException("Invalid team id");
        return Game.addGame(team1id,team2id);
    }
    public void endGame(int team1_id, int team2_id,int gameId, int score1,int score2) throws InvalidParameterException{
        if(score1 < 0 || score2 < 0)
            throw new InvalidParameterException("Invalid score");
        if(gameId < 0)
            throw new InvalidParameterException("Invalid game id");
        if(team1_id < 0 || team2_id < 0)
            throw new InvalidParameterException("Invalid team id");
        Game.scoreGame(team1_id,gameId, score1);
        Game.scoreGame(team2_id,gameId, score2);
    }
    public int addTeam(String name, String city, int[] players) throws InvalidParameterException{
        int team_id = Team.addTeam(name,city);
        for(int player_id:players){
            transferPlayerToTeam(player_id,team_id);
        }
        return 0;
    }
    public int addPlayer(String name, int jerseyNumber, int team_id){
        return Player.addPlayer(name,jerseyNumber,team_id);
    }
    public void transferPlayerToTeam(int playerId, int teamId) throws InvalidParameterException{
        if(playerId < 0 )
            throw new InvalidParameterException("Invalid player id");
        if(teamId < 0)
            throw new InvalidParameterException("Invalid team id");
        Player.updatePlayer(playerId, teamId);
    }
    public void viewAllTeams(){
        Team.viewAllTeams();
    }
    public void viewAllPlayers(){
        Player.viewAllPlayers();
    }

    public void viewAllGamesByTeam(int team_id){
        Game.viewAllGamesByTeam(team_id);
    }
    public void deleteAllData(){
        Player.emptyPlayers();
        Team.emptyTeams();
        Game.emptyGames();
    }
}
