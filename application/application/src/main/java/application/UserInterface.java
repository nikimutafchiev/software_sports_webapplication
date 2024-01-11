package application;

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
        if(singleton_instance == null) {
            singleton_instance = new UserInterface();
            System.out.println("Interface created successfully");
        }
        return singleton_instance;
    }
    public int startGame(int team1id, int team2id) throws InvalidParameterException{
        if(team1id< 0 || team1id>num_teams || team2id< 0 || team2id > num_teams)
            throw new InvalidParameterException("Invalid team id");
        num_games++;
        return Game.addGame(team1id,team2id);
    }
    public void endGame(int gameId, int score) throws InvalidParameterException{
        if(score < 0 )
            throw new InvalidParameterException("Invalid score");
        if(gameId < 0 || gameId > num_games)
            throw new InvalidParameterException("Invalid game id");
        Game.scoreGame(gameId, score);
    }
    public int addTeam(String name, String city, int[] players) throws InvalidParameterException{
        num_teams++;
        int team_id = Team.addTeam(name,city);
        for(int player_id:players){
            addPlayerToTeam(player_id,team_id);
        }
        return team_id;
    }
    public int addPlayer(String name, int jerseyNumber){
        num_players++;
        return Player.addPlayer(name,jerseyNumber);
    }
    public void addPlayerToTeam(int playerId, int teamId) throws InvalidParameterException{
        if(playerId< 0 || playerId > num_players)
            throw new InvalidParameterException("Invalid player id");
        if(teamId< 0 || teamId > num_teams)
            throw new InvalidParameterException("Invalid team id");
        Team.addPlayer(playerId, teamId);
    }
}
