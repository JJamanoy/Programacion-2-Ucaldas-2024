package com.taller.taller.domain;

import lombok.Data;

@Data
public class Programa {
    private Long id;
    private String level_study;
    private String name;
    private Integer credits;
    private Boolean status;

    public Programa(){}

    public Long getId(){
        return id;
    }
    public String getLevel_study(){
        return level_study;
    }
    public String getName(){
        return name;
    }
    public Integer getCredits(){
        return credits;
    }
    public Boolean getStatus(){
        return status;
    }

    public void setLevel_study(String level_study){
        this.level_study=level_study;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setCredits(Integer credits){
        this.credits=credits;
    }
    public void setStatus(Boolean status){
        this.status=status;
    }
}
