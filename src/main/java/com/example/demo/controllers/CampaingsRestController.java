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

import com.example.demo.models.Campaings;
import com.example.demo.service.AdvertisersService;
import com.example.demo.service.CampaingsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
//@CrossOrigin(origins = "*")
public class CampaingsRestController 
{
    @Autowired
    private CampaingsService campaingsService;

    private AdvertisersService advertisersService;
    @GetMapping("/api/campaingsList")
    public ResponseEntity<Map<String, Object>> getCampaingsList(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "2") int size
        )
    {
        List<Campaings> campaingsList = new ArrayList<Campaings>();
        Pageable paging = PageRequest.of(page, size);
        Page<Campaings> campaingsPage = campaingsService.getCampaingsList(paging);
        campaingsList = campaingsPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("campaings", campaingsList);
        response.put("currentPage", campaingsPage.getNumber());
        response.put("totalItems", campaingsPage.getTotalElements());
        response.put("totalPages", campaingsPage.getTotalPages());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    @GetMapping("/api/campaingsList/{id}")
    public ResponseEntity<Map<String, Object>> getCampaingsList1(
        @PathVariable Long id, 
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "2") int size
        )
    {
        List<Campaings> campaingsList = new ArrayList<Campaings>();
        Pageable paging = PageRequest.of(page, size);
        Page<Campaings> campaingsPage = campaingsService.getCampaingsListbyIdAdv(id, paging);
        campaingsList = campaingsPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("campaings", campaingsList);
        response.put("currentPage", campaingsPage.getNumber());
        response.put("totalItems", campaingsPage.getTotalElements());
        response.put("totalPages", campaingsPage.getTotalPages());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/api/campaings/{id}")
    public ResponseEntity<Campaings> getCampaings(@PathVariable Long id)
    {
        return new ResponseEntity<Campaings>(campaingsService.getCampaings(id), HttpStatus.OK);
    }
//    @PostMapping("/api/campaings")
//    public ResponseEntity<Void> AddPost(@RequestBody Campaings campaings)
//    {
//        campaingsService.saveCampaings(campaings);
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
//    
    @PostMapping("/api/campaings")
    public ResponseEntity<Void> AddPost( @RequestBody String json) { ObjectMapper mapper = new ObjectMapper();

      try {   
          
          Map<String, String>  requestParams  = mapper.readValue(json, new TypeReference<Map<String,String>>(){});
          Campaings  campaings  = new Campaings();
          campaings.setTitle(requestParams.get("title"));
          
          campaings.setAdvertisers(advertisersService.getAdvertisers(Long.parseLong(requestParams.get("id_advertisers"))));
          campaingsService.saveCampaings(campaings);
    
      }
      catch (JsonMappingException e) {
                } 
      catch (JsonProcessingException e) {

        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/api/campaings")
    public ResponseEntity<Void> UpdatePost(@RequestBody Campaings campaings)
    {
        campaingsService.saveCampaings(campaings);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/api/campaings/{id}")
    public ResponseEntity<Void> delAdver(@PathVariable Long id)
    {
        campaingsService.delAdver(id);   
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    
}
