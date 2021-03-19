package com.example.demo.repo;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Advertisers;
import com.example.demo.models.Campaings;

public interface CampaingsRepository extends CrudRepository<Campaings, Long>
{
        Page<Campaings> findByFlagDel(Boolean flagDel, Pageable pageable);
        Page<Campaings> findByFlagDelAndAdvertisersId(Boolean flagDel, Long id,  Pageable pageable);
}
