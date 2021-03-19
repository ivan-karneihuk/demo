package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.models.Campaings;
import com.example.demo.repo.CampaingsRepository;



@Controller
@PreAuthorize("hasAuthority('Admin')")
public class CampaingsController 
{
  @Autowired
  private  CampaingsRepository campaingsRepository ;

    @GetMapping("/campaings")
    public String Campaings(Model model)
    {
      // Iterable<Advertisers> advertisers = advertisersRepository.findAll();
      // model.addAttribute("advertisers", advertisers); 
		  return "campaings";   
    }

    @GetMapping("/campaings/id{id}")
    public String newsDetails(@PathVariable(value = "id") long id, Model model)
    {
      if(!campaingsRepository.existsById(id))
      {
        return "redirect:/campaings";
      }
      Optional<Campaings> advertisers = campaingsRepository.findById(id);
      ArrayList <Campaings> res = new ArrayList<>();
      advertisers.ifPresent(res::add);
      model.addAttribute("advertisers", res);
		  return "campaings-details";    
    }

    @GetMapping("/campaings/{id}/edit")
    public String advertisersEdit(@PathVariable(value = "id") long id, Model model)
    {
      if(!campaingsRepository.existsById(id))
      {
        return "redirect:/advertisers";
      }
      Optional<Campaings> poadvertisersst = campaingsRepository.findById(id);
      ArrayList <Campaings> res = new ArrayList<>();
      poadvertisersst.ifPresent(res::add);
      model.addAttribute("post", res);
		  return "advertisers-edit";    
    }

}
