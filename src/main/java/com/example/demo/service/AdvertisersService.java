package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.Advertisers;
import com.example.demo.repo.AdvertisersRepository;

@Service
public class AdvertisersService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    AdvertisersRepository advertisersRepository;

    public void saveAdvertisers(Advertisers advertisers) {
        advertisersRepository.save(advertisers);
    }

    public List<Advertisers> getAdvertisersListAll() {

        return (List<Advertisers>) advertisersRepository.findAll();
    }

    public Page<Advertisers> getAdvertisersList(Pageable pageable) {
        
        return (Page<Advertisers>) advertisersRepository.findByFlagDel(false, pageable);
    }

    public Advertisers getAdvertisers(Long id)
    {
        return advertisersRepository.findById(id).get();
    }

    public void delAdver(Long id)
    {
        Advertisers advertisersDel = advertisersRepository.findById(id).get();
        advertisersDel.setFlagDel(true);
        advertisersRepository.save(advertisersDel);
    }

    public void delAdver(Advertisers advertisersDel)
    {
        advertisersDel.setFlagDel(true);
        advertisersRepository.save(advertisersDel);
    }
}
