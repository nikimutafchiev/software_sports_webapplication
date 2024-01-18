package application;

abstract class Team {
    static int addTeam(String name, String city){
       return PostGreSQLQuery.insert("Team",new String[]{"name","city"},new String[]{String.format("'%s'",name),String.format("'%s'",city)});
    }
    static void emptyTeams(){
        PostGreSQLQuery.truncate("Team");
    }
}
