package com.example.demo.models;


import java.util.Set;

import javax.persistence.*;

import com.example.demo.role.User;




@Entity
@Table(name = "Advertisers")
public class Advertisers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//   @OneToMany(fetch = FetchType.LAZY, mappedBy = "advertisers", cascade = CascadeType.REMOVE)
//     private Set<Campaings> campaings;
  
  
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST,
          fetch = FetchType.EAGER)
         @JoinColumn(name = "id_user", foreignKey =
         @ForeignKey(name = "fk_Advertisers_users"))
  
  private User user;
    private String title;
    @Column (columnDefinition = "TEXT")
    private String full_txt;
    @Column (columnDefinition = "boolean default false")
    private boolean flagDel;
    private String countries;
    private String age;
    private String languages;
    private String Url;
    

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
    
    public Advertisers(String title, String full_txt, String countries, String age, String languages, String Url) 
    {
        this.title = title;
        this.countries = countries;
        this.full_txt = full_txt;
        this.age = age;
        this.languages = languages;
        this.Url = Url;
    }

    public boolean getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(boolean flagDel) {
        this.flagDel = flagDel;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
