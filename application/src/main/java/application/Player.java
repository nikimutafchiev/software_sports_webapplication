package application;
import java.sql.*;

abstract class Player {
    static int addPlayer(String name, int jerseyNumber, int team_id){
        return PostGreSQLQuery.insert("Player",new String[]{"name","jersey_number","team_id"},new String[]{String.format("'%s'",name),String.valueOf(jerseyNumber),String.valueOf(team_id)});
    }
    static void updatePlayer(int player_id, int team_id){
        PostGreSQLQuery.update("Player",new String[]{String.format("team_id = %d",team_id)},new String[]{String.format("id = %d",player_id)});
    }
    static void emptyPlayers(){
        PostGreSQLQuery.truncate("Player");
    }
    static void viewAllPlayers(){
        String[] res = PostGreSQLQuery.select_left_join("Player",new String[]{"Team"},new String[]{"Team.id = Player.team_id"},new String[]{"Player.name","Player.jersey_number", "Team.name", "Team.city"}, new String[]{"true"});
        for(String row: res){
            System.out.println(row);
        }
    }
}
