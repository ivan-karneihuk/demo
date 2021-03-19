package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.models.Advertisers;
import com.example.demo.repo.AdvertisersRepository;



@Controller
@PreAuthorize("hasAuthority('Admin')")
public class AdvertisersController 
{
  @Autowired
  private AdvertisersRepository advertisersRepository;

    @GetMapping("/advertisers")
    public String Advertisers(Model model)
    {
        // Iterable<Advertisers> advertisers = advertisersRepository.findAll();
        // model.addAttribute("advertisers", advertisers); 
		  return "advertisers";   
    }

    @GetMapping("/addAdvertisers")
    public String addAdvertisers(Model model)
    {
      Iterable<Advertisers> advertisers = advertisersRepository.findAll();
      model.addAttribute("advertisers", advertisers); 
		  return "addAdvertisers";   
    }


    @GetMapping("/advertisers/id={id}")
    public String newsDetails(@PathVariable(value = "id") long id, Model model)
    {
      if(!advertisersRepository.existsById(id))
      {
        return "redirect:/advertisers";
      }
      Optional<Advertisers> advertisers = advertisersRepository.findById(id);
      ArrayList <Advertisers> res = new ArrayList<>();
      advertisers.ifPresent(res::add);
      model.addAttribute("advertisers", res);
		  return "advertisers-details";    
    }

        @GetMapping("/advertisers/{id}/edit")
    public String advertisersEdit(@PathVariable(value = "id") long id, Model model)
    {
      if(!advertisersRepository.existsById(id))
      {
        return "redirect:/advertisers";
      }
      Optional<Advertisers> poadvertisersst = advertisersRepository.findById(id);
      ArrayList <Advertisers> res = new ArrayList<>();
      poadvertisersst.ifPresent(res::add);
      model.addAttribute("post", res);
		  return "advertisers-edit";    
    }

}
