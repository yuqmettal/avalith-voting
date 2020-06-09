package com.yuqmettal.voting.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VotedArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Area area;
    
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Employee voter;

    private int year;

    private int month;
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Employee getVoter() {
        return this.voter;
    }

    public void setVoter(Employee voter) {
        this.voter = voter;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public VotedArea(Area area, Employee voter, int year, int month) {
        this.area = area;
        this.voter = voter;
        this.year = year;
        this.month = month;
    }

}