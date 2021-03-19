package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Advertisers;
import com.example.demo.models.Campaings;
import com.example.demo.service.AdvertisersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
//@CrossOrigin(origins = "*")
public class AdvertisersRestController 
{
    @Autowired
    private AdvertisersService advertisersService;

    @GetMapping("/api/advertisersList")
    public ResponseEntity<Map<String, Object>> getAdvertisersList(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "2") int size
        )
    {
        List<Advertisers> advertisersList = new ArrayList<Advertisers>();
        Pageable paging = PageRequest.of(page, size);
        Page<Advertisers> advertisersPage = advertisersService.getAdvertisersList(paging);
        advertisersList = advertisersPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("advertisers", advertisersList);
        response.put("currentPage", advertisersPage.getNumber());
        response.put("totalItems", advertisersPage.getTotalElements());
        response.put("totalPages", advertisersPage.getTotalPages());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    
    @GetMapping("/api/advertisers/{id}")
    public ResponseEntity<Advertisers> getAdvertisers(@PathVariable Long id)
    {
        return new ResponseEntity<Advertisers>(advertisersService.getAdvertisers(id), HttpStatus.OK);
    }

//    @PostMapping("/api/advertisers")
//    public ResponseEntity<Void> AddPost(@RequestBody Advertisers advertisers)
//    {
//        advertisersService.saveAdvertisers(advertisers);
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }

    @PostMapping("/api/advertisers")
    public ResponseEntity<Void> AddPost( @RequestBody String json) { ObjectMapper mapper = new ObjectMapper();
   

      try {   
          
          Map<String, String>  requestParams  = mapper.readValue(json, new TypeReference<Map<String,String>>(){});
          Advertisers  advertisers  = new Advertisers();
          advertisersService.saveAdvertisers(advertisers);
    
    
      }
      catch (JsonMappingException e) {
                } 
      catch (JsonProcessingException e) {

        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/api/advertisers")
    public ResponseEntity<Void> UpdatePost(@RequestBody Advertisers advertisers)
    {
        advertisersService.saveAdvertisers(advertisers);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/api/advertisers/{id}")
    public ResponseEntity<Void> delAdver(@PathVariable Long id)
    {
        advertisersService.delAdver(id);   
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
