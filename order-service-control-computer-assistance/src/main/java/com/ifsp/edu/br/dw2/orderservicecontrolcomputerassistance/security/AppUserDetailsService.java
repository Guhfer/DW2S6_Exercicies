package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.security;


import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.UserEntity;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        UserEntity user = userEntity.orElseThrow(() -> new UsernameNotFoundException("Incorrect login or password"));
        return new User(email, user.getPassword(), getPermissions(user));
    }

    private Collection<? extends GrantedAuthority> getPermissions(UserEntity userEntity) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        userEntity.getPermissions().forEach(user -> authorities.add(new SimpleGrantedAuthority(user.getDescription().toUpperCase())));
        return authorities;
    }
}
