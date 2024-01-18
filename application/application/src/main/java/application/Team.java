package application;

abstract class Team {
    static int addTeam(String name, String city){
       return PostGreSQLQuery.insert("Team",new String[]{"name","city"},new String[]{name,city});
    }
}
