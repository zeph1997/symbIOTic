package com.example.testwear;

public class Team {

    public String getTeamName() {return teamName;}

    public void setTeamName(String teamName) {this.teamName = teamName;}

    public String getTeamLeader() {return teamLeader;}

    public void setTeamLeader(String teamLeader) {this.teamLeader = teamLeader;}

    public String getNoMembers() {return memberCount;}

    public void setNoMembers(String memberCount) {this.memberCount = memberCount;}

    private String teamName;
    private String teamLeader;
    private String memberCount;

    public Team(String teamName, String teamLeader, String memberCount){
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        this.memberCount = memberCount;
    }
}
