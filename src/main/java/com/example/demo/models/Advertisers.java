package com.example.demo.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.*;




@Entity
@Table(name = "Advertisers")
public class Advertisers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @OneToMany(mappedBy = "Advertisers", cascade = CascadeType.PERSIST)
    // @ElementCollection(targetClass = Campaings.class, fetch = FetchType.EAGER)
    // @Enumerated(EnumType.STRING)
    // private Set<Campaings> campaings;
    private String title;
    @Column (columnDefinition = "TEXT")
    private String full_txt;
    @Column (columnDefinition = "boolean default false")
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

    public Advertisers() 
    {
    }
    
    public Advertisers(String title, String full_txt) {
        this.title = title;

        this.full_txt = full_txt;
    }

    public boolean getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(boolean flagDel) {
        this.flagDel = flagDel;
    }

    // public Set<Campaings> getCampaings() {
    //     return campaings;
    // }

    // public void setCampaings(Set<Campaings> campaings) {
    //     this.campaings = campaings;
    // }

}
