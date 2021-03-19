package com.example.demo.service;
 import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;

import com.example.demo.models.Advertisers;
import com.example.demo.repo.UserRepo;
import com.example.demo.role.User;

@Service
public class UserService implements UserDetailsService {
    @Autowired
     private UserRepo userRepo;

     public User getCurrentUser() throws UsernameNotFoundException {
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  
         if (null == auth) {
             throw new UsernameNotFoundException("");
         }
  
         Object obj = auth.getPrincipal();
         String username = "";
  
         if (obj instanceof UserDetails) {
             username = ((UserDetails) obj).getUsername();
         } else {
             username = obj.toString();
         }
  
         User u = userRepo.findByUsername(username);
         return u;
     }


     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userRepo.findByUsername(username);

         if (user == null) {
             throw new UsernameNotFoundException("User not found");
         }

         return user;
     }

     public Page<User> getAll(Pageable pageable) {

         return (Page<User>) userRepo.findAll(pageable);
     }
   

     
}
