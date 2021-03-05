package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;




@Entity
@Table(name = "Campaings")
public class Campaings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @ManyToOne(cascade = CascadeType.PERSIST)
    // @ElementCollection(targetClass = Advertisers.class, fetch = FetchType.EAGER)
    // @CollectionTable(name = "idAdver", joinColumns = @JoinColumn(name = "fkIdAdver"))
    // @Enumerated(EnumType.STRING)
    // private Advertisers advertisers;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String full_txt;
    @Column(columnDefinition = "boolean default false")
    private boolean flagDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFull_txt() {
        return full_txt;
    }

    public void setFull_txt(String full_txt) {
        this.full_txt = full_txt;
    }

    public Campaings() {
    }

    public Campaings(String title, String full_txt) {
        this.title = title;

        this.full_txt = full_txt;
    }

    public boolean getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(boolean flagDel) {
        this.flagDel = flagDel;
    }

    // public Advertisers getAdvertisers() {
    //     return advertisers;
    // }

    // public void setAdvertisers(Advertisers advertisers) {
    //     this.advertisers = advertisers;
    // }

}
