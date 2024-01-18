package application;
import java.sql.*;

abstract class Player {
    int id;
    String name;
    int jersey_number;
    int team_id;
    static int addPlayer(String name, int jerseyNumber, int team_id){
        return PostGreSQLQuery.insert("Player",new String[]{"name","jersey_number","team_id"},new String[]{String.format("\'%s\'",name),String.valueOf(jerseyNumber),String.valueOf(team_id)});
    }
}
