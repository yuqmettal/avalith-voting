package com.yuqmettal.voting.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("SELECT * from vote")
public class EmployeeVotesEntity {
    @Id
	Long id;
    private String username;
    private String name;
    private int votes;

    public EmployeeVotesEntity() {
    }

    public EmployeeVotesEntity(Long id, String username, String name, int votes) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.votes = votes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return this.votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public EmployeeVotesEntity username(String username) {
        this.username = username;
        return this;
    }

    public EmployeeVotesEntity name(String name) {
        this.name = name;
        return this;
    }

    public EmployeeVotesEntity votes(int votes) {
        this.votes = votes;
        return this;
    }

}