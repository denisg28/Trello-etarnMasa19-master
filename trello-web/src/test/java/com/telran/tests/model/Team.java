package com.telran.tests.model;

public class Team {
    private  String teamName;
    private  String description;



    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString()
    {
        return "Team" + "teamName=" + teamName + "/"+",description="+ description+"/" ;


    }

}
