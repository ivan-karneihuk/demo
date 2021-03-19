package com.example.demo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.role.User;

public interface UserRepo extends PagingAndSortingRepository<User, Long>
{
        User findByUsername(String username);
      //  Page<User> findAll(Pageable pageable);

}
