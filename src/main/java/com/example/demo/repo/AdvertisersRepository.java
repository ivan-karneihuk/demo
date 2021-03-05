package com.example.demo.repo;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Advertisers;

public interface AdvertisersRepository extends CrudRepository<Advertisers, Long>
{
        Page<Advertisers> findByFlagDel(Boolean flagDel, Pageable pageable);
}
