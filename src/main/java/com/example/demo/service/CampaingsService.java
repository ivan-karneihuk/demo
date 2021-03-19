package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.Campaings;
import com.example.demo.repo.CampaingsRepository;

@Service
public class CampaingsService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    CampaingsRepository campaingsRepository;

    public void saveCampaings(Campaings campaings) {
        campaingsRepository.save(campaings);
    }

    public List<Campaings> getCampaingsListAll() {

        return (List<Campaings>) campaingsRepository.findAll();
    }

    public Page<Campaings> getCampaingsList(Pageable pageable) {
        
        return (Page<Campaings>) campaingsRepository.findByFlagDel(false, pageable);
    }
     public Page<Campaings> getCampaingsListbyIdAdv(Long id, Pageable pageable) {
        
        return (Page<Campaings>) campaingsRepository.findByFlagDelAndAdvertisersId(false, id, pageable);
    }
    
    public Campaings getCampaings(Long id)
    {
        return campaingsRepository.findById(id).get();
    }

    public void delAdver(Long id)
    {
        Campaings campaingsDel = campaingsRepository.findById(id).get();
        campaingsDel.setFlagDel(true);
        campaingsRepository.save(campaingsDel);
    }

    public void delAdver(Campaings campaingsDel)
    {
        campaingsDel.setFlagDel(true);
        campaingsRepository.save(campaingsDel);
    }
}
