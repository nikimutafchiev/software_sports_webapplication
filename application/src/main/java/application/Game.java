package application;

class Game {
    static int addGame(int team1id, int team2id){
        int id = PostGreSQLQuery.insert("Game",new String[]{"status"},new String[]{"false"});
        PostGreSQLQuery.insert("TeamGame",new String[]{"team_id","game_id","score"},new String[]{String.valueOf(team1id),String.valueOf(id),"0"});
        PostGreSQLQuery.insert("TeamGame",new String[]{"team_id","game_id","score"},new String[]{String.valueOf(team2id),String.valueOf(id),"0"});
        return id;
    }
    static void scoreGame(int team_id, int gameId, int score){
        PostGreSQLQuery.update("TeamGame",new String[]{String.format("score=%d",score)},new String[]{String.format("team_id = %d",team_id),String.format("game_id = %d",gameId)});
        PostGreSQLQuery.update("Game", new String[]{"status = true"}, new String[]{String.format("id = %s",gameId)});
    }
    static void emptyGames(){
        PostGreSQLQuery.truncate("Game");
    }

    static void viewAllGamesByTeam(int team_id){
        String[] res = PostGreSQLQuery.select_left_join("Game",new String[]{"TeamGame","Team"},new String[]{"Game.id = TeamGame.game_id","Team.id = TeamGame.team_id"},new String[]{"Game.id","Team.name", "Team.city","TeamGame.Score"}, new String[]{String.format("Team.id = %s",team_id)});
        for(String row: res) {
            System.out.println(row);
        }
    }
}
