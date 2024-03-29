package com.tdtu.Cinema.Security.userprincal;

import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEnity user = userRepository.findBySdt(username).orElseThrow(()-> new UsernameNotFoundException("not found"));
        return  UserPrinciple.build(user);
    }
}
