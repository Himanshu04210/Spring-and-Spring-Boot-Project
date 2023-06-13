package com.masai.Service;

import com.masai.Entity.Users;
import com.masai.Repository.TruckRepository;
import com.masai.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
public class UsersDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TruckRepository truckRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> opt= userRepository.findByEmail(username);
        if(opt.isPresent()) {
            Users users= opt.get();
            List<GrantedAuthority> authorities= new ArrayList<>();
            authorities.add((GrantedAuthority) users.getAuthorities());
            return new User(users.getEmail(), users.getPassword(), authorities);

        }else {
            throw new BadCredentialsException("User Details not found with this username: "+username);
        }
    }
}
